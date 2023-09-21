package eng.core.binksake;

import eng.core.binksake.user.UserRepository;
import eng.core.binksake.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinksakeApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BinksakeApplication.class, args);
		var usersRepository = context.getBean(UserRepository.class);
		var usersService = context.getBean(UserService.class);
	}
}
