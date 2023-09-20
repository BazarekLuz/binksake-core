package eng.core.binksake.common;

import eng.core.binksake.user.User;
import eng.core.binksake.user.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(User.class, UserDTO.class);

        return modelMapper;
    }
}
