package swd22.GameLibrary.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd22.GameLibrary.domain.Attribute;
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
	public String getGameLibrary(@Valid Model model) {
		model.addAttribute("games", gameRepository.findAll());
		return "gamelibrary";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addgame", method = RequestMethod.GET)
	public String addGame(@Valid Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("platforms", platformRepository.findAll());
		return "addgame";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveGame(@Valid Game game) {
		if (game.getTitle() != "" && game.getTitle() != null) {
			gameRepository.save(game);
		}
		return "redirect:/gamelibrary";
	}
	
	@RequestMapping(value="/gameattributes/{id}", method = RequestMethod.GET)
	public String getGameAttributes(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Game> game = gameRepository.findById(id);
		//need to cast to object to use object functionalities
		game.ifPresent(foundGameObject -> model.addAttribute("game", foundGameObject));
		model.addAttribute("attributes", attributeRepository.findAll());
		return "gameattributes";
	}
	
	//edits
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editGame(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Game> game = gameRepository.findById(id);
		model.addAttribute("game", game);
		model.addAttribute("platforms", platformRepository.findAll());
		return "editgame";
	}
	
	//add game attributes
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addgameattribute/{id}", method = RequestMethod.GET)
	public String addGameAttributes(@PathVariable("id") Long id, @Valid Model model) {
		model.addAttribute("games", gameRepository.findAll());
		model.addAttribute("attributes", attributeRepository.findAll());
		model.addAttribute("platforms", platformRepository.findAll());
		model.addAttribute("attribute", new Attribute());
		List<Attribute> gameAttributes = new ArrayList<>();
		return "addgameattribute";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/saveattribute/{id}", method = RequestMethod.POST)
	public String saveGameAttribute(@PathVariable("id") Long id, @Valid Attribute attribute, List<Attribute> gameAttributes, @Valid Model model) {
		if (attribute.getName() != "" || attribute.getName() != null) {
			Optional<Game> game = gameRepository.findById(id);
			gameAttributes.add(attribute);
		}
		return "redirect:/gameattributes";
	}
	
	//delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long id, @Valid Model model) {
		gameRepository.deleteById(id);
		return "redirect:/gamelibrary";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
}
