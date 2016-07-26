package pt.link.citizencard.ptcitizencard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.link.citizencard.ptcitizencard.cardreader.CitizenCard;
import pt.link.citizencard.ptcitizencard.domain.User;
import pt.link.citizencard.ptcitizencard.service.impl.CitizenCardServiceImpl;
import pteidlib.PteidException;

@Controller
public class CitizenCardController{
	
	private final Logger logger = LoggerFactory.getLogger(CitizenCardController.class);
	
	private CitizenCard cc = null;
	
	@Autowired
	private CitizenCardServiceImpl ccService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("index()");
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model){
		return "login";
	}
	
	@RequestMapping(value="/cclogin", method=RequestMethod.GET)
	public String cclogin(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "cclogin";
	}
	
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public String verify(Model model, User user){
		loadCC();
		try {
			if(cc.verifyPin(user.getPassword()))
				model.addAttribute("citizenCard", ccService.listCitizenCards());
			else
				return "cclogin";
		} catch (PteidException e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	@RequestMapping(value="/showinfo", method=RequestMethod.GET)
	public String showInfo(Model model){
		logger.debug("showInfo()");
		model.addAttribute("citizenCard", ccService.listCitizenCards());
		return "list";		
	}
	
	private void loadCC(){
		ccService.loadCC();
		cc = ccService.getCC();
	}
}
