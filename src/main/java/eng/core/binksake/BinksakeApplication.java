package eng.core.binksake;

import eng.core.binksake.user.User;
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

		User user = new User();
		user.setEmail("test@test.com");
		user.setName("bazarski");
		user.setPassword("password");
		usersRepository.save(user);

//		System.out.println(usersService.findUserById(1L));
	}
}
