package pt.link.citizencard.ptcitizencard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pt.link.citizencard.ptcitizencard.cardreader.CitizenCard;
import pt.link.citizencard.ptcitizencard.service.ICitizenCardService;
import pteidlib.PteidException;

@Service
public class CitizenCardServiceImpl implements ICitizenCardService{
	
	private CitizenCard cc;
	
	@Override
	public List<CitizenCard> listCitizenCards() {
		List<CitizenCard> listCC = new ArrayList<CitizenCard>();
		listCC.add(getCC());		
		return listCC;
	}
	
	public CitizenCard getCC(){
		return cc;
	}
	
	public void loadCC(){
		cc = new CitizenCard();
		try{
			CitizenCard.loadPteidLib();
			if(cc.getData())
				System.out.println("[DEBUG] Data retrieved with success");
			/*if(cc.getAddress())
				System.out.println("[DEBUG] Address retrieved with success");*/
		} catch(PteidException e){
			System.err.println("[ERROR] Failed to retrieve information from the Citizien Card");
		}
	}

}
