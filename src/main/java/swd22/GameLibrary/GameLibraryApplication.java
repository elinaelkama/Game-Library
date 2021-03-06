package swd22.GameLibrary;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
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
import swd22.GameLibrary.domain.User;
import swd22.GameLibrary.domain.UserRepository;

@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(GameRepository gameRepository, PlatformRepository platformRepository, AttributeRepository attributeRepository, UserRepository userRepository) {
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
			
			Attribute attribute1 = new Attribute("Single-Player");
			Attribute attribute2 = new Attribute("Co-op");
			Attribute attribute3 = new Attribute("Role-Playing");
			Attribute attribute4 = new Attribute("First-Person");
			Attribute attribute5 = new Attribute("Fantasy");
			Attribute attribute6 = new Attribute("Sci-fi");
			Attribute attribute7 = new Attribute("Open World");
			Attribute attribute8 = new Attribute("Action");
			Attribute attribute9 = new Attribute("Adventure");
			Attribute attribute10 = new Attribute("Multiplayer");
			
			attributeRepository.save(attribute1);
			attributeRepository.save(attribute2);
			attributeRepository.save(attribute3);
			attributeRepository.save(attribute4);
			attributeRepository.save(attribute5);
			attributeRepository.save(attribute6);
			attributeRepository.save(attribute7);
			attributeRepository.save(attribute8);
			attributeRepository.save(attribute9);
			attributeRepository.save(attribute10);
			
			List<Attribute> game1Attributes = new ArrayList<>();
			game1Attributes.add(attribute2);
			game1Attributes.add(attribute5);
			
			List<Attribute> game4Attributes = new ArrayList<>();
			game4Attributes.add(attribute6);
			game4Attributes.add(attribute7);
			game4Attributes.add(attribute1);
			game4Attributes.add(attribute8);
			game4Attributes.add(attribute4);
			
			List<Attribute> game6Attributes = new ArrayList<>();
			game6Attributes.add(attribute7);
			game6Attributes.add(attribute9);
			game6Attributes.add(attribute5);
			game6Attributes.add(attribute1);
			game6Attributes.add(attribute3);
			
			List<Attribute> game5Attributes = new ArrayList<>();
			game5Attributes.add(attribute7);
			game5Attributes.add(attribute1);
			game5Attributes.add(attribute10);
			game5Attributes.add(attribute8);
			
			List<Attribute> game7Attributes = new ArrayList<>();
			game7Attributes.add(attribute1);
			game7Attributes.add(attribute3);
			game7Attributes.add(attribute5);
			game7Attributes.add(attribute8);

			Game game1 = new Game("Dead By Daylight", 2016, 18, platform1, game1Attributes);
			Game game2 = new Game("Fall Guys: Ultimate Knockout", 2020, 3, platform1);
			Game game3 = new Game("Phasmophobia", 2020, 0, platform1);
			Game game4 = new Game("Cyberpunk 2077", 2020, 18, platform2, game4Attributes);
			Game game5 = new Game("Read Dead Redemption 2", 2019, 18, platform3, game5Attributes);
			Game game6 = new Game("The Elder Scrolls IV: Oblivion", 2006, 16, platform1, game6Attributes);
			Game game7 = new Game("Jade Empire", 2007, 16, platform4, game7Attributes);
			Game game8 = new Game("Assassin's Creed", 2007, 18, platform5);
			
			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);
			gameRepository.save(game4);
			gameRepository.save(game5);
			gameRepository.save(game6);
			gameRepository.save(game7);
			gameRepository.save(game8);
			
			User user1 = new User("elina", "$2a$10$3TqmIoCss2ezHiUifteKf.tMbMtpUFlU9lCErNbVSrm94Gl5Z..Da", "ADMIN");
			User user2 = new User("teacher", "$2a$10$WiIjuE8c4D/T2XGIhjWA.OGaLzjR3kAAQ5X1YAeAsjp16Yh4U0JXy", "ADMIN");
			
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}
}
