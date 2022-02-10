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

public class Kurs {
	private int kursID;
	private String kursAd;

	public int getKursID() {
		return kursID;
	}
	
	public void setKursID(int kursID) {
		this.kursID = kursID;
	}
	
	public String getKursAd() {
		return kursAd;
	}
	
	public void setKursAd(String kursAd) {
		this.kursAd = kursAd;
	}
	
}
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Anasayfa {
	static ArrayList<Kursiyer> Kursiyerler = new ArrayList<Kursiyer>();
	static ArrayList<Kurs> Kurslar = new ArrayList<Kurs>();
	
	public static void KursEkle(){
		int kursID;
		String kursAd;
		Boolean kontrol=true;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Kaydetmek istedi�iniz Kursun ID'sini giriniz: ");
		kursID=scan.nextInt();
		
		System.out.print("Kaydetmek istedi�iniz Kursun ad�n� giriniz : ");
		scan.nextLine();
		kursAd=scan.nextLine();
		
		if(Kurslar.size()==0) {
			Kurs kurs = new Kurs();
			kurs.setKursID(kursID);
			kurs.setKursAd(kursAd);
			Kurslar.add(kurs);
		}
		else {
			for(int i=0;i<Kurslar.size();i++) {
				if(Kurslar.get(i).getKursID()==kursID) {
					System.out.println("\nEkledi�iniz Id numaras�nda farkl� bir kurs bulunmaktad�r.");
					kontrol=false;
				}
			}
			if(kontrol) {
				Kurs kurs = new Kurs();
				kurs.setKursID(kursID);
				kurs.setKursAd(kursAd);
				Kurslar.add(kurs);
				}
		}
		System.out.println("");
	}
	
	public static void KursListeleme(){
		
		if(Kurslar.size()==0) {
			System.out.println("Kurs listesi bo�...\n");
		}
		else{
			System.out.println("Kurs listesi :");
			System.out.println("Kurs Id"+ "\t"+ "Kurs Ad�");
			for(Kurs kurs:Kurslar) {
				System.out.println(kurs.getKursID()+"\t"+kurs.getKursAd());
			}
		}
		System.out.println("");
	}
	
	public static void kursiyerEkle() {
		
		Scanner scan = new Scanner(System.in);
		String kursiyerAS,kursAd;
		int kursiyerId,kursId,kursiyerYas,kursSayisi;
		boolean kontrol1=true;//kursiyerler aras� kontrol� sa�l�ycak
		boolean kontrol2=true;//kursiyer i�inde kurs kontrol� yap�cak
		boolean kursKontrol=false;//kurs kayd� olmayan kursiyeri listeye eklemeyecek
		
		if(Kursiyerler.size()==0) {
			System.out.print("Kursiyerin ID'sini giriniz : ");
			kursiyerId=scan.nextInt();
			
			System.out.print("Kursiyerin ad�n� ve soyad�n� giriniz : ");
			scan.nextLine();
			kursiyerAS=scan.nextLine();
			
			System.out.print("Kursiyerin ya��n� giriniz : ");
			kursiyerYas=scan.nextInt();
			
			Kursiyer kursiyer =new Kursiyer();
			kursiyer.setKursiyerID(kursiyerId);
			kursiyer.setKursiyerAdSoyad(kursiyerAS);
			kursiyer.setYas(kursiyerYas);
			
			System.out.println("");
			
			System.out.print("Kursiyerin kurs say�s�n� giriniz: ");
			kursSayisi=scan.nextInt();
			
			for(int j=0;j<kursSayisi;j++){
				System.out.println("");
				boolean kontrol3=true;
				
				System.out.print((j+1)+". Kursun ID'sini giriniz: ");
				kursId=scan.nextInt();
				
				System.out.print((j+1) + ". Kursun ad�n� giriniz : ");
				scan.nextLine();
				kursAd=scan.nextLine();
				for(Kurs kkurs :kursiyer.alinanKurslar) {					
					if(kkurs.getKursID()==kursId) {
						if(kkurs.getKursAd().equals(kursAd)){
							System.out.println("Kursiyerde var olan Id'de kurs giri�i yapt�n�z.");
						}	
						kontrol3=false;
					}
				}
				if(kontrol3) {
					Kurs kurs = new Kurs();
					kurs.setKursID(kursId);
					kurs.setKursAd(kursAd);	
					kursiyer.alinanKurslar.add(kurs);
					kursKontrol=true;
				}
				
			}
			if(kursKontrol) {
				Kursiyerler.add(kursiyer);
				System.out.println("\nKursiyer kaydedildi");
			}
			else {
				System.out.println("\nKursiyer kaydedilemedi");
			}
		}
		
		else {
			System.out.print("Kursiyerin ID'sini giriniz : ");
			kursiyerId=scan.nextInt();
			
			for(Kursiyer kursiyer:Kursiyerler) {
				if(kursiyer.getKursiyerID()==kursiyerId) {
					System.out.println("Ayn� Id'ye sahip kursiyer bulunmaktad�r.");
					kontrol1=false;
				}
			}
			if(kontrol1) {
				System.out.print("Kursiyerin ad�n� ve soyad�n� giriniz : ");
				scan.nextLine();
				kursiyerAS=scan.nextLine();
				
				System.out.print("Kursiyerin ya��n� giriniz : ");
				kursiyerYas=scan.nextInt();
				
				Kursiyer kursiyer =new Kursiyer();
				kursiyer.setKursiyerID(kursiyerId);
				kursiyer.setKursiyerAdSoyad(kursiyerAS);
				kursiyer.setYas(kursiyerYas);
				
				System.out.println("");
				
				System.out.print("Kursiyerin kurs say�s�n� giriniz: ");
				kursSayisi=scan.nextInt();

				for(int j=0;j<kursSayisi;j++){
					System.out.println("");
					boolean kontrol3=true;
					
					System.out.print((j+1)+". Kursun ID'sini giriniz: ");
					kursId=scan.nextInt();
					
					System.out.print((j+1) + ". Kursun ad�n� giriniz : ");
					scan.nextLine();
					kursAd=scan.nextLine();
					
					for(Kursiyer tempKursiyer : Kursiyerler) {
						for(Kurs tempKurs : tempKursiyer.alinanKurslar) {
							if(tempKurs.getKursID()==kursId && !tempKurs.getKursAd().equals(kursAd)) {
								System.out.println("Var olan Id numaras�yla Farkl� kurs giri�i yapt�n�z. ");
								kontrol2=false;
							}
							if(kontrol2==false) {
								break;
							}
						}
					}
					for(Kurs kkurs :kursiyer.alinanKurslar) {					
						if(kkurs.getKursID()==kursId ) {
							if(kkurs.getKursAd().equals(kursAd)){
								System.out.println("Kursiyerde var olan Id'de kurs giri�i yapt�n�z.");
							}	
							kontrol3=false;
						}
					}
					if(kontrol2 && kontrol3) {
						Kurs kurs = new Kurs();
						kurs.setKursID(kursId);
						kurs.setKursAd(kursAd);
						kursiyer.alinanKurslar.add(kurs);
						kursKontrol=true;
					}
				}
				if(kursKontrol) {
					Kursiyerler.add(kursiyer);
					System.out.println("\nKursiyer kaydedildi");
				}
				else {
					System.out.println("\nKursiyer kaydedilemedi");
				}
			}
		}	
		System.out.println("");
	}
	public static void KursiyerArama(String kursiyerAdSoyad){
		Boolean kontrol=true;
		if(Kursiyerler.size()==0) {
			System.out.println("\nKursiyer listesi bo�...");
		}
		else{
			for(Kursiyer kursiyer:Kursiyerler) {
				if(kursiyer.getKursiyerAdSoyad().equals(kursiyerAdSoyad)) {
					System.out.println(kursiyer.getKursiyerID()+"\t"+kursiyer.getKursiyerAdSoyad()+"\t"+kursiyer.getYas());
					for(Kurs kurs :kursiyer.alinanKurslar) {
						System.out.println(kurs.getKursID()+"\t"+kurs.getKursAd());
					}
					kontrol=false;
				}	
			}
			if(kontrol){
				System.out.println("Arad���n�z kursiyer bulunamad�.");
				}
		}
		System.out.println("");
	}
	public static void KursiyerSil(int kursiyerId){
		Boolean kontrol=true;//aranan kontrol�
		int kSay=0;
		if(Kursiyerler.size()==0) {
			System.out.println("\nKursiyer listesi bo�...");
		}
		else{
			for(Kursiyer kursiyer:Kursiyerler) {
				if(kursiyer.getKursiyerID()==kursiyerId) {
					kontrol=false;
					break;
				}
				kSay=kSay+1;
			}
			
			if(kontrol){
				System.out.println("Arad���n�z kursiyer bulunamad�.");
			}
			else {
				Kursiyerler.remove(kSay);
				System.out.println("Kursiyer silindi.");
			}
		}
		System.out.println("");
	}
	public static void KursiyerListele(){
		if(Kursiyerler.size()==0) {
			System.out.println("Kursiyer listesi bo�...");
		}
		else {
			for(Kursiyer kursiyer:Kursiyerler) {
				System.out.println(kursiyer.getKursiyerID()+"\t"+kursiyer.getKursiyerAdSoyad()+"\t"+kursiyer.getYas());
			}
		}
		System.out.println("");
	}
	public static void KursiyerAyr�nt�l�Listele(){
		if(Kursiyerler.size()==0) {
			System.out.println("Kursiyer listesi bo�...\n");
		}
		else {
			for(Kursiyer kursiyer:Kursiyerler) {
				System.out.println(kursiyer.getKursiyerID()+"\t"+kursiyer.getKursiyerAdSoyad()+"\t"+kursiyer.getYas());
				for(Kurs kurs :kursiyer.alinanKurslar) {
					System.out.println(kurs.getKursID()+"\t"+kurs.getKursAd());
				}
				System.out.println("");
			}
		}
		//System.out.println("");
		
	}
	public static void kursiyerinOdeyecegiTutarHesaplama(int kursiyerId){
		int tutar=0;
		boolean kontrol=true;
		for(Kursiyer kursiyer:Kursiyerler) {
			if(kursiyer.getKursiyerID()==kursiyerId) {
				if(kursiyer.alinanKurslar.size()==2) {
					tutar=185;
					System.out.println("Kursiyerin �deyece�i tutar :"+tutar);
					System.out.println("2 Kursa sahip oldu�unuz i�in �kinci kursta %15 indirim kampanyas�ndan faydaland�n�z.");
				}
				else if(kursiyer.alinanKurslar.size()==3) {
					tutar=275;
					System.out.println("Kursiyerin �deyece�i tutar :"+tutar);
					System.out.println("3 Kursa sahip oldu�unuz i�in ���nc� kursta %25 indirim kampanyas�ndan faydaland�n�z.");
				}
				else if(kursiyer.alinanKurslar.size()>3) {
					tutar=(kursiyer.alinanKurslar.size()*100)-(kursiyer.alinanKurslar.size()*10);
					System.out.println("Kursiyerin �deyece�i tutar :"+tutar);
					System.out.println("3'ten fazla Kursa sahip oldu�unuz i�in T�m kurslarda %10 indirim kapanyas�ndan faydaland�n�z.");
				}
				else {
					tutar=100;
					System.out.println("Kursiyerin �deyece�i tutar :"+tutar);
					System.out.println("1 Kursa sahip oldu�unuz i�in indirimden faydalanamad�n�z.");
				}
				kontrol=false;
			}
		}
		if(kontrol) {
			System.out.println("Arad���n�z kursiyer bulunamad�.");
		}
		System.out.println("");
	}
	public static void bitir() throws IOException {
		File dosyaKursiyer = new File("kursiyer.txt");
		if(!dosyaKursiyer.exists()) {
			dosyaKursiyer.createNewFile();
		}
		FileWriter fw = new FileWriter(dosyaKursiyer);
		BufferedWriter bw = new BufferedWriter(fw);
		for(Kursiyer kursiyer:Kursiyerler) {
			bw.write("#"+kursiyer.getKursiyerID()+"-"+kursiyer.getKursiyerAdSoyad()+"-"+kursiyer.getYas()+"\n");
			for(Kurs kurs :kursiyer.alinanKurslar) {
				bw.write("*"+kurs.getKursID()+"-"+kurs.getKursAd()+"\n");
			}	
		}
		bw.close();
		
		File dosyaKurs = new File("kurs.txt");
		if(!dosyaKurs.exists()) {
			dosyaKurs.createNewFile();
		}
		FileWriter fw1 = new FileWriter(dosyaKurs);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		for(Kurs kursx:Kurslar) {
			bw1.write("*"+kursx.getKursID()+"-"+kursx.getKursAd()+"\n");
		}
		bw1.close();
		System.out.println("\n�yi G�nler...");
	}

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		//-----------------------------------------------
		String line,lineX;
	 	File okumaKursiyer=new File("kursiyer.txt");            
        FileReader oku=new FileReader(okumaKursiyer);  
        BufferedReader read=new BufferedReader(oku);
        
        line=read.readLine();
        while(line!=null){
        	if(line.charAt(0)=='#') {
        		Kursiyer kursiyer =new Kursiyer();
        		String[] parcaKursiyer =line.split("-");
        		String tutucu1=parcaKursiyer[0].substring(1);
        		int krsyrId=Integer.valueOf(tutucu1);
        		int krsyrYas=Integer.valueOf(parcaKursiyer[2]);
        		kursiyer.setKursiyerID(krsyrId);
        		kursiyer.setKursiyerAdSoyad(parcaKursiyer[1]);
        		kursiyer.setYas(krsyrYas);
        		
        		line=read.readLine();
        		while(line!=null) {
        			if(line.charAt(0)=='*') {
        				Kurs kurs = new Kurs();
        				
        				String[] parcaKurs =line.split("-");
        	            String tutucu=parcaKurs[0].substring(1);
        	            int kId=Integer.valueOf(tutucu);
       
        	            kurs.setKursID(kId);
    					kurs.setKursAd(parcaKurs[1]);	
    					kursiyer.alinanKurslar.add(kurs);
    					line=read.readLine();
        			}
        			else {
        				
        				break;
        			}
        			
        		}
        		Kursiyerler.add(kursiyer);
        	}
        	
        }
        read.close();
		//-----------------------------------------------
        File okumaKurs=new File("kurs.txt");            
        FileReader okuKurs=new FileReader(okumaKurs);  
        BufferedReader readKurs=new BufferedReader(okuKurs);
        lineX=readKurs.readLine();
        
        while(lineX!=null){
        	Kurs kursX= new Kurs();
        	String[] parcaKursX =lineX.split("-");
            String tutucuX=parcaKursX[0].substring(1);
            int kIdX=Integer.valueOf(tutucuX);

            kursX.setKursID(kIdX);
			kursX.setKursAd(parcaKursX[1]);	
			Kurslar.add(kursX);
        	lineX=readKurs.readLine();
        }
        readKurs.close();
        //-----------------------------------------------
		int kontrol=1;
		while(kontrol==1) {
			System.out.println("1- Kurs ekle");
			System.out.println("2- Kurs listeleme");
			System.out.println("3- Kursiyer ekle");
			System.out.println("4- Kursiyer arama");
			System.out.println("5- Kursiyer sil");
			System.out.println("6- Kursiyer listele");
			System.out.println("7- Kursiyer ayr�nt�l� listele");
			System.out.println("8- Kursiyerin �deyece�i tutar hesaplama");
			System.out.println("9- ��k��");
			System.out.print("L�tfen se�iminizi tu�lay�n�z :");
			int secim  = scan.nextInt()	;
			//scan.nextLine();
			System.out.println("");
			switch (secim) {
			case 1:
			{
				KursEkle();
				break;	
			}
			case 2:
			{	
				KursListeleme();
				break;
			}
			
			case 3:
			{
				kursiyerEkle();
				break;
			}
			
			case 4:
			{
				System.out.print("Aramak istediginiz kursiyerin ad�n� ve soyad�n� giriniz :");
				scan.nextLine();
				String araAdSoyad= scan.nextLine();
				KursiyerArama(araAdSoyad);
				break;
			}
			case 5:
			{	
				System.out.print("Silmek istediginiz kursiyerin Id'sini giriniz :");
				int sil= scan.nextInt();
				KursiyerSil(sil);
				break;
			}
			case 6:
			{
				KursiyerListele();
				break;
			}
			case 7:
			{
				KursiyerAyr�nt�l�Listele();
				break;
			}
			case 8:
			{
				System.out.print("�deyece�i tutar� ��renmek istedi�iniz kursiyerin Id'sini giriniz :");
				int ode= scan.nextInt();
				kursiyerinOdeyecegiTutarHesaplama(ode);
				break;
			}
			case 9:
			{
				bitir();
				kontrol=0;
				break;
			}
			
			}
		
		}
	}
}

	
