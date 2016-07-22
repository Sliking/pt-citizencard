package pt.link.citizencard.ptcitizencard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pt.link.citizencard.ptcitizencard.cardreader.CitizenCard;
import pt.link.citizencard.ptcitizencard.service.ICitizenCardService;
import pteidlib.PTEID_Certif;
import pteidlib.PteidException;

@Service
public class CitizenCardServiceImpl implements ICitizenCardService{
	
	@Override
	public List<CitizenCard> listCitizenCards() {
		List<CitizenCard> listCC = new ArrayList<CitizenCard>();
		listCC.add(loadCC());		
		return listCC;
	}
	
	private CitizenCard loadCC(){
		CitizenCard cc = new CitizenCard();
		CitizenCard.loadPteidLib();
		try{
			cc.getData();
			cc.getAddress();
		} catch(PteidException e){
			System.err.println("[ERROR] Failed to retrieve information from the Citizien Card");
		}
		
		return cc;
	}

}
