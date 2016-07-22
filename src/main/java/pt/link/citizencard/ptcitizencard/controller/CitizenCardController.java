package pt.link.citizencard.ptcitizencard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.link.citizencard.ptcitizencard.service.impl.CitizenCardServiceImpl;

@Controller
public class CitizenCardController {

	private final Logger logger = LoggerFactory.getLogger(CitizenCardController.class);
	
	@Autowired
	private CitizenCardServiceImpl ccService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("index()");
		return "redirect:/showinfo";
	}
	
	@RequestMapping(value="/showinfo", method=RequestMethod.GET)
	public String showInfo(Model model){
		logger.debug("showInfo()");
		model.addAttribute("citizenCard", ccService.listCitizenCards());
		return "list";		
	}
}
