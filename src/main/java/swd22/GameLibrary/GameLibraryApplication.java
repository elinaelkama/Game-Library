package swd22.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd22.GameLibrary.domain.Attribute;
import swd22.GameLibrary.domain.AttributeRepository;
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
	public CommandLineRunner demo(GameRepository gameRepository, PlatformRepository platformRepository, AttributeRepository attributeRepository) {
		return (args) -> {
			Platform platform1 = new Platform("Steam");
			Platform platform2 = new Platform("GOG Galaxy");
			Platform platform3 = new Platform("Rockstar Games Launcher");
			Platform platform4 = new Platform("Origin");
			Platform platform5 = new Platform("uPlay");
			
			
			platformRepository.save(platform1);
			platformRepository.save(platform2);
			platformRepository.save(platform3);
			platformRepository.save(platform4);
			platformRepository.save(platform5);

			Game game1 = new Game("Dead By Daylight", 2016, 18, platform1);
			Game game2 = new Game("Fall Guys: Ultimate Knockout", 2020, 3, platform1);
			Game game3 = new Game("Phasmophobia", 2020, 0, platform1);
			Game game4 = new Game("Cyberpunk 2077", 2020, 18, platform3);
			Game game5 = new Game("Read Dead Redemption 2", 2019, 18, platform4);
			
			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);
			gameRepository.save(game4);
			gameRepository.save(game5);
			
			Attribute attribute1 = new Attribute("Single-Player");
			Attribute attribute2 = new Attribute("Co-op");
			Attribute attribute3 = new Attribute("Role-Playing");
			Attribute attribute4 = new Attribute("First-Person");
			Attribute attribute5 = new Attribute("Player-versus-Player");
			
			attributeRepository.save(attribute1);
			attributeRepository.save(attribute2);
			attributeRepository.save(attribute3);
			attributeRepository.save(attribute4);
			attributeRepository.save(attribute5);
		};
	}
}
