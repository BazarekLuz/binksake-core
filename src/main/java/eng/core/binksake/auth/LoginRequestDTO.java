package eng.core.binksake.auth;

import eng.core.binksake.common.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDTO {

    @NotNull(message = ErrorMessages.EMAIL_IS_REQUIRED)
    private String email;

    @NotNull(message = ErrorMessages.PASSWORD_IS_REQUIRED)
    private String password;
}
