package vPeli1;

import java.util.ArrayList;

public class naytaLuokka {
	private String[] varit = {"Punainen", "Sininen", "Vihreä"};
	private String[] kivi = { "valkea", "musta" };
	
	
	public void naytaRyhmatL(int pelaajia, ArrayList<henkilo> osallistujalista ) {
		henkilo henkilo=null;        
		
		System.out.println("\nPunainen ryhmä:");
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 0
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==0) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					if (henkilo.isPresidentti()) {System.out.print(" - on presidentti ");
					}
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
				if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
			}
			
		}
		
		System.out.println("\nSininen ryhmä:");
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 1
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==1) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					if (henkilo.isPresidentti()) {System.out.print(" - on presidentti ");}
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
				if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
			}
			
		}
		
		System.out.println("\nVihreä ryhmä:");
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 2
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==2) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					if (henkilo.isPresidentti()) {System.out.print(" - on presidentti ");}
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
				if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
			}
		}
	}
	
	public void naytaPelaajatNumeroilla(int pelaajia, ArrayList<henkilo> osallistujalista) {
		int i=0;
		for (henkilo henkilo : osallistujalista) {
			if (!henkilo.isPudotettu()) {
				System.out.println(osallistujalista.indexOf(henkilo)+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]+"  -    pelit "+henkilo.getPelityhteensa()+" tulokset "+henkilo.getKaikkitulokset()+" poletit "+henkilo.getPoletit());
		    if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
			i++;
			}
		}
	}
	
	
	public void naytaPelaajia(boolean pelit, boolean kaikkitulokset, boolean hallitus, boolean vainpelaajat, int pelaajia, ArrayList<henkilo> osallistujalista) {
		
		 henkilo henkilo=null;
		 if (hallitus) { System.out.println("\nHallituksessa ovat:"); }
		
		for (int i=0; i<pelaajia; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
				if (hallitus) {
					if (henkilo.isHallitus()) {
						System.out.print(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
						if (henkilo.isPresidentti()) {System.out.print(" on presidentti");}
						if (pelit) {System.out.print(" pelit "+henkilo.getPelityhteensa());}
						if (kaikkitulokset) {System.out.print(" tulokset "+henkilo.getKaikkitulokset());}
						if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
						System.out.println();
					}
					}else {
						if (vainpelaajat) { if(!henkilo.isHallitus()) {
							System.out.print(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
							if (pelit) {System.out.print(" pelit "+henkilo.getPelityhteensa());}
							if (kaikkitulokset) {System.out.print(" tulokset "+henkilo.getKaikkitulokset());}
							if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
							System.out.println();
						}
							
						}else {
							System.out.print(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
							if (pelit) {System.out.print(" pelit "+henkilo.getPelityhteensa());}
							if (kaikkitulokset) {System.out.print(" tulokset "+henkilo.getKaikkitulokset());}
							if (henkilo.isImmuniteetti()) {System.out.print(" - TÄTÄ HENKILÖÄ EI VOI PUDOTTAA");}
							System.out.println();
						}

					}
				
			}
		
	}
}



	
	
}
