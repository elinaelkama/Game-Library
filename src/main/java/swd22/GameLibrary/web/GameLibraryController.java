package swd22.GameLibrary.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd22.GameLibrary.domain.AttributeRepository;
import swd22.GameLibrary.domain.Game;
import swd22.GameLibrary.domain.GameRepository;
import swd22.GameLibrary.domain.PlatformRepository;

@CrossOrigin
@Controller
public class GameLibraryController {
	
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private PlatformRepository platformRepository;
	@Autowired
	private AttributeRepository attributeRepository;
	
	

	@RequestMapping(value={"/", "/gamelibrary"}, method = RequestMethod.GET)
	public String getGameLibrary(Model model) {
		model.addAttribute("games", gameRepository.findAll());
		return "gamelibrary";
	}
	
	@RequestMapping(value="/addgame", method = RequestMethod.GET)
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("platforms", platformRepository.findAll());
		return "addgame";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveGame(Game game) {
		if (game.getTitle() != "" && game.getTitle() != null) {
			gameRepository.save(game);
		}
		return "redirect:/gamelibrary";
	}
	
	@RequestMapping(value="/gameattributes/{id}", method = RequestMethod.GET)
	public String getGameAttributes(@PathVariable("id") Long id, Model model) {
		Optional<Game> game = gameRepository.findById(id);
		//need to cast to object to use object functionalities
		game.ifPresent(foundGameObject -> model.addAttribute("game", foundGameObject));
		model.addAttribute("attributes", attributeRepository.findAll());
		return "gameattributes";
	}
	
	//edit
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editGame(@PathVariable("id") Long id, Model model) {
		Optional<Game> game = gameRepository.findById(id);
		model.addAttribute("game", game);
		model.addAttribute("platforms", platformRepository.findAll());
		return "editgame";
	}
	
	@RequestMapping(value="/addgameattribute/{id}", method = RequestMethod.GET)
	public String editGameAttributes(@PathVariable("id") Long id, Model model) {
		Optional<Game> game = gameRepository.findById(id);
		//need to cast to object to use game.title in header
		game.ifPresent(foundGameObject -> model.addAttribute("game", foundGameObject));
		model.addAttribute("attributes", attributeRepository.findAll());
		return "addgameattribute";
	}
	
	//delete
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long id, Model model) {
		gameRepository.deleteById(id);
		return "redirect:/gamelibrary";
	}
	
	//to be implemented with security
	//@RequestMapping(value="/login")
	//public String login() {
	//	return "login";
	//}
	
	//add REST
}
