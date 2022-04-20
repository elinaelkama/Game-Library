package swd22.GameLibrary.web;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	

	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public String getGameLibrary(@Valid Model model) {
		model.addAttribute("games", gameRepository.findAll());
		return "gamelibrary";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/add", method = RequestMethod.GET)
	public String addGame(@Valid Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("platforms", platformRepository.findAll());
		return "addgame";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/add", method = RequestMethod.POST)
	public String addGame(@Valid Game game) {
		if (game.getTitle() != "" && game.getTitle() != null) {
			gameRepository.save(game);
		}
		return "redirect:/";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/save", method = RequestMethod.POST)
	public String saveGame(@Valid Game game) {
		Optional<Game> optGame = gameRepository.findById(game.getId());
		Game savedGame = optGame.get();
		savedGame.setTitle(game.getTitle());
		savedGame.setYear(game.getYear());
		savedGame.setAge(game.getAge());
		savedGame.setPlatform(game.getPlatform());
		savedGame.setAttributes(game.getAttributes());
		if (game.getTitle() != "" && game.getTitle() != null) {
			gameRepository.save(savedGame);
		}
		return "redirect:/";
	}
	
	//edits
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/{id}/edit", method = RequestMethod.GET)
	public String editGame(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Game> game = gameRepository.findById(id);
		game.ifPresent(foundGameObject -> model.addAttribute("game", foundGameObject));
		model.addAttribute("platforms", platformRepository.findAll());
		model.addAttribute("attributes", attributeRepository.findAll());
		return "editgame";
	}
	
	//delete
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/{id}/delete", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long id, @Valid Model model) {
		gameRepository.deleteById(id);
		return "redirect:/";
	}

	//game attributes	
	@RequestMapping(value="/game/{id}/attributes", method = RequestMethod.GET)
	public String getGameAttributes(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Game> game = gameRepository.findById(id);
		//need to cast to object to use object functionalities
		game.ifPresent(foundGameObject -> model.addAttribute("game", foundGameObject));
		model.addAttribute("attributes", attributeRepository.findAll());
		return "gameattributes";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/{id}/attributes/add", method = RequestMethod.GET)
	public String addGameAttributesForm(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Game> game = gameRepository.findById(id);
		//need to cast to object to use object functionalities
		game.ifPresent(foundGameObject -> model.addAttribute("game", foundGameObject));
		model.addAttribute("attributes", attributeRepository.findAll());
		return "addgameattribute";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/{id}/attributes/add/{attid}", method = RequestMethod.GET)
	public String addGameAttributes(@PathVariable("id") Long id, @PathVariable("attid") Long attid) {
		Game game = gameRepository.findById(id).get();
		Attribute attribute = attributeRepository.findById(attid).get();
		if (!game.hasAttribute(attribute)) {
			game.addAttribute(attribute);
			gameRepository.save(game);
		}
		return "redirect:/game/{id}/attributes";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/game/{id}/attributes/delete/{attid}", method = RequestMethod.GET)
	public String deleteGameAttributes(@PathVariable("id") Long id, @PathVariable("attid") Long attid) {
		Game game = gameRepository.findById(id).get();
		Attribute attribute = attributeRepository.findById(attid).get();
		if (game.hasAttribute(attribute)) {
			game.deleteAttribute(attribute);
			gameRepository.save(game);
		}
		return "redirect:/game/{id}/attributes";
	}
}
