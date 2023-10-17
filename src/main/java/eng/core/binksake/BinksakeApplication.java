package eng.core.binksake;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import eng.core.binksake.album.Album;
import eng.core.binksake.album.AlbumRepository;
import eng.core.binksake.artist.Artist;
import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.artist.ArtistRepository;
import eng.core.binksake.artist.ArtistService;
import eng.core.binksake.common.URLHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BinksakeApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BinksakeApplication.class, args);

//		ArtistDTO artistDTO = artistService.fetchArtist(1L);
//		System.out.println(artistDTO);
//		AlbumService albumService = context.getBean(AlbumService.class);
//		AlbumRepository albumRepository = context.getBean(AlbumRepository.class);
//
//
//		Album album = new Album();
//		Song song1 = new Song();
//		song1.setPath("Coming-Of-Age.mp3");
//
//		album.getSongList().add(song1);
//		albumRepository.save(album);
//
//		albumService.addAlbum(album);
	}
}
