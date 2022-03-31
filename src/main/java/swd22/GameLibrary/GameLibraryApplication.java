package swd22.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd22.GameLibrary.domain.Game;
import swd22.GameLibrary.domain.GameRepository;

@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameRepository gamerepo) {
		return (args) -> {
			Game game1 = new Game("Dead By Daylight", 2016, 18);
			Game game2 = new Game("Animal Crossing: New Horizons", 2020, 3);
			Game game3 = new Game("Tabletop Simulator", 2015, 0);
			
			gamerepo.save(game1);
			gamerepo.save(game2);
			gamerepo.save(game3);
		};
	}
}
