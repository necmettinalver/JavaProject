import java.util.ArrayList;

public class Kursiyer {
	private int kursiyerID;
	private String kursiyerAdSoyad;
	private int yas;
	public ArrayList<Kurs> alinanKurslar;

	
	public Kursiyer() {
		alinanKurslar = new ArrayList<Kurs>();
	}

	public int getKursiyerID() {
		return kursiyerID;
	}
	
	public void setKursiyerID(int kursiyerID) {
		this.kursiyerID = kursiyerID;
	}
	
	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}
	
	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}
	
	public int getYas() {
		return yas;
	}
	
	public void setYas(int yas) {
		this.yas = yas;
	}
	
	public ArrayList<Kurs> getAlinanKurslar() {
		return alinanKurslar;
	}
	
	public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {
		this.alinanKurslar = alinanKurslar;
	}
	
	
}
