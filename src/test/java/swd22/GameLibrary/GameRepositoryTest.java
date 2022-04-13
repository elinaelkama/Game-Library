package swd22.GameLibrary;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd22.GameLibrary.domain.Game;
import swd22.GameLibrary.domain.GameRepository;
import swd22.GameLibrary.domain.Platform;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GameRepositoryTest {
	
	@Autowired
	private GameRepository gameRepository;
	
	 @Test
	 public void findByTitle() {
		 List<Game> games = gameRepository.findByTitle("Phasmophobia");
		 assertThat(games).hasSize(1);
		 assertThat(games.get(0).getYear()).isEqualTo(2020);
	 }
	 
	 @Test
	 public void createGame(){
		 Platform platform = new Platform("RSI");
		 Game game = new Game("The Elder Scrolls IV: Oblivion", 2006, 16, platform);
		 gameRepository.save(game);
		 assertThat(game.getId()).isNotNull();
	 }
	
	 /*
	 @Test
	 public void deleteGame() {
		 Platform platform = new Platform("Marinade");
		 Game game1 = new Game("The Elder Scrolls IV: Oblivion", 2006, 16, platform);
		 Game game2 = new Game("Dragon Age: Origins", 2008, 18, platform);
		 gameRepository.save(game1);
		 gameRepository.save(game2);
		 gameRepository.deleteById(game1.getId());
		 assertThat(game1.getId()).isNull();
	 }
	 */
}

