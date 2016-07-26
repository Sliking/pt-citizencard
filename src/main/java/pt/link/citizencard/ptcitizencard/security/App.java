package pt.link.citizencard.ptcitizencard.security;


import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

public class App {

	private final static String PATH="C:\\Users\\Miguel Pinto\\Documents\\workspace-sts-3.6.0.RELEASE\\ptcitizencard\\src\\resources\\cckeystore";
	private final static String ALIAS="cc";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		try {
			KeyStore ks= KeyStoreUtil.getKeyStore(PATH, "cckeystore");
			System.out.println("[DEBUG] Loaded with success");		
			List<String> aliases = KeyStoreUtil.getAliases(ks);
			for(String alias : aliases){
				System.out.println(alias);
			}
			X509Certificate cert = (X509Certificate) KeyStoreUtil.getCertificate(ks, ALIAS);
			cert.checkValidity();
			PublicKey publickey = cert.getPublicKey();			
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		
		
	}
}
