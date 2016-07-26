package pt.link.citizencard.ptcitizencard.controller;

import java.util.List;

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
import pt.link.libraries.linktables.ui.ColumnsProperties;
import pt.link.libraries.linktables.ui.LinkTable;
import pt.link.libraries.linktables.ui.TablePopulator;
import pt.link.libraries.pagging.Page;
import pt.link.libraries.pagging.PageInfo;
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
			if(cc.verifyPin(user.getPassword())){
//				LinkTable<CitizenCard> ccs = new LinkTable<CitizenCard>("tableCC");
//				ccs.setColumnsNames(new String[]{"cardNumber", "birthDate", "country", "firstname", "nationality"});
//				ccs.addColumnProperties("cardNumber", new ColumnsProperties("cardNumber", "Card Number"));
//				ccs.addColumnProperties("birthDate", new ColumnsProperties("birthDate", "Birth Date"));
//				ccs.addColumnProperties("country", new ColumnsProperties("country", "Country"));
//				ccs.addColumnProperties("firstname", new ColumnsProperties("firstname", "Name"));
//				ccs.addColumnProperties("nationality", new ColumnsProperties("nationality", "Nationality"));
//				ccs.setTablePopulator(new CCInfoTablePopulator());
//				ccs.setIdFieldName("cardNumber");
//				model.addAttribute("citizenCard", ccs);
				
				model.addAttribute("citizenCard", ccService.listCitizenCards());
			}
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
	
	public class CCInfoTablePopulator extends TablePopulator<CitizenCard>{
		
		public CCInfoTablePopulator(){
			super();
		}
		
		@Override
		public Page<CitizenCard> getPage(int offset, int pageSize, String sortColumnName,
				String sortOrder) {
			PageInfo pageInfo = new PageInfo(offset, pageSize, sortColumnName, sortOrder);
			List<CitizenCard> ccs = ccService.listCitizenCards();
			return Page.createPageFromFullResults(ccs, pageInfo);
		}
	}

		
}
