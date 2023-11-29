package eng.core.binksake.playlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private Long id;
    private Long ownerId;
    private String name;
    private LocalDate dateCreated;
    private String imgUrl;
}
