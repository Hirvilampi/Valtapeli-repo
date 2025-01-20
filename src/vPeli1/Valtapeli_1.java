package vPeli1;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Valtapeli_1 {
	private static  ArrayList<henkilo> osallistujalista = new ArrayList<henkilo>();
	private static List<hallitusjasen>  hallitus = new ArrayList<>();
	
	private static String[] pelaaja = {
			"Marjo", "Jenni" , "Heidi", "Henriikka", 
//			"Tanja", "Iiris", "Niko", "Sami", "Archie", "Kari",
			"Perttu", "Jari"};
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
	private String[] kivi = { "valkea", "musta" };
	private static int pelaajia;;
	
	
	private void lisaavakioPelaajat() {
		henkilo henkilo=null;
		this.pelaajia=pelaaja.length;
		for (int i=0; i<pelaaja.length; i++) {
			henkilo tyyppi = new henkilo(pelaaja[i],false,false,0,false,false,0,false,0,false,0,0,0,0,0,0,0,0);
			osallistujalista.add(tyyppi);
			
		}
		
	};
	
	private int pelaajienMaara() {
		int maara=0;
		henkilo henkilo=null;
		for (int i=0; i<pelaaja.length; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
				maara++;
			}
			
		}
		return maara;
	}
		
	private void naytaPoletit() {
		henkilo henkilo=null;
		for (int i=0; i<pelaaja.length; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
				System.out.println(henkilo.getNimi()+" omistaa "+henkilo.getPoletit()+" polettia");
			}

			
		}
		
	};
	
	private void jaaRyhmat() {
		Random rand = new Random();
		henkilo henkilo=null;
		for (int i=0; i<pelaaja.length; i++) {   //jaetaan kolmeen ryhmään 0,1,2
			henkilo=osallistujalista.get(i);
			 int rand_int1 = rand.nextInt(3);
			 henkilo.setRyhma(rand_int1);
			 osallistujalista.set(i, henkilo);
			
		}
	}
	
	private void naytaRyhmat() {
		henkilo henkilo=null;        
			
		System.out.println("\nPunainen ryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 0
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==0) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
			
			}
			
		}
		
		System.out.println("\nSininen ryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 1
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==1) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
			
			}
			
		}
		
		System.out.println("\nVihreä ryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 2
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getRyhma()==2) {
				System.out.print(i+". "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit());
				if (henkilo.isHallitus()) {
					System.out.println(" - hallituksen jäsen. Hallituskertoja "+henkilo.getHallituksessa());
				} else System.out.println();
			
			}
		}
	}
	
	
	private void joukkeajako() {  // jaetaan kahteen aliryhmään
		henkilo henkilo=null;
		int ykkosia=0;	
		int nollia=0;	
		int mukana=pelaajienMaara();
		

		// lasketaan montako pelaajaa on pelissä mukana
 
		int puolet=(int)Math.floor(mukana/2);
		
		System.out.println("mukana "+mukana+" puolet noista "+puolet);
		
		Random rand = new Random();
		// arvotaan kaksi joukkuetta
		 for (int j=0; j<mukana; j++) {
				int randi1 = rand.nextInt(2);
				if (randi1==0) {
					nollia++;
				} else if (randi1==1) {
					ykkosia++;
				}
			 if (randi1==1 && ykkosia<=puolet) { 
				
				   henkilo=osallistujalista.get(j);
					 henkilo.setAliryhma(randi1);;
					 osallistujalista.set(j, henkilo);
				 
				 
			 } else if (randi1==0 && nollia<=puolet){
			
				 henkilo=osallistujalista.get(j);
				 henkilo.setAliryhma(randi1);;
				 osallistujalista.set(j, henkilo);
				 
			 } else if (nollia>=puolet) {
				 ykkosia++;
			     henkilo=osallistujalista.get(j);
				 henkilo.setAliryhma(1);;
				 osallistujalista.set(j, henkilo);
			 } else if (ykkosia>=puolet) {
				 nollia++;
			     henkilo=osallistujalista.get(j);
				 henkilo.setAliryhma(0);;
				 osallistujalista.set(j, henkilo);
			 }
		 }
		
	}
	
	private void naytaPeliryhmat() { // näytetään peliryhmät
		System.out.print("\nEka peliryhmä:");
		henkilo henkilo=null;
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 0
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getAliryhma()==0) {
				System.out.print(henkilo.getNimi()+" ");
			}
			
		}
		System.out.println();
		System.out.print("\nToka peliryhmä:");
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 1
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getAliryhma()==1) {
				System.out.print(henkilo.getNimi()+" ");
			}
			
	     }


		System.out.println();
	}
	
	private void arvoPelaajantulos(int max) {
		henkilo henkilo=null;
		Random rand = new Random();
		for (int i=0; i<pelaaja.length; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
				int randi1 = rand.nextInt(max)+1;
				henkilo.setPelintulos(randi1);
				osallistujalista.set(i,henkilo);
			}
		}
		
	}
	
	
	private int naytaRyhmantulokset(int ryhmanro) {
		int ekatyhteensa=0;
		henkilo henkilo=null;
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhman tulokset syötetylla muuttujalla ryhmanro, eli ekat
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && henkilo.getAliryhma()==ryhmanro) {
				ekatyhteensa=ekatyhteensa+henkilo.getPelintulos();
				System.out.println(henkilo.getNimi()+" tulos: "+henkilo.getPelintulos());
			}
			
		}
		return ekatyhteensa;
	}
	
	
	
	
	private void jaaPoletteja() {
		     henkilo henkilo=null;
		     Valtapelit valtapelit = new Valtapelit();
			  Scanner input = new Scanner(System.in);
				Valtapeli_1 ohj = new Valtapeli_1();
				int numero=0;
				int montako=0;
				int kenelta=0;
				int annapolet=0;
				int kenelle=0;
	//			ohj.naytaRyhmat();
				 Console c = System.console();
				do {
					System.out.flush();  
	
					System.out.println("Tässä osiossa voi jakaa poletteja toisille\\n");
					

					
					System.out.println("\n1. Näytä ryhmät ja poletit");
					System.out.println("2. Anna poletteja");
	//				System.out.println("3. äeneäestäe hallitusta");
	//				System.out.println("4. näytä poletit");
					System.out.println("0. Lopetus");
					System.out.print("Anna valintasi (0-5): ");
					numero = input.nextInt();
					System.out.println();

					switch (numero) {
					case 1:
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
						

						break;
					case 2:
						montako=0;
						System.out.println("Keneltä haluat antaa poletteja");
						for (int i=0; i<pelaaja.length; i++) {
							henkilo=osallistujalista.get(i);
							if (!henkilo.isPudotettu()) {
								montako++;
								System.out.println(i+": "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit()+" "+varit[henkilo.getRyhma()]);
							}
						}
						System.out.print("Anna valintasi (0-"+montako+"): ");
						kenelta=input.nextInt();
						if (kenelta>=0 && kenelta<=montako) {
							henkilo=osallistujalista.get(kenelta);
							System.out.println("Montako polettia annetaan (max "+henkilo.getPoletit()+": ");
							annapolet = input.nextInt();
							if (annapolet>0 && annapolet<=henkilo.getPoletit()) {
								
								System.out.println("Kenelle annetaan");
								for (int j=0; j<pelaaja.length; j++) {
									henkilo=osallistujalista.get(j);
									if (!henkilo.isPudotettu()) {
										montako++;
										System.out.println(j+": "+henkilo.getNimi()+" poletteja: "+henkilo.getPoletit()+" "+varit[henkilo.getRyhma()]);
										
									}
								
									}
								System.out.println("Anna henkilön numero, jolle annetaan "+annapolet+" polettia : ");
								kenelle = input.nextInt();
								if (kenelle>=0 && kenelle<=montako) {
									henkilo=osallistujalista.get(kenelta);
									henkilo.setPoletit(henkilo.getPoletit()-annapolet);
									osallistujalista.set(kenelta, henkilo);
									henkilo=osallistujalista.get(kenelle);
									henkilo.setPoletit(henkilo.getPoletit()+annapolet);
									osallistujalista.set(kenelle, henkilo);
								}
							} else {
								System.out.println("Väärä määrä. Palataan alkuun");
								annapolet = input.nextInt();
							}
						}
						
						
				//		ohjelma.naytaAutot();
						break;
					case 3:
				//		ohjelma.lisaaNopeutta();
						break;
					case 6:
				//		ohjelma.poistaAuto();
					
						break;
					case 0:
						break;
					default:
						System.out.println("Virheellinen valinta");
					}
				} while (numero!=0);
		
		
	};
	

	private void pudotaYksi() {
	
		     henkilo henkilo=null;
			 Scanner input = new Scanner(System.in);
			 int valinta=0;
			 int mukana=0;
			 int laskuri=0;
			 System.out.println("Kenet pudotetaan");
				// lasketaan montako pelaajaa on pelissä mukana
			    mukana=pelaajienMaara();
			  
			    naytaPelaajia(true,true,false,false);
			    /*
				for (int i=0; i<pelaaja.length; i++) {
					henkilo=osallistujalista.get(i);
					if (!henkilo.isPudotettu()) {
						mukana++;
						System.out.println(i+". "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
					}
				}		 
				*/
				
				int puolet=(int)Math.floor(mukana/2);
				System.out.println("mukana "+mukana);

			 
			 do {	 
				 valinta = input.nextInt();
				 henkilo=osallistujalista.get(valinta);	 
			 } while (henkilo.isPudotettu() && valinta>=0 && valinta<=11 && henkilo.isImmuniteetti());
			 
			 henkilo.setHallitus(false);
			 henkilo.setPudotettu(true);
			 osallistujalista.set(valinta, henkilo);
			 
			 System.out.println("Pudotettiin "+henkilo.getNimi());
		
	};
	
	private void naytaPudotetut() {
		  henkilo henkilo=null;
		 System.out.println("\nNämä pelaajat ovat pudonneet pelistä");
			// lasketaan montako pelaajaa on pelissä mukana
			for (int i=0; i<pelaaja.length; i++) {
				henkilo=osallistujalista.get(i);
				if (henkilo.isPudotettu()) {
					System.out.println(henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
				}
			}		 
	};
	

	
	private void naytaPelaajia(boolean pelit, boolean kaikkitulokset, boolean hallitus, boolean vainpelaajat) {
		 henkilo henkilo=null;
		 if (hallitus) { System.out.println("\nHallituksessa ovat:"); }
		
		for (int i=0; i<pelaaja.length; i++) {
			henkilo=osallistujalista.get(i);
			
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


	private void muutaPressaImmuuniksi() {
	// käy läpi porukan ja jos immuniteetti true, muuttaa sen falseksi
	// jos	porukassa jollain on presidentti=true, se muuttuu falseksi ja immuniteetti muuttuu true muotoon
	// 	tällöin expresidentti=true ja pressakaudet +1
	// kaikkien äänimäärä nollataan, myös pudonneiden
		henkilo kuka=null;
		for (int i=0; i<pelaaja.length; i++) {
			kuka=osallistujalista.get(i);
			if (kuka.isImmuniteetti()) {
				kuka.setImmuniteetti(false);
				osallistujalista.set(i, kuka);
			}
		}
		for (int i=0; i<pelaaja.length; i++) {
			kuka=osallistujalista.get(i);
			if (kuka.isPresidentti() && !kuka.isPudotettu()) {
				kuka.setImmuniteetti(true);
				kuka.setPressakaudet(kuka.getPressakaudet()+1);
				osallistujalista.set(i, kuka);
				System.out.println("\n    Edellisessä jaksossa valittu presidentti "+kuka.getNimi()+" on suojassa ja häntä ei voi pudottaa tässä jaksossa");
			}
		}
	
	}
	
	private void lisaaHallituksellepoletti() {
		henkilo kuka=null;
		for (int i=0; i<pelaaja.length; i++) {
			kuka=osallistujalista.get(i);
			if (kuka.isHallitus()) {
				kuka.setPoletit(kuka.getPoletit()+1);;
				osallistujalista.set(i, kuka);
			}
		}
	}
	
	
	public static void main(String[] args) {
			Valtapeli_1 ohjelma = new Valtapeli_1();
			Valtapelit pelit;
			naytaLuokka nayta = new naytaLuokka();
			ryhmaPeli1 peli = new ryhmaPeli1();
			aanestaHallitus aanestaHallitus = new aanestaHallitus();
			aanestaPutoajaa aanesta = new aanestaPutoajaa();
			boolean onkopelipelattu = false;


			int valinta;
			int jakso=1;
			String enter;
			Scanner input = new Scanner(System.in);
			 Console c = System.console();
			 boolean onkohallitusvalittu=false;
	
			
			ohjelma.lisaavakioPelaajat();
			vpelit vpeli = new vpelit();

	//		ohjelma.jaaRyhmat();
	//		ohjelma.naytaPoletit();
	//	     ohjelma.naytaRyhmat();
		
			 vpeli.jaaRyhmatv(pelaaja, osallistujalista);			
			 vpeli.naytaViesti("");
			 vpeli.naytaRyhmatv("\nPelissä mukana ovat ", pelaajia, osallistujalista);
			 System.out.println();

			do {
				System.out.println("\nJakso "+jakso+"\n");

				
				
				if (!onkopelipelattu) { System.out.println("\n1. Pelaa ryhmäpeli");
					} else {System.out.println("\n1. Pelaa ryhmäpeli - pelattu tässä jaksossa");}
				System.out.println("2. Jaa poletteja");
				if (!onkohallitusvalittu) { System.out.println("3. Äänestä hallitusta");
				} else {System.out.println("3. Äänestä hallitusta - valittu tässä jaksossa");}
				System.out.println("4. Äänestä putoavaa");
				System.out.println("5. Nayta ryhmät ja poletit");
				System.out.println("6. Mene seuraavaan jaksoon");
				System.out.println("7. Pudota pelaaja");
				System.out.println("8. Näytä pudotetut pelaajat");
				System.out.println("0. Lopetus");
				System.out.print("Anna valintasi (0-5): ");
				valinta = input.nextInt();
				System.out.println();

				switch (valinta) {
				case 1:
					if (!onkopelipelattu) {
						System.out.println("Pelataan ryhmäpeli");
						ohjelma.joukkeajako();
						c.readLine();
//						ohjelma.rPeli(jakso);
						peli.rPeli(jakso, pelaaja.length, osallistujalista);
						input.nextLine();
						onkopelipelattu=true;

					} else {
						System.out.println("Peli on jo pelattu tässä jaksossa");
					}

					break;
				case 2:
					ohjelma.jaaPoletteja();

					break;
				case 3:
					
	//				ohjelma.aanestaHallitusta();
					if (!onkohallitusvalittu) {
						aanestaHallitus.aanestaHallitusta(pelaajia, osallistujalista, hallitus);
						onkohallitusvalittu=true;
						} else {
							System.out.println("Hallitus on jo valittu tässä jaksossa");
						}
					
					break;
				case 4:
					System.out.println("Pelaajia mukana "+ohjelma.pelaajienMaara());
					if (onkohallitusvalittu) {
//						ohjelma.putoavanAanestys();
						aanesta.putoavanAanestys(pelaaja.length, osallistujalista, hallitus);
					} else System.out.println("Hallitusta ei ole valittu, putoajaa ei voi äänestää");
			//		pelaajia=ohjelma.pelaajienMaara();
					System.out.println("Pelaajia mukana "+ohjelma.pelaajienMaara());
					break;
				case 5:
					ohjelma.naytaRyhmat();
		

					break;
				case 6:
			//		ohjelma.poistaAuto();
					jakso++;
					ohjelma.lisaaHallituksellepoletti();
					ohjelma.muutaPressaImmuuniksi();
					onkopelipelattu=false;
					onkohallitusvalittu=false;
					break;
				case 7:
				    ohjelma.pudotaYksi();
					break;
				case 8:
					ohjelma.naytaPudotetut();
					break;
				case 0:
					System.out.println("Kiitos pelaamisesta");
				default:
					System.out.println("Virheellinen valinta");
				}
			} while (jakso < 11 && valinta!=0);
	
	}
	

}
