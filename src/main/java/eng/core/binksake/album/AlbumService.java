package eng.core.binksake.album;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import eng.core.binksake.song.Song;
import eng.core.binksake.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    @Value("${app.file.music-file.path}")
    private String path;

    //todo get more information on how to implement this
    public void addAlbum(Album album) throws UnsupportedTagException, InvalidDataException, IOException {
        List<Song> songList = album.getSongList();
        Song song1 = songList.get(0);
        System.out.println(path);
        Mp3File file = new Mp3File(path + "/" + song1.getPath());
        if (file.hasId3v1Tag()) {
            ID3v1 tag = file.getId3v1Tag();
            System.out.println(tag.getAlbum() + "\n" + tag.getArtist());
        }


    }
}
