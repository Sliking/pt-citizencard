package pt.link.citizencard.ptcitizencard.cardreader;

import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pteidlib.PTEID_ADDR;
import pteidlib.PTEID_Certif;
import pteidlib.PTEID_ID;
import pteidlib.PTEID_Pin;
import pteidlib.PteidException;
import pteidlib.pteid;

/**
 *
 * @author Miguel Pinto
 */
public class CitizenCard {
    
    private String birthDate;
    private String deliveryEntity;
    private String cardNumber;
    private String cardNumberPAN;
    private String cardVersion;
    private String country;
    private String documentType;
    private String firstname;
    private String firstnameFather;
    private String firstnameMother;
    private String height;
    private String locale;
    private String mrz1;
    private String mrz2;
    private String mrz3;
    private String name;
    private String nameFather;
    private String nameMother;
    private String nationality;
    private String notes;
    private String numBI;
    private String numNIF;
    private String numSNS;
    private String sex;
    private String validityDate;
    private String numSS;
    private String deliveryDate;
    private String addrType;
    private String street;
    private String municipality;
    private String addressF;
    private String building;
    private String buildingAbbr;
    private String countryM;
    private String countryDescF;
    private String cp3;
    private String cp4;
    private String district;
    private String districtDesc;
    private String door;
    private String floor;
    private String freguesia;
    private String freguesiaDesc;
    private String locality;
    private String localityF;
    private String municipalityDesc;
    private String numMor;
    private String numMorF;
    private String postal;
    private String postalF;
    private String place;
    private String regioF;
    private String side;
    private String streettype;
    private String streettypeAbbr;
    private String cityF;
    private int authPinTriesLeft;
    private int sigPinTriesLeft;
    private int addrPinTriesLeft;
    private String addr = null;
    private PTEID_Certif[] certs;
    
    public PTEID_Certif[] getCerts() {
		return certs;
	}
    
    public String getBirthDate() {
        return birthDate;
    }

    public String getDeliveryEntity() {
        return deliveryEntity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardNumberPAN() {
        return cardNumberPAN;
    }

    public String getCardVersion() {
        return cardVersion;
    }

    public String getCountry() {
        return country;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFirstnameFather() {
        return firstnameFather;
    }

    public String getFirstnameMother() {
        return firstnameMother;
    }

    public String getHeight() {
        return height;
    }

    public String getLocale() {
        return locale;
    }

    public String getMrz1() {
        return mrz1;
    }

    public String getMrz2() {
        return mrz2;
    }

    public String getMrz3() {
        return mrz3;
    }

    public String getName() {
        return name;
    }

    public String getNameFather() {
        return nameFather;
    }

    public String getNameMother() {
        return nameMother;
    }

    public String getNationality() {
        return nationality;
    }

    public String getNotes() {
        return notes;
    }

    public String getNumBI() {
        return numBI;
    }

    public String getNumNIF() {
        return numNIF;
    }

    public String getNumSNS() {
        return numSNS;
    }

    public String getSex() {
        return sex;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public String getNumSS() {
        return numSS;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getAddrType() {
        return addrType;
    }

    public String getStreet() {
        return street;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getAddressF() {
        return addressF;
    }

    public String getBuilding() {
        return building;
    }

    public String getBuildingAbbr() {
        return buildingAbbr;
    }

    public String getCountryM() {
        return countryM;
    }

    public String getCountryDescF() {
        return countryDescF;
    }

    public String getCp3() {
        return cp3;
    }

    public String getCp4() {
        return cp4;
    }

    public String getDistrict() {
        return district;
    }

    public String getDistrictDesc() {
        return districtDesc;
    }

    public String getDoor() {
        return door;
    }

    public String getFloor() {
        return floor;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public String getFreguesiaDesc() {
        return freguesiaDesc;
    }

    public String getLocality() {
        return locality;
    }

    public String getLocalityF() {
        return localityF;
    }

    public String getMunicipalityDesc() {
        return municipalityDesc;
    }

    public String getNumMor() {
        return numMor;
    }

    public String getNumMorF() {
        return numMorF;
    }

    public String getPostal() {
        return postal;
    }

    public String getPostalF() {
        return postalF;
    }

    public String getPlace() {
        return place;
    }

    public String getRegioF() {
        return regioF;
    }

    public String getSide() {
        return side;
    }

    public String getStreettype() {
        return streettype;
    }

    public String getStreettypeAbbr() {
        return streettypeAbbr;
    }

    public String getCityF() {
        return cityF;
    }

    public int getAuthPinTriesLeft() {
        return authPinTriesLeft;
    }

    public int getSigPinTriesLeft() {
        return sigPinTriesLeft;
    }

    public int getAddrPinTriesLeft() {
        return addrPinTriesLeft;
    }

    public String getAddr() {
        return addr;
    }
    
    /**
     * Function to load the library verifying if it loaded with success
     * @return
     * @throws UnsatisfiedLinkError 
     */
    @SuppressWarnings("unchecked")
	public static boolean loadPteidLib() throws UnsatisfiedLinkError {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() {
            public Boolean run() {
              try {
                System.loadLibrary("pteidlibj");
                return true;
              } catch (UnsatisfiedLinkError t) {
                if (t.getMessage().contains("already loaded")) {
                  JOptionPane.showMessageDialog(null, "Biblioteca do Cartão de Cidadão bloqueada.", "Biblioteca bloqueada", JOptionPane.ERROR_MESSAGE);
                } else {
                  JOptionPane.showMessageDialog(null, "Middleware do Cartão de Cidadão não está instalado.", "Aplicação não está instalada", JOptionPane.ERROR_MESSAGE);
                }
                return false;
              }
            }
          }));
    }
    
    
    
    public boolean getData() throws PteidException {
        try {
        pteid.Init("");

        pteid.SetSODChecking(false);
        
        PTEID_ID idData = pteid.GetID();
        if (null != idData) {
          this.deliveryEntity = idData.deliveryEntity;
          this.birthDate = idData.birthDate;
          this.cardNumber = idData.cardNumber;
          this.cardNumberPAN = idData.cardNumberPAN;
          this.cardVersion = idData.cardVersion;
          this.country = idData.country;
          this.documentType = idData.documentType;
          this.firstname = idData.firstname;
          this.firstnameFather = idData.firstnameFather;
          this.firstnameMother = idData.firstnameMother;
          this.height = idData.height;
          this.locale = idData.locale;
          this.mrz1 = idData.mrz1;
          this.mrz2 = idData.mrz2;
          this.mrz3 = idData.mrz3;
          this.name = idData.name;
          this.nameFather = idData.nameFather;
          this.nameMother = idData.nameMother;
          this.nationality = idData.nationality;
          this.notes = idData.notes;
          this.numBI = idData.numBI;
          this.numNIF = idData.numNIF;
          this.numSNS = idData.numSNS;
          this.sex = idData.sex;
          this.validityDate = idData.validityDate;
          this.numSS = idData.numSS;
          this.deliveryDate = idData.deliveryDate;

          //Read Certificates
          this.certs = pteid.GetCertificates();

          PTEID_Pin[] pin = pteid.GetPINs();
          this.authPinTriesLeft = pin[0].triesLeft;
          this.sigPinTriesLeft = pin[1].triesLeft;
          this.addrPinTriesLeft = pin[2].triesLeft;
        }

        }catch (PteidException ex) {
          int errorNumber = Integer.parseInt(ex.getMessage().split("Error code : -")[1]);
          errorCC(errorNumber, ex.getMessage());
          return false;
        } finally {
          pteid.Exit(0);
        }
        return true;
    }
    
    public boolean getAddress() throws PteidException {
        try {
          pteid.Init("");
          pteid.SetSODChecking(false);
          PTEID_ADDR adData = pteid.GetAddr();
          if (null != adData) {
            if ("N".equals(adData.addrType)) {
              this.addrType = "Nacional";
              this.district = adData.district;
              this.districtDesc = adData.districtDesc;
              this.municipality = adData.municipality;
              this.municipalityDesc = adData.municipalityDesc;
              this.freguesia = adData.freguesia;
              this.freguesiaDesc = adData.freguesiaDesc;
              this.streettypeAbbr = adData.streettypeAbbr;
              this.streettype = adData.streettype;
              this.street = adData.street;
              this.buildingAbbr = adData.buildingAbbr;
              this.building = adData.building;
              this.door = adData.door;
              this.floor = adData.floor;
              this.side = adData.side;
              this.place = adData.place;
              this.locality = adData.locality;
              this.cp3 = adData.cp3;
              this.cp4 = adData.cp4;
              this.postal = adData.postal;
              this.country = adData.country;
              this.numMor = adData.numMor;
            } else {
              this.addrType = "Internacional";
              this.district = adData.district;
              this.districtDesc = adData.districtDesc;
              this.municipality = adData.municipality;
              this.municipalityDesc = adData.municipalityDesc;
              this.freguesia = adData.freguesia;
              this.freguesiaDesc = adData.freguesiaDesc;
              this.streettypeAbbr = adData.streettypeAbbr;
              this.streettype = adData.streettype;
              this.street = adData.street;
              this.buildingAbbr = adData.buildingAbbr;
              this.building = adData.building;
              this.door = adData.door;
              this.floor = adData.floor;
              this.side = adData.side;
              this.place = adData.place;
              this.locality = adData.localityF;
              this.cp3 = adData.cp3;
              this.cp4 = adData.cp4;
              this.postal = adData.postalF;
              this.country = adData.countryDescF;
              this.countryDescF = adData.countryDescF;
              this.addressF = adData.addressF;
              this.cityF = adData.cityF;
              this.numMor = adData.numMorF;
              this.regioF = adData.regioF;
            }
          }
        } catch (PteidException ex) {
          int errorNumber = Integer.parseInt(ex.getMessage().split("Error code : -")[1]);
          errorCC(errorNumber, ex.getMessage());
          return false;
        } finally {
          pteid.Exit(0);
        }
        return true;
    }
    
	public void errorCC(int errorNumber, String ex) {
	  String message;
	  switch (errorNumber) {
	    case 1101:
	      message = ("Erro desconhecido - Problemas com o serviço de leitor de cartões \nMessage: " + ex);
	      errorMessage(message);
	      break;
	    case 1104:
	      message = ("Não foi possível aceder ao cartão.\nVerifique se está corretamente inserido no leitor");
	      errorMessage(message);
	      break;
	    case 1109:
	      message = ("Acão cancelada pelo utilizador");
	      errorMessage(message);
	      break;
	    case 12109:
	      message = ("Não é permitido.");
	      errorMessage(message);
	      break;
	    case 1210:
	      message = ("O cartão inserido não corresponde a um cartão de cidadão válido.");
	      errorMessage(message);
	      break;
	    case 1212:
	      message = ("Pin de morada bloqueado. Resta(m) 0 tentativa(s).\n" + ex);
	      errorMessage(message);
	      break;
	    case 1214:
	      message = ("Pin inválido, não tente novamente.\n" + ex);
	      errorMessage(message);
	      break;
	    case 1304:
	      message = ("Pin inválido, não tente novamente.\n" + ex);
	      errorMessage(message);
	      break;
	    default:
	      message = ("Erro desconhecido: " + ex);
	      errorMessage(message);
	      break;
	  }
	}
	
	public static void errorMessage(String message){
	        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
	    }
	
	public String toString(){
	    return "FirstName: " + getFirstname() + "\n" + "Address pin tries: " + getAddrPinTriesLeft() + "\n" +
	            "Birthday: " + getBirthDate() + "\n" + "Card Number: " + getCardNumber() + "\n";
	}
	
	public boolean verifyPin(String loginpin) throws PteidException{
		try {
			pteid.Init("");
	        pteid.SetSODChecking(false);
			PTEID_Pin[] pin = pteid.GetPINs();
			if(pteid.VerifyPIN(pin[0].id, loginpin) > 0)
				return true;
		} catch (PteidException e) {
			e.printStackTrace();
		}finally{
			pteid.Exit(0);
		}
		
		return false;

	}

}
