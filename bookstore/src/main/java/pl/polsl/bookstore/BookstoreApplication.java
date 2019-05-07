package pl.polsl.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/*
  ____   ____   ____  _  __ _____ _______ ____  _____  ______
 |  _ \ / __ \ / __ \| |/ // ____|__   __/ __ \|  __ \|  ____|
 | |_) | |  | | |  | | ' /| (___    | | | |  | | |__) | |__
 |  _ <| |  | | |  | |  <  \___ \   | | | |  | |  _  /|  __|
 | |_) | |__| | |__| | . \ ____) |  | | | |__| | | \ \| |____
 |____/ \____/ \____/|_|\_\_____/   |_|  \____/|_|  \_\______|


 */

@SpringBootApplication
public class BookstoreApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookstoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
