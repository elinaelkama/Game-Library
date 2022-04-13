package swd22.GameLibrary.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd22.GameLibrary.domain.Attribute;
import swd22.GameLibrary.domain.AttributeRepository;

@CrossOrigin
@Controller
public class AttributeController {

	@Autowired
	AttributeRepository attributeRepository;
	
	@RequestMapping(value="/attributes", method = RequestMethod.GET)
	public String getAttributes(@Valid Model model) {
		model.addAttribute("attributes", attributeRepository.findAll());
		return "attributes";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addattribute", method = RequestMethod.GET)
	public String addAttribute(@Valid Model model) {
		model.addAttribute("attribute", new Attribute());
		return "addattribute";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/saveattribute", method = RequestMethod.POST)
	public String saveAttribute(@Valid Attribute attribute) {
		if (attribute.getName() != "" || attribute.getName() != null) {
			attributeRepository.save(attribute);
		}
		return "redirect:/attributes";
	}
	
	
}
