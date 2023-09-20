package eng.core.binksake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinksakeApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BinksakeApplication.class, args);
	}
}
