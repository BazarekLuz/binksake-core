package eng.core.binksake.album;

import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.AlbumNotFoundException;
import eng.core.binksake.song.SongDTO;
import eng.core.binksake.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final AutoMapper autoMapper;
    @Value("${app.file.music-file.path}")
    private String path;

    AlbumDTO fetchAlbumDetails(Long id) {
        return autoMapper.mapToAlbumDTO(albumRepository.findById(id)
                .orElseThrow(AlbumNotFoundException::new));
    }

    List<SongDTO> fetchAlbumSongs(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(AlbumNotFoundException::new);
        return album.getSongList().stream()
                .map(autoMapper::mapToSongDTO)
                .toList();
    }

    //todo get more information on how to implement this
//    public void addAlbum(Album album) throws UnsupportedTagException, InvalidDataException, IOException {
//        List<Song> songList = album.getSongList();
//        Song song1 = songList.get(0);
//        System.out.println(path);
//        Mp3File file = new Mp3File(path + "/" + song1.getPath());
//        if (file.hasId3v1Tag()) {
//            ID3v1 tag = file.getId3v1Tag();
//            System.out.println(tag.getAlbum() + "\n" + tag.getArtist());
//        }
//    }
}
