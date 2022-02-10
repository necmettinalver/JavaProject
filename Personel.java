
public class Personel extends Departman {
	private int perID;
	private String perAd;
	private String perSoyad;
	private int perYas;
	public Personel(int depNo ,int perID, String perAd, String perSoyad,
			int perYas) {
		super(depNo);
		this.perID = perID;
		this.perAd = perAd;
		this.perSoyad = perSoyad;
		this.perYas = perYas;
	}
	
	
}
