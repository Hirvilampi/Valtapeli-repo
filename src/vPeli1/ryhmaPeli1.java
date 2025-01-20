package vPeli1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ryhmaPeli1 {
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
	
	public void rPeli (int jakso, int pelaajia, ArrayList<henkilo> osallistujalista) {
		naytaLuokka nayta = new naytaLuokka();
//		if (jakso==1) {
			
	    	  Scanner input = new Scanner(System.in);
		    System.out.println("Peli alkaa ryhminen jakamisella, Ryhmiin jaettavie pelaajia on");
			Random rand = new Random();
			henkilo henkilo=null;

			System.out.println("arvottiin kaksi joukkuetta");
			
	        nayta.naytaRyhmatL(pelaajia, osallistujalista);

				
				System.out.println("\nPelataan peli "+kierrospeli[jakso]+"\n");
				
				//arvotaan jokaiselle pelaajalle "summa väliltä 1-20"
//				ohjelma.arvoPelaajantulos(20);

				for (int i=0; i<pelaajia; i++) {
					henkilo=osallistujalista.get(i);
					if (!henkilo.isPudotettu()) {
						int randi1 = rand.nextInt(20)+1;
						henkilo.setPelintulos(randi1);
						henkilo.setPelityhteensa(randi1+henkilo.getPelityhteensa());
						osallistujalista.set(i,henkilo);
					}
				}
				
				
				 // näytetään peliryhmät
				
				System.out.println("\nEka peliryhmä:");
		//		int ekatyhteensa=ohjelma.naytaRyhmantulokset(0);
		
				int ekatyhteensa=0;
				for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 0, eli ekat
					henkilo=osallistujalista.get(i);
					if (!henkilo.isPudotettu() && henkilo.getAliryhma()==0) {
						ekatyhteensa=ekatyhteensa+henkilo.getPelintulos();
						System.out.println(henkilo.getNimi()+" tulos: "+henkilo.getPelintulos());
					}
					
				}
		
				
				int tokatyhteensa=0;
				System.out.println("\nToka peliryhmä:");
				for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 1, eli tokat
					henkilo=osallistujalista.get(i);
					if (!henkilo.isPudotettu() && henkilo.getAliryhma()==1) {
						tokatyhteensa=tokatyhteensa+henkilo.getPelintulos();
						System.out.println(henkilo.getNimi()+" tulos: "+henkilo.getPelintulos());
					}
					
				} 
				System.out.println("\nEka ryhmän pisteet  "+ekatyhteensa+" ja tokan ryhmän pisteet "+tokatyhteensa);
				int suurin=0;
				int kenella=0;
				int poletitnyt=0;
				boolean ekatvoitti=false;
				boolean tasapeli=false;
				
				if (ekatyhteensa==tokatyhteensa) {
					System.out.println("Tasapeli. Politiikassa vain voittajat palkitaan. Kumpikaan joukkue ei saa lisää kannatusta");
					tasapeli=true;
				} else if (ekatyhteensa>tokatyhteensa) {
					ekatvoitti=true;
				}
				
				if (!tasapeli) {
				
			     	if (ekatvoitti) { // peliryhmän pelaajille lisää pisteitä
			     		System.out.println("\nEkat voitti pelin ja saavat +1 polettia per henkilö, paras 3 ja toka 2\n"
			     				+ "hävinneen ryhmän paras saa 2 polettia ja toka 1\n");
			     		annetaanPisteita(0,1,3,2,0, pelaajia, osallistujalista);
			     		annetaanPisteita(1,0,2,1,0, pelaajia, osallistujalista);

			     	} else if (!ekatvoitti) { // jos ryhmä tokat voitti, heidän parhaat saa pisteitä
			     		System.out.println("\nTokat voitti pelin ja saavat +1 polettia per henkilö, paras +3\n"
			     				+ "hävinneen ryhmän paras saa 2 polettia ja toka 1:n\n");
			     	     annetaanPisteita(1,1,3,2,0, pelaajia, osallistujalista);
				     	 annetaanPisteita(0,0,2,1,0, pelaajia, osallistujalista);
			     		
			     	}
			/*     	
			    	henkilo=osallistujalista.get(kenella);
					poletitnyt=henkilo.getPoletit();
					henkilo.setPoletit(poletitnyt+2);
					System.out.println("Parhaan tuloksen sai "+henkilo.getNimi()+" sai 2 ylimääräistä polettia. "+henkilo.getNimi()+"lla on nyt poletteja: "+henkilo.getPoletit()+" kpl");
				*/	
				}
				 nayta.naytaRyhmatL(pelaajia, osallistujalista);
				System.out.println();
				input.nextLine();
	//	}
	}
	
	
	public void annetaanPisteita(int ryhma, int pisteitakaikille, int pparhaalle, int tokalle, int kolmannelle, int pelaajia, ArrayList<henkilo> osallistujalista) {
		 henkilo henkilo=null;
		 int poletitnyt=0;
		 int suurin=0;
		 int kenella=0;
		 int maarapoletit=0;
		 int maara=0;
		 Integer tulos=0;
		 Integer suurin2=0;
		 
		for (int i=0; i<pelaajia; i++) {   //näytetään ryhmä 0, eli ekat
 			henkilo=osallistujalista.get(i);
 			if (!henkilo.isPudotettu() && henkilo.getAliryhma()==ryhma) { // tarkistus, että kuuluu ryhmään
				poletitnyt=henkilo.getPoletit();
				henkilo.setPoletit(poletitnyt+pisteitakaikille);
				maarapoletit=henkilo.getKaikkipoletit();
				henkilo.setKaikkipoletit(maarapoletit+pisteitakaikille); 

				osallistujalista.set(i, henkilo);
	//			System.out.println(henkilo.getNimi()+" tulos: "+henkilo.getPelintulos());
			
				// tsekataan jos tän tulos on suurempi kuin suurin, lisätään muistiin kenellä ja maara

				if (henkilo.getPelintulos()>suurin) {
					suurin=henkilo.getPelintulos();
					kenella=i;
				}
			
 			}
		
 		}
		
//		System.out.println("suurin tulos on "+suurin+" suurimpien määrä nyt on "+maara);
		
		for (int i=0; i<pelaajia; i++) { // testataan, monnellako on suurin luku sama
			henkilo=osallistujalista.get(i);
			tulos = henkilo.getAliryhma();
			suurin2 = ryhma;
 			if (!henkilo.isPudotettu() && tulos.equals(suurin2)) { // tarkistus, että kuuluu ryhmään  henkilo.getAliryhma()==ryhma
	
			// tsekataan jos tän tulos on suurempi kuin suurin, lisätään muistiin kenellä ja maara
 				tulos=new Integer(henkilo.getPelintulos());
 				suurin2=new Integer(suurin);
 //				System.out.println("pelin tulos "+tulos+" onko yhtää suuri kuin suurin2 "+suurin2+" "+tulos.equals(suurin2));

				if (tulos.equals(suurin2)) {
					maara++;
//					System.out.println("Yksi suurin lisää");
				}
			
 			}
		}
		
	//	System.out.println("löytyi "+maara+" henkilöä, jolla oli suurin ulos");
		
	
	//		System.out.println("lisätään pisteet parhaalle");
			for (int i=0; i<pelaajia; i++) { // testataan, monnellako on suurin luku sama
				henkilo=osallistujalista.get(i);
	 			if (!henkilo.isPudotettu() && henkilo.getAliryhma()==ryhma) { // tarkistus, että kuuluu ryhmään
		
				// tsekataan jos tän tulos on suurempi kuin suurin, lisätään muistiin kenellä ja maara

					if (henkilo.getPelintulos()==suurin) {
				 		henkilo=osallistujalista.get(i);
				 		henkilo.setPoletit(henkilo.getPoletit()+pparhaalle);
				 		henkilo.setKaikkipoletit(henkilo.getKaikkipoletit()+pparhaalle);
				 		osallistujalista.set(i, henkilo);
					}
	 			}
		    }
			
			int toiseksiparas=0;
			int toka=0;
			String tokanimi="";
			
			// Etsitään toiseksi eniten pisteitä saaanut ja annetaan hänelle pisteet tokalle
			 for (int i=0; i<pelaajia; i++) {
				 henkilo=osallistujalista.get(i);
				 if (!henkilo.isPudotettu() && henkilo.getAliryhma()==ryhma) {
					 if(henkilo.getPelintulos()<suurin && henkilo.getPelintulos()>toiseksiparas) {
						 toiseksiparas=henkilo.getPelintulos();
						 toka=i;
						 tokanimi=henkilo.getNimi();
							henkilo.setPoletit(henkilo.getPoletit()+tokalle);
					 		henkilo.setKaikkipoletit(henkilo.getKaikkipoletit()+tokalle);
					 		osallistujalista.set(i, henkilo);
					 }
				 }
			 }
	}
	

}
