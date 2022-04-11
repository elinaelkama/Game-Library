package swd22.GameLibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd22.GameLibrary.domain.Platform;
import swd22.GameLibrary.domain.PlatformRepository;

@CrossOrigin
@Controller
public class PlatformController {

	@Autowired
	PlatformRepository platformRepository;
	
	@RequestMapping(value="/platforms", method = RequestMethod.GET)
	public String getPlatforms(Model model) {
		model.addAttribute("platforms", platformRepository.findAll());
		return "platforms";
	}
	
	@RequestMapping(value="/addplatform", method = RequestMethod.GET)
	public String addPlatform(Model model) {
		model.addAttribute("platform", new Platform());
		return "addplatform";
	}
	
	@RequestMapping(value="/saveplatform", method = RequestMethod.POST)
	public String savePlatform(Platform platform) {
		if (platform.getName() != "" || platform.getName() != null) {
			platformRepository.save(platform);
		}
		return "redirect:/platforms";
	}
}
