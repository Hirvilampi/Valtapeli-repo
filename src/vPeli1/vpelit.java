package vPeli1;

import java.util.ArrayList;
import java.util.Random;

public class vpelit {
/*	private ArrayList<henkilo> osallistujalista;
	private String[] pelaaja = {
			"Marjo", "Jenni" , "Heidi", "Henriikka", 
//			"Tanja", "Iiris", "Niko", "Sami", "Archie", "Kari",
			"Perttu", "Jari"};
	*/
	/*public vpelit(ArrayList<henkilo> osallistujalista) {
		this.osallistujalista=osallistujalista;
	}
	*/
	public void naytaViesti(String text) {
		System.out.println(text);
	}
	
	public void naytaRyhmatv(String jes, int pelaajia,ArrayList<henkilo> osallistujalista)
	{
	  System.out.println(jes);	
		henkilo henkilo=null;        
		
		System.out.println("\nPunainen ryhmä:");
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 0
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==0) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
			
			}
			
		}
		
		System.out.println("\nSininen ryhmä:");
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 1
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==1) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
			
			}
			
		}
		
		System.out.println("\nVihreä ryhmä:");
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 2
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==2) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
			
			}
		}
	}
	
	public void jaaRyhmatv(String[] pelaajia, ArrayList<henkilo> osallistujalista) {
		Random rand = new Random();
		henkilo henkilo=null;
		for (int i=0; i<pelaajia.length; i++) {   //jaetaan kolmeen ryhmään 0,1,2
			henkilo=osallistujalista.get(i);
			 int rand_int1 = rand.nextInt(3);
			 henkilo.setRyhma(rand_int1);
			 osallistujalista.set(i, henkilo);
			
		}
	}
	

}
