package pt.link.citizencard.ptcitizencard;


public class App{

//	private static PTEID_EIDCard card = null;
//	
//	public static PTEID_EIDCard getCard(){
//		return card;
//	}
//	
//    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
//        loadPteidLib();
//		CitizenCard cc = new CitizenCard();
//		try {
//			cc.getData();
//			cc.getAddress();
//			System.out.println(cc.toString());
//		} catch (PteidException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//    }
//    
//    @SuppressWarnings("unchecked")
//	public static boolean loadPteidLib() throws UnsatisfiedLinkError {
//        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() {
//            public Boolean run() {
//              try {
//                System.ldLibrary("pteidlibj");
//                return true;
//              } catch (UnsatisfiedLinkError t) {
//                if (t.getMessage().contains("already loaded")) {
//                  JOptionPane.showMessageDialog(null, "Biblioteca do Cartão de Cidadão bloqueada.", "Biblioteca bloqueada", JOptionPane.ERROR_MESSAGE);
//                } else {
//                  JOptionPane.showMessageDialog(null, "Middleware do Cartão de Cidadão não está instalado.", "Aplicação não está instalada", JOptionPane.ERROR_MESSAGE);
//                }
//                return false;
//              }
//            }
//          }));
//    }
//    
////    private static void Pins(){
////    	getCard().getPins().getPinByPinRef(PTEID_Pin.AUTH_PIN).verifyPin("", new PTEID_ulwrapper(-1), false);
////    }
    
   
}
