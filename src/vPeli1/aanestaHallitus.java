package vPeli1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.*;

public class aanestaHallitus {
	private String[] varit = {"Punainen", "Sininen", "Vihreä"};
	private String[] kivi = { "valkea", "musta" };


	
	
	public void nollaaAanestysjaHallitus(int pelaajia, ArrayList<henkilo> osallistujalista) {
		henkilo henkilo=null;
		for (int i=0; i<pelaajia; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
//		     	mukana++;
			}
			henkilo.setAanestys(0);                     //Alustetaan äänimäärä 0:n kaikilla
			henkilo.setHallitus(false);               //Alustetaan, ettei kukaan tällä hetkellä ole hallituksessa
			osallistujalista.set(i, henkilo);
		}		
	}
	
	
   public List<hallitusjasen> nollaaHallitus(int pelaajia, List<hallitusjasen> hallitus) {
	 //Alustetaan, ettei kukaan tällä hetkellä ole hallituksessa, käydään koko lista läpi
         hallitus.clear();
		return hallitus;
	} 

	
	public int compare(hallitusjasen h1, hallitusjasen h2) {
		return h1.aanestys - h2.aanestys;
	}	

	
	public ArrayList<henkilo> hallitusOsallistujalistaan(int pelaajia, ArrayList<henkilo> osallistujalista, List<hallitusjasen> hallitus){
		for (int i=0; i<hallitus.size(); i++) {
			henkilo henkilo = new henkilo();
			hallitusjasen jasen = new hallitusjasen();
			jasen=hallitus.get(i);
			int index = jasen.getPelaajanumero();
			henkilo=osallistujalista.get(index);
			henkilo.setHallitus(true);
			osallistujalista.set(index, henkilo);
		}
		return osallistujalista;
	}
   
	
	@SuppressWarnings("unused")
	public List<hallitusjasen> jarjestaHallitus(int pelaajia, ArrayList<henkilo> osallistujalista, List<hallitusjasen> hallitus){
		hallitus=nollaaHallitus(pelaajia,hallitus);
		henkilo henkilo=null;
		int hallitusjasenet=0;
		int j=0;
		for (int i=0; i<osallistujalista.size(); i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getAanestys()>0) {
				hallitusjasen jasen = new hallitusjasen();
				jasen.setNimi(henkilo.getNimi());
				jasen.setPelaajanumero(i);
				jasen.setAanestys(henkilo.getAanestys());
				hallitus.add(jasen);
	
				System.out.println("Numero "+j+" Henkilo "+jasen.getNimi()+" lisatty. Hän sai ääniä: "+jasen.getAanestys()+" kpl.");
				j++;
				hallitusjasenet++;
			}
		}
			
	    // järjestetään hallitus ja montako jäsentä siinä on
		hallitus.sort((o1, o2) -> Integer.compare(o2.getAanestys(), o1.getAanestys()));
//		hallitus.forEach(System.out::println);	
		
		List<hallitusjasen> members = hallitus;   
		
		System.out.println("\nhallitukseen sai ääniä (kpl):"+hallitus.size()+"\n");
		if (hallitus.size()<3) {
			System.out.println("Hallituksessa on liian vähän jäseniä - arvotaan lisäjäsenet");
			Random random = new Random();

			if (hallitusjasenet<2) {
			do {
				  
				   int arvonta = random.nextInt(pelaajia-hallitusjasenet)+hallitusjasenet;
			        henkilo henkilo2 = new henkilo();
				    henkilo2=osallistujalista.get(arvonta);		
				    System.out.println("arvonnan tulos "+arvonta+" "+osallistujalista.get(arvonta).getNimi());
				    hallitusjasen jasen = new hallitusjasen();
				    if (!hallitus.contains(jasen)) { // lisätään arvottu jäsen vain jos hän ei ole jo hallituksessa
				    	String nimi = henkilo2.getNimi();
				    	jasen.setNimi(nimi);
				    	jasen.setPelaajanumero(arvonta);
				    	jasen.setAanestys(henkilo2.getAanestys()+1);
				    	hallitus.add(jasen);
				    	hallitusjasenet++;
				    	}
				} while (hallitusjasenet<3);
				
			}

				System.out.println("hallituksessa on nyt jäseniä:"+hallitus.size());	
		} else if (hallitus.size()>3) {

	        List<hallitusjasen> sortedMembers = members.stream()
	                .sorted(Comparator.comparingInt(hallitusjasen::getAanestys).reversed())
	                .collect(Collectors.toList());

	        List<hallitusjasen> top3 = new ArrayList<>(sortedMembers.subList(0, 2));

	        // Handle ties for the third highest score
	        int thirdHighestScore = sortedMembers.get(2).getAanestys();
	        List<hallitusjasen> tiedMembers = sortedMembers.stream()
	                .filter(m -> m.getAanestys() == thirdHighestScore)
	                .collect(Collectors.toList());
	        
	        System.out.println("Tasapeli - arvotaan hallituksen jäseniä näistä tasoissa olevista\n");
	        for (hallitusjasen i : tiedMembers) {
	        	System.out.println(i.getPelaajanumero()+" "+i.getNimi()+" ääniä:"+i.getAanestys());
	        }

	        Random random = new Random();
	        hallitusjasen randomTiedMember = tiedMembers.get(random.nextInt(tiedMembers.size()));
	        top3.add(randomTiedMember);
	        
	        hallitus=top3;
	        
//	        System.out.println("\nHallitukseen arvottiin seuraavat jäsenet");
//	        top3.forEach(System.out::println);			
		}
		
		System.out.println("\nNämä henkilöt päätyivät hallitukseen\n");
		for (hallitusjasen i : hallitus) {
			System.out.println(i.getPelaajanumero()+" "+i.getNimi()+" ääniä:"+i.getAanestys());
		}
		return hallitus;
	}
	
/*	vanha versio talteen - uuteen tulee uudet tiedot
	public ArrayList<henkilo> aanesta(int aanestaja, ArrayList<henkilo> osallistujalista, int pelaajia){
		Scanner input = new Scanner(System.in);
		henkilo henkilo=osallistujalista.get(aanestaja);
		henkilo henkilo2=null;
		boolean voted=false;
		int valinta;
		while  (voted); {
			System.out.println("Mukana ovat:");
			naytaLuokka nayta = new naytaLuokka();
			nayta.naytaPelaajatNumeroilla(pelaajia, osallistujalista);
			System.out.print("Ketä haluat äänestää: ");
			valinta = input.nextInt();
			System.out.println();
				henkilo2=osallistujalista.get(valinta);
			if (henkilo2.isPudotettu()) { System.out.println("Valitsit pudonneen, valitse uudelleen: "); 
			} else	{
				System.out.println(henkilo.getNimi()+" äänesti numeroa "+valinta+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);
			
				voted=true;
			}
			}  
		henkilo2.setAanestys(henkilo2.getAanestys()+1);
		osallistujalista.set(valinta, henkilo2);	
		return osallistujalista;
	}
*/	
	
	public ArrayList<aanestyshenkilo>  aanesta(int aanestaja, ArrayList<henkilo> osallistujalista, int pelaajia, ArrayList<aanienAnto> aanestyshenkilolista){
		Scanner input = new Scanner(System.in);
		henkilo henkilo=osallistujalista.get(aanestaja);
		henkilo henkilo2=null;
		boolean voted=false;
		int valinta;
		while  (voted); {
			System.out.println("Mukana ovat:");
			naytaLuokka nayta = new naytaLuokka();
			nayta.naytaPelaajatNumeroilla(pelaajia, osallistujalista);
			System.out.print("Ketä haluat äänestää: ");
			valinta = input.nextInt();
			System.out.println();
				henkilo2=osallistujalista.get(valinta);
			if (henkilo2.isPudotettu()) { System.out.println("Valitsit pudonneen, valitse uudelleen: "); 
			} else	{
				System.out.println(henkilo.getNimi()+" äänesti numeroa "+valinta+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);
			
				voted=true;
			}
			}  
		aanestyshenkilo ahenkilo = new aanestyshenkilo();

		ArrayList<aanestyshenkilo> ahenkilolista = aanestyshenkilolista.get(aanestaja).getHenkilojaaanet();
		ahenkilo=ahenkilolista.get(valinta);
		ahenkilo.setAania(ahenkilo.getAania()+1);
		ahenkilolista.set(valinta, ahenkilo);
        for (aanestyshenkilo z : ahenkilolista) {
        	System.out.println(z);
        }
		
		aanienAnto aanihenkilolle = new aanienAnto(); 
		aanihenkilolle.setHenkilojaaanet(ahenkilolista);;
/*		System.out.println("\nvalinta on "+valinta+" osallistuja "+osallistujalista.get(valinta).getNimi());
		System.out.println("listasta kyseessä olisi "+aanestyshenkilolista.get(aanestaja).getHenkilojaaanet().get(valinta));
		
		System.out.println("Nyt äänesti pelaaja no "+aanestaja+" hänen nimensä on "+osallistujalista.get(aanestaja).getNimi());
		System.out.println("aanestyshenkilölistassa tiedoilla "+aanestyshenkilolista.get(aanestaja));
*/		
		
		System.out.println("tämä sai ääniä\n"+ahenkilo);
		
//		henkilo2.setAanestys(henkilo2.getAanestys()+1);
//		osallistujalista.set(valinta, henkilo2);	
		
		return ahenkilolista;
	}
	
	
	public void print(int pelaajanumero, String valinta, henkilo henkilo, boolean voted) {
		if (valinta.equals("aanesta")) {
			if (voted) {
				System.out.println("\n1 - äänestä haluamaasi henkilöä (olet jo äänestänyt)");
			} else {
				System.out.println("\n1 - äänestä haluamaasi henkilöä (tämä vaihtoehto on aina käytettävissä)");
			}
			
			System.out.println("2 - anna lisä-ääniä. Hinta 1 poletti");
			System.out.println("Seuraavista vaihtoehdoista voit suorittaa vain yhden");
			System.out.println("3 - poista valitsemasi pelaajan äänet. Hinta 2 polettia"); 
			if (henkilo.getHallituksessa()>0 || henkilo.isHallitus()) {
			System.out.println("4 - pakota valitsemasi pelaaja hallitukseen. Hinta 3 polettia"); // täytyy olla tai ollut hallituksessa
			System.out.println("5 - estä valitsemaasi pelaaja pääsemästä hallitukseen. Hinta 3. polettia");// täytyy olla tai ollut hallituksessa 
			}						
			System.out.println("0 - lopeta\n");
			System.out.println("\n"+henkilo.getNimi()+" on käytettävissä "+henkilo.getPoletit()+" polettia");
			System.out.println("\nKerro valintasi numerolla:");
			System.out.print("Mita "+pelaajanumero+". "+henkilo.getNimi()+"("+varit[henkilo.getRyhma()]+") tekee: ");
		}
	}
	
	
	public ArrayList<henkilo> annaLisaaani(int aanestaja, ArrayList<henkilo> osallistujalista, int pelaajia){
		Scanner input = new Scanner(System.in);
		henkilo henkilo=osallistujalista.get(aanestaja);
		henkilo henkilo2=null;
		boolean tokenvote=false;
		int valinta;
		while  (tokenvote && henkilo.getPoletit()==0); {
			 henkilo=osallistujalista.get(aanestaja);
			System.out.println("Mukana ovat:");
			naytaLuokka nayta = new naytaLuokka();
			nayta.naytaPelaajatNumeroilla(pelaajia, osallistujalista);
			System.out.print("Sinulla on "+henkilo.getPoletit()+" polettia.");
			System.out.print("Kenelle annat lisä-äänen: ");
			valinta = input.nextInt();
			System.out.println();
			henkilo2=osallistujalista.get(valinta);
			if (henkilo2.isPudotettu()) { System.out.println("Valitsit pudonneen, valitse uudelleen: "); 
			} else	{
				System.out.println(henkilo.getNimi()+" äänesti numeroa "+valinta+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);
			
				tokenvote=true;
			}
			}  
		henkilo2.setAanestys(henkilo2.getAanestys()+1);
		osallistujalista.set(valinta, henkilo2);
		int poletit=henkilo.getPoletit()-1;
		henkilo.setPoletit(poletit);;
		osallistujalista.set(aanestaja, henkilo); 
	
		return osallistujalista;
	}
	 
	
	public ArrayList<henkilo> blokkaaPelaajanAaanet(int aanestaja, ArrayList<henkilo> osallistujalista, int pelaajia){
		Scanner input = new Scanner(System.in);
		henkilo henkilo=osallistujalista.get(aanestaja);
		henkilo henkilo2=null;
		boolean tokenvote=false;
		int valinta;
		while  (tokenvote && henkilo.getPoletit()==0); {
			 henkilo=osallistujalista.get(aanestaja);
			System.out.println("Mukana ovat:");
			naytaLuokka nayta = new naytaLuokka();
			nayta.naytaPelaajatNumeroilla(pelaajia, osallistujalista);
			System.out.print("Sinulla on "+henkilo.getPoletit()+" polettia.");
			System.out.print("Kenen antamat äänet haluat blokata: ");
			valinta = input.nextInt();
			System.out.println();
			henkilo2=osallistujalista.get(valinta);
			if (henkilo2.isPudotettu()) { System.out.println("Valitsit pudonneen, valitse uudelleen: "); 
			} else	{
				System.out.println(henkilo.getNimi()+" blokkasi pelaajan "+valinta+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);
			
				tokenvote=true;
			}
			}  
		henkilo2.setBlokattu(true);
		osallistujalista.set(valinta, henkilo2);
		int poletit=henkilo.getPoletit()-2;
		henkilo.setPoletit(poletit);;
		osallistujalista.set(aanestaja, henkilo); 
		return osallistujalista;
	}
	
	public void aanestaHallitusta(int pelaajia, ArrayList<henkilo> osallistujalista,  List<hallitusjasen> hallitus) {
		 ArrayList<aanienAnto> hallitusaanet = new ArrayList<>();
	     henkilo henkilo=null;
	     henkilo henkilo2=null;
		 Scanner input = new Scanner(System.in);
			Random rand = new Random();  
		 int valinta=0;
		 int mukana=0;
		 int laskuri=0;

		 
		 System.out.println("\n-------------\n Äänestetään 3 edustajaa hallitukseen\n-------------\n");
		 System.out.println(hallitus);
		 nollaaAanestysjaHallitus(pelaajia,osallistujalista);
		 ArrayList<henkilo> osallistujalistacache = osallistujalista;
		 
			System.out.println("Mukana ovat:");
			naytaLuokka nayta = new naytaLuokka();
			nayta.naytaPelaajatNumeroilla(pelaajia, osallistujalista);
	/*		
			for (int j=0; j<pelaajia; j++) {   //esitellään äänestettävät
				henkilo2=osallistujalista.get(j);
				if (!henkilo2.isPudotettu()) {System.out.println(j+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);}
			} 
			*/

// TARVITAAAN KOKONAAN UUSI LISTA, MIHIN MERKITÄÄN KAIKKI ÄÄNET, MITÄ KUKIN PELAAJA ANTAA KAIKILLE - TÄMÄN TÄYTYY OLLA KOKONAAN UUSI LISTA
// UUTEEN LISTAAN PITÄÄ LISÄTÄ ÄÄNNIÄ ANTANEEN PELAAJAN NUMERO, USEITA NUMEROITA, JOTKA KERTOVAT PELAAJIA JOILLE ON ANNETTU ÄÄNIÄ TAI LISÄ-ÄÄNIÄ
// NÄIDEN ÄÄNIÄ SAANEIDEN ALLA TÄYTYY OLLA VIELÄ ANNETUTU ÄÄNIMÄÄRÄT. ESIM PELAAJA 1, ON ANTANUT PELAAJALLE 1: 2 ÄÄNTÄ, PELAAJALLE 0: 1 ÄÄNI JA PELAJALLE 6: 2 ÄÄNTÄ
// LISTA VOI OLLA YHTÄ PITKÄ KUIN PELAAJIEN ALKUPERÄINEN MÄÄRÄ, NÄIN ÄÄNESTÄVÄ PELAAJA ON AINA SAMALLA NUMEROLLA MYÖS TÄSSÄ LISTASSA, KUIN OSALLISTUJALISTASSA
// LISTAAN TARVITAAN VIELÄ TIETO ONKO HÄNET PUDOTETTU VAI EI
// LISTAAN MYÖS TIETO ONKO PELAAJA BLOKATTU
			
			// alustetaan hallitusaanet 
			ArrayList<aanienAnto> aanestyshenkilolista = new ArrayList<aanienAnto>();  // tän alla jokaisen pelaajan alla myös äänestyshenkilölista, joka sisältää jokaisen pelaajan
			ArrayList<aanestyshenkilo> kohdehenkilo = new ArrayList<aanestyshenkilo>();  // tässä kaikki pelaajat

			for (int x=0; x<pelaajia; x++) {	
				aanestyshenkilo ahenkilo = new aanestyshenkilo();
				ahenkilo.setNumero(x);
				ahenkilo.setAania(0);
				kohdehenkilo.add(x, ahenkilo);
//				System.out.println("lisättiin no:"+x+" "+ahenkilo);
//				System.out.println("aanestyshenkilo lista "+kohdehenkilo);

			}
			
//			System.out.println("aanestyshenkilo lista "+kohdehenkilo);
//			System.out.println("kohdehenkilo 1 "+kohdehenkilo.get(1));

			
			//  laitetaan listaan aiemmin alustettu lista numeroilla ja tyhjillä tiedoilla, jokaisen pelaajan kohdalla on myös tieto onko hänet tiputettu vai ei	
			for (int i=0; i<pelaajia; i++) {
				aanienAnto aanienAnto = new aanienAnto();
				henkilo2=osallistujalistacache.get(i);
				aanienAnto.setBlokattu(henkilo2.isBlokattu());
				aanienAnto.setPudotettu(henkilo2.isPudotettu());	
				aanienAnto.setHenkilojaaanet(kohdehenkilo);	
				aanestyshenkilolista.add(aanienAnto);
				hallitusaanet.add(i, aanienAnto);
//				System.out.println(i+" pelaaja on pudotettu "+henkilo2.isPudotettu());
//				System.out.println(i+" pelaaja on pudotettu "+aanienAnto.isPudotettu());
//				System.out.println(i+" pelaaja on pudotettu "+aanestyshenkilolista.get(i).isPudotettu());

			}
			
			
			// seuraava näyttää, mitä äsken tallennettiin listaan
			System.out.println("\nTällaiset tallennettiin uuteen listaan ");
			for (int i=0; i<hallitusaanet.size(); i++) {
/*				tämä on tarkoitus ainakin pistaa kokonaan
 				System.out.println("\n\nnro: "+i+" blokattu: "+hallitusaanet.get(i).isBlokattu()+" pudotettu: "+hallitusaanet.get(i).isPudotettu());
			    System.out.println("Annetut äänet (pitäisi olla tyhjää tai vain yksi)");
				for (aanestyshenkilo x : hallitusaanet.get(i).getHenkilojaaanet()) {
			    	System.out.println("henkilo "+x.getNumero()+" aania "+x.getAania());
			    }*/
//				System.out.println("\nSeuraavaksi katsotaan tuleeko nämä tiedot ulos tästä uudesta listasta aanestyshenkilolista\n");
				System.out.println("\nnro: "+i+" blokattu: "+aanestyshenkilolista.get(i).isBlokattu()+" pudotettu: "+aanestyshenkilolista.get(i).isPudotettu());
			    System.out.println("Annetut äänet (pitäisi olla tyhjää tai vain yksi)");
				for (aanestyshenkilo x : aanestyshenkilolista.get(i).getHenkilojaaanet()) {
			    	System.out.println("henkilo "+x.getNumero()+" aania "+x.getAania());
			    }
			}		
			System.out.println("Mennään valintoihin\n\n");
			
			
				for (int i=0; i<pelaajia; i++) { // käydään lista läpi 
					henkilo=osallistujalistacache.get(i);
					if (!henkilo.isPudotettu()) { //jos henkilö ei ole pudonnut, hän saa äänestää
						laskuri++;	
						boolean voted=false;
						boolean lopetus=false;
						System.out.println("Mukana ovat:");
//						nayta.naytaPelaajatNumeroilla(pelaajia, osallistujalista);
						System.out.println("\nOn "+henkilo.getNimi()+" vuoro toimia. Tässä on vaihtoehdot");
						// valinnat pitäisi rakentaa tähän
						// näytä vaihtoehdot (estäminen, lisä-äänet, äänestys, lopetus)
						// tsekkaus ja toiminto
						// lopetus
						
						do {
							henkilo=osallistujalistacache.get(i);
							print(i,"aanesta",henkilo, voted);
							valinta = input.nextInt();
							System.out.println();
							
							switch (valinta) {
							case 1:
								if (!voted) {
									kohdehenkilo=aanesta(i,osallistujalistacache, pelaajia, aanestyshenkilolista);
									System.out.println(kohdehenkilo);
									aanienAnto aanienAnto2 = new aanienAnto();
									aanienAnto2.setHenkilojaaanet(kohdehenkilo);
									aanienAnto2.setBlokattu(osallistujalistacache.get(i).isBlokattu());
									aanienAnto2.setPudotettu(osallistujalistacache.get(i).isPudotettu());									
									aanestyshenkilolista.set(i, aanienAnto2);
									voted=true;
								} else System.out.println("Olet jo äänestänyt");

								break;
						
							case 2:
								if (henkilo.getPoletit()>=1) {
									osallistujalistacache=annaLisaaani(i,osallistujalistacache,pelaajia);
								} else System.out.println("Sinulla ei ole tarpeeksi poletteja lisä-äänten antamiseen");
								
								break;
							case 3:
								if (henkilo.getPoletit()>=2) {
									System.out.println("ominaisuus on vielä kesken, mutta polettaja olisi ollut vähintään 2");
									osallistujalistacache=blokkaaPelaajanAaanet(i,osallistujalistacache,pelaajia);

								} else System.out.println("Sinulla ei ole tarpeeksi poletteja lisä-äänten antamiseen");
								
								
								break;
							case 4:  // 4 - pakota valitsemasi pelaaja hallitukseen. Hinta 3 polettia"
								// tähän alkuun tsekki, onko ollut hallituksessa, koska vain heillä on tämä käytössä
								System.out.println("ominaisuus on vielä kesken");
								break;
							case 5:  // 5 - estä valitsemaasi pelaaja pääsemästä hallitukseen. Hinta 3. polettia+
								// tähän alkuun tsekki, onko ollut hallituksessa, koska vain heillä on tämä käytössä
								System.out.println("ominaisuus on vielä kesken");
								break;
							case 0:
								if (voted) {
									System.out.println("Kiitos pelaamisesta");
									lopetus=true;
								} else {
									System.out.println("On pakko äänestää");
									break;
								}
								
							default:
								System.out.println("Virheellinen valinta");
							}
							
						} while (!lopetus);
					}
			}		
			 

	// näytetään ääniä saaneet
				// seuraava näyttää, mitä äsken tallennettiin listaan
				System.out.println("\nTällaiset tallennettiin uuteen listaan \n"+aanestyshenkilolista+"\n");
				for (int i=0; i<hallitusaanet.size(); i++) {
	/*				tämä on tarkoitus ainakin pistaa kokonaan
	 				System.out.println("\n\nnro: "+i+" blokattu: "+hallitusaanet.get(i).isBlokattu()+" pudotettu: "+hallitusaanet.get(i).isPudotettu());
				    System.out.println("Annetut äänet (pitäisi olla tyhjää tai vain yksi)");
					for (aanestyshenkilo x : hallitusaanet.get(i).getHenkilojaaanet()) {
				    	System.out.println("henkilo "+x.getNumero()+" aania "+x.getAania());
				    }*/
//					System.out.println("\nSeuraavaksi katsotaan tuleeko nämä tiedot ulos tästä uudesta listasta aanestyshenkilolista\n");
					System.out.println("\nnro: "+i+" blokattu: "+aanestyshenkilolista.get(i).isBlokattu()+" pudotettu: "+aanestyshenkilolista.get(i).isPudotettu());
				    System.out.println("Annetut äänet (pitäisi olla tyhjää tai vain yksi)");
					for (aanestyshenkilo x : aanestyshenkilolista.get(i).getHenkilojaaanet()) {
				    	System.out.println("henkilo "+x.getNumero()+" aania "+x.getAania());
				    }
				}	
				
				
				
				
				
  // poistetaan ne, joiden äänet kumottiin
				

         osallistujalista=osallistujalistacache;
		 input.nextLine();
		 System.out.println("\nÄäniä saivat");
		 
		 
		 List<hallitusjasen> uushallitus = new ArrayList<hallitusjasen>();
		 uushallitus=jarjestaHallitus(pelaajia, osallistujalista, hallitus);
//		 System.out.println(hallitus);
//		 System.out.println(uushallitus);
		 osallistujalista=hallitusOsallistujalistaan(pelaajia, osallistujalista, uushallitus);
		 
		 
		 
	     int eka=hallitus.get(0).getPelaajanumero();

		 int toka=hallitus.get(1).getPelaajanumero();

		 int kolmas=hallitus.get(2).getPelaajanumero();

		 String ekanimi=hallitus.get(0).getNimi();
		 String tokanimi=hallitus.get(1).getNimi();
		 String kolmasnimi=hallitus.get(2).getNimi();



		 
		 // hallitus valitsee presidentin
		 boolean presidentti=false;
		 
		 int ekalla=0; //eniten ääniä saanut
		 int tokalla=0; // toiseksi eniten ääniä saanut
		 int kolmannella=0; //3. eniten ääniä saanut
		 int kierros=0;
		 
		 System.out.println("\nHallitus valitseee keskuudestaan presidentin. Presidentin valinta suoritetaan pelillä.\n"
		 		+ "Jokainen valitsee kierroksella valkoisen tai mustan kiven piilossa muilta. Se, jolla on eri\n"
		 		+ "värinen kivi, kuin muilla saa yhden pisteen. Ensin kolme pistettä kokoon saanut, valitaan \n"
		 		+ "presidentiksi. Paina enteriä jatkaaksesi\n");
	   	input.nextLine();
//		 String turha=input.nextLine();
		 do {
			 int h1 = rand.nextInt(2);
			 int h2 = rand.nextInt(2);
			 int h3 = rand.nextInt(2);
			 kierros++;
			 if (h1!=h2 && h1!=h3) {
				 ekalla++;
			 } else if (h2!=h1 && h2!=h3) {
				 tokalla++;
			 } else if (h3!=h1 && h3!=h2) {
				 kolmannella++;
			 }
			 System.out.println("kierros "+kierros+" ääniä "+ekanimi+":"+kivi[h1]+". "+tokanimi+":"+kivi[h2]+". "+kolmasnimi+":"+kivi[h3]);
			 
		 } while (ekalla<3 && tokalla <3 && kolmannella<3);
		 
		 if (ekalla==3) {
			 henkilo=osallistujalista.get(eka);
			 henkilo.setPresidentti(true);
			 osallistujalista.set(eka, henkilo);
			 System.out.println("\nPresidentiksi valittiin "+henkilo.getNimi());
		 } else if (tokalla==3) {
			 henkilo=osallistujalista.get(toka);
			 henkilo.setPresidentti(true);
			 osallistujalista.set(toka, henkilo);
			 System.out.println("\nPresidentiksi valittiin "+henkilo.getNimi());
		 } else if (kolmannella==3) {
			 henkilo=osallistujalista.get(kolmas);
			 henkilo.setPresidentti(true);
			 osallistujalista.set(kolmas, henkilo);
			 System.out.println("\nPresidentiksi valittiin "+henkilo.getNimi());
		 } else System.out.println("Jotain meni vikaan, kellään ei ollut kolmea ääntä");
		 
		
		
	};

}


