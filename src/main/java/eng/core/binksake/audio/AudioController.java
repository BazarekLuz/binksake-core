package eng.core.binksake.audio;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("api/audio")
public class AudioController {
   public static final String AUDIO_PATH = "music-upload";

   public static final int BYTE_RANGE = 128;

//   @GetMapping("/{filename}")
//    public Mono<ResponseEntity<byte[]>> streamAudio(
//           @RequestHeader(value="Range", required = false) String httpRangeList,
//           @PathVariable String filename) {
//       return Mono.just(getContent(AUDIO_PATH, filename, httpRangeList, "audio"));
//   }
    @GetMapping("/{filename}")
    private ResponseEntity<byte[]> getAudioFile(@PathVariable String filename) {
        String path = AUDIO_PATH + "/" + filename;

        File file = new File(path);

        if (!file.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] audioData = StreamUtils.copyToByteArray(fileInputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData(filename, filename);

            return new ResponseEntity<>(audioData, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   private ResponseEntity<byte[]> getContent(String location,
                                             String fileName,
                                             String range,
                                             String contentTypePrefix) {
       long rangeStart = 0;
       long rangeEnd;
       byte[] data;
       Long fileSize;
       String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
       try {
           fileSize = Optional.of(fileName)
                   .map(file -> Paths.get(getFilePath(location), file))
                   .map(this::sizeFromFile)
                   .orElse(0L);
           if (range == null) {
               return ResponseEntity.status(HttpStatus.OK)
                       .header("Content-Type", contentTypePrefix + "/" + fileType)
                       .header("Content-Length", String.valueOf(fileSize))
                       .body(readByteRange(location, fileName, rangeStart, fileSize - 1));
           }
           String[] ranges = range.split("-");
           rangeStart = Long.parseLong(ranges[0].substring(6));
           if (range.length() > 1) {
               rangeEnd = Long.parseLong(ranges[1]);
           } else {
               rangeEnd = fileSize - 1;
           }
           data = readByteRange(location, fileName, rangeStart, rangeEnd);
       } catch (IOException e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }

       String contentLength = String.valueOf((rangeEnd - rangeStart) + 1);
       return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
               .header("Content-Type", contentTypePrefix + "/" + fileType)
               .header("Accept-Ranges", "bytes")
               .header("Content-Length", contentLength)
               .header("Content-Range", "bytes" + " " + rangeStart + "-" + rangeEnd + "/" + fileSize)
               .body(data);
   }

   public byte[] readByteRange(String location, String fileName, long start, long end) throws IOException {
       Path path = Paths.get(getFilePath(location), fileName);
       try (InputStream inputStream = (Files.newInputStream(path));
            ByteArrayOutputStream bufferedOutputStream = new ByteArrayOutputStream()) {
           byte[] data = new byte[BYTE_RANGE];
           int nRead;
           while((nRead = inputStream.read(data, 0, data.length)) != -1) {
               bufferedOutputStream.write(data, 0, nRead);
           }
           bufferedOutputStream.flush();
           byte[] result = new byte[(int) (end-start) + 1];
           System.arraycopy(bufferedOutputStream.toByteArray(), (int) start, result, 0, result.length);
           return result;
       }
   }

   private String getFilePath(String location) {
       File file = new File(location);
       return file.getAbsolutePath();
   }

   private Long sizeFromFile(Path path) {
       try {
           return Files.size(path);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return 0L;
   }
}
