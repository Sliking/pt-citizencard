package pt.link.citizencard.ptcitizencard.domain;

import pt.link.citizencard.ptcitizencard.cardreader.CitizenCard;

public class User {

	private CitizenCard cc;
	private String username;
	private String password;
	
	public CitizenCard getCc() {
		return cc;
	}
	public void setCc(CitizenCard cc) {
		this.cc = cc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
