
public class Departman {
	private static int depNo;
	private String depAd;
	public Personel[] per;
	public Servis[] ser;
	
	public Departman(int depNo, String depAd, Personel[] per, Servis[] ser) {
		this.depNo = depNo;
		this.depAd = depAd;
		this.per = per;
		this.ser = ser;
	}	
			
	
}
