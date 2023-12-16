package eng.core.binksake.album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchAlbumDTO {
    private Long id;
    private String name;
    private Date dateCreated;
    private String imgUrl;
}
