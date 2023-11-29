package eng.core.binksake.playlist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPlaylistDTO {
    private Long ownerId;
    private String name;
}
