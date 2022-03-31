package swd22.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd22.GameLibrary.domain.Game;
import swd22.GameLibrary.domain.GameRepository;
import swd22.GameLibrary.domain.Platform;
import swd22.GameLibrary.domain.PlatformRepository;

@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameRepository gamerepo, PlatformRepository platrepo) {
		return (args) -> {
			Platform platform1 = new Platform("Steam");
			Platform platform2 = new Platform("Nintendo Switch");
			Platform platform3 = new Platform("GOG Galaxy");
			Platform platform4 = new Platform("Rockstar Games Launcher");
			
			
			platrepo.save(platform1);
			platrepo.save(platform2);
			platrepo.save(platform3);
			platrepo.save(platform4);
			
			Game game1 = new Game("Dead By Daylight", 2016, 18, platform1);
			Game game2 = new Game("Animal Crossing: New Horizons", 2020, 3, platform2);
			Game game3 = new Game("Phasmophobia", 2020, 0, platform1);
			Game game4 = new Game("Cyberpunk 2077", 2020, 18, platform3);
			Game game5 = new Game("Read Dead Redemption 2", 2019, 18, platform4);
			
			gamerepo.save(game1);
			gamerepo.save(game2);
			gamerepo.save(game3);
			gamerepo.save(game4);
			gamerepo.save(game5);
		};
	}
}
