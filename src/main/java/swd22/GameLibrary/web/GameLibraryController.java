package swd22.GameLibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd22.GameLibrary.domain.Game;
import swd22.GameLibrary.domain.GameRepository;
import swd22.GameLibrary.domain.PlatformRepository;

@CrossOrigin
@Controller
public class GameLibraryController {
	
	@Autowired
	private GameRepository gamerepo;
	@Autowired
	private PlatformRepository platrepo;

	
	

	@RequestMapping(value={"/", "/gamelib"}, method = RequestMethod.GET)
	public String getGameLibrary(Model model) {
		model.addAttribute("games", gamerepo.findAll());
		return "gamelib";
	}
	
	@RequestMapping(value="/addgame", method = RequestMethod.GET)
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("platforms", platrepo.findAll());
		return "addgame";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveGame(Game game) {
		if (game.getTitle() != "" && game.getTitle() != null) {
			gamerepo.save(game);
		}
		return "redirect:/gamelib";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}
