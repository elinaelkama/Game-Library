package swd22.GameLibrary.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class LanguageController {

	@RequestMapping(value="/?language=fi")
	public String changeLanguageFi(){
		return "redirect:/gamelibrary";
	}
	
	@RequestMapping(value="/?language=en")
	public String changeLanguageEn(){
		return "redirect:/gamelibrary";
	}
}
