package swd22.GameLibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd22.GameLibrary.domain.GameRepository;

@CrossOrigin
@Controller
public class GameLibraryController {
	
	@Autowired
	private GameRepository gamerepo;

	@RequestMapping(value={"/", "/gamelib"}, method = RequestMethod.GET)
	public String getGameLibrary(Model model) {
		model.addAttribute("games", gamerepo.findAll());
		return "gamelib";
	}
}
