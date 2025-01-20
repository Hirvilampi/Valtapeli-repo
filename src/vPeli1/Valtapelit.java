package vPeli1;

import java.util.ArrayList;
import java.util.Arrays;

public class Valtapelit {
	private ArrayList<henkilo> osallistujalista = new ArrayList<henkilo>();
	private String[] pelaaja = {"Marjo", "Jenni" , "Heidi", "Henriikka", "Tanja", "Iiris", "Niko", "Sami", "Archie", "Kari", "Perttu", "Jari"};
	private String[] kierrospeli = 
		       {"Ryhmäpeli: Kannatuksen kasvattaminen",
				"Ryhmäpeli: Puolueohjelman rakentaminen", //2
				"Ryhmäpeli: Budjettiriihi", //3
				"Ryhmäpeli: Geopoliittinen kriisi",   //4
				"Ryhmäpeli: Pandemian hallinta",
				"Yksilöpeli: Nepotismi",   //6
				"Paripeli: Lakkokriisi", //7
				"Yksilöpeli: Ilmastotavoitteet", //8
				"Yksilöpeli: Diplomaattiset neuvottelut", //9
				"Yksilöpeli: Kulisseissa vaikuttaminen"};  //10
	private String[] varit = {"Punainen", "Sininen", "Vihreä"};
	
	
	public Valtapelit(ArrayList<henkilo> osallistujalista, String[] pelaaja, String[] kierrospeli) {
		this.osallistujalista = osallistujalista;
		this.pelaaja = pelaaja;
		this.kierrospeli = kierrospeli;
	}
	
	


	public Valtapelit() {
		osallistujalista=null;
		pelaaja=null;
		kierrospeli=null;
	}




	public ArrayList<henkilo> getOsallistujalista() {
		return osallistujalista;
	}




	public void setOsallistujalista(ArrayList<henkilo> osallistujalista) {
		this.osallistujalista = osallistujalista;
	}




	public String[] getPelaaja() {
		return pelaaja;
	}




	public void setPelaaja(String[] pelaaja) {
		this.pelaaja = pelaaja;
	}




	public String[] getKierrospeli() {
		return kierrospeli;
	}




	public void setKierrospeli(String[] kierrospeli) {
		this.kierrospeli = kierrospeli;
	}




	private void naytaRyhmat() {
		henkilo henkilo= new henkilo();        
		
/*		for (int i=0; i<pelaaja.length; i++) {   //jaetaan kolmeen ryhmään 0,1,2
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
				System.out.println(henkilo.getNimi()+" on ryhmässä nro "+henkilo.getRyhma());
			}		
		}
		*/
		
		System.out.println("\nPunainen ryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 0
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==0) {
				System.out.println(henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
			}
			
		}
		
		System.out.println("\nSininen ryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 1
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==1) {
				System.out.println(henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
			}
			
		}
		
		System.out.println("\nVihreä ryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 2
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==2) {
				System.out.println(henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
			}
		}
	}



	@Override
	public String toString() {
		return "Valtapelit [osallistujalista=" + osallistujalista + ", pelaaja=" + Arrays.toString(pelaaja)
				+ ", kierrospeli=" + Arrays.toString(kierrospeli) + "]";
	}
	

	
	
}
