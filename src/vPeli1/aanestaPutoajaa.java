package vPeli1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class aanestaPutoajaa {
	private String[] varit = {"Punainen", "Sininen", "Vihreä"};
	private String[] kivi = { "valkea", "musta" };

	
	
	public void putoavanAanestys(int pelaajia, ArrayList<henkilo> osallistujalista, List<hallitusjasen> hallitus) {
		  henkilo henkilo=null;
		     henkilo henkilo2=null;
		     henkilo henkilo3=null;
			 Scanner input = new Scanner(System.in);
				Random rand = new Random();
			 int valinta=0;
			 int valinta2=0;
			 int valinta3=0;
			 int mukana=pelaajia;
			 int laskuri=0;
			 int pressanro=0;
			 String pressa="";
			 int hallitus1=0;
			 String hallitusyksi="";
			 int hallitus2=0;
			 String hallituskaksi="";
				// lasketaan montako pelaajaa on pelissä mukana
			naytaPelaajia(false,false,true,false, pelaajia, osallistujalista);
			nollaaAanestys(pelaajia, osallistujalista);
			
			
			
				for (int i=0; i<pelaajia; i++) {
					henkilo=osallistujalista.get(i);
					if (!henkilo.isPudotettu()) {
						mukana++;
					
							if (henkilo.isHallitus()) {
								if (henkilo.isPresidentti()) {
									pressa=henkilo.getNimi();
									pressanro=i;
//									System.out.println("pressa löytyi, on "+pressa);
								} else 
							
							if (hallitusyksi=="") {
								hallitus1=i;
								hallitusyksi=henkilo.getNimi();
//								System.out.println("hallitus 1 löytyi, on "+hallitusyksi);
							} else {
								hallitus2=i;
								hallituskaksi=henkilo.getNimi();
//								System.out.println("hallitus 2 löytyi, on "+hallituskaksi);
							}
							
						}
					}
					henkilo.setAanestys(0);                     //Alustetaan äänimäärä 0:n kaikilla
					osallistujalista.set(i, henkilo);
				}		 


			
				System.out.println("Ensin hallitus äänestää, kenet he haluavat tiputtaa. \n"
						+ "Sen jälkeen muut äänestävät hallituksen luottamuksesta\n");
		/*		
				
			// hallitus äänestää, kenet aikoo pudottaa
				naytaPelaajia(false,false,true,false);
		  	System.out.println("\nHallituksessa ovat:");
				for (int i=0; i<pelaaja.length; i++) {
					henkilo=osallistujalista.get(i);
					if (henkilo.isHallitus()) {
						System.out.print(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
						if (henkilo.isPresidentti()) {
							System.out.println(" on presidentti");
						} else System.out.println();
					}

			 }
				*/
				
				// näytetään ketä hallitus voi äänestää ja heidän liittoumansa
				System.out.println("\nTässä pelaajat, joita hallitus voi äänestää");
				naytaPelaajia(true,true,false, true, pelaajia, osallistujalista);


				
				
				    boolean hyvaksytty=false;
		             hyvaksytty=false;
		             henkilo=osallistujalista.get(hallitus1);
		             
		             
		              System.out.print("Ketä "+henkilo.getNimi()+"("+varit[henkilo.getRyhma()]+") äänestää: ");
		              
		              valinta=getValinta(true, pelaajia, osallistujalista);
	         
		              hyvaksytty=false;
			          henkilo=osallistujalista.get(hallitus2);
			          System.out.print("Ketä "+hallituskaksi+"("+varit[henkilo.getRyhma()]+") äänestää:");
			          
			          valinta2=getValinta(true, pelaajia, osallistujalista);
		              
			          
			          hyvaksytty=false;
				      henkilo=osallistujalista.get(pressanro);
				      System.out.print("Ketä presidentti "+pressa+"("+varit[henkilo.getRyhma()]+") äänestää:");
				      
				      valinta3=getValinta(true, pelaajia, osallistujalista);
	             
		              System.out.println("Lasketaan äänet. Tasapelissä presidentin ääni ratkaisee.\n");
		              
		      
				      System.out.println("Ääniä saivat: ");
				      henkilo=osallistujalista.get(valinta);
				      henkilo.setAanestys(henkilo.getAanestys()+10);
				      osallistujalista.set(valinta, henkilo);
				      System.out.println(henkilo.getNimi());
				      
				      henkilo=osallistujalista.get(valinta2);
				      henkilo.setAanestys(henkilo.getAanestys()+10);
				      osallistujalista.set(valinta2, henkilo);
				      System.out.println(henkilo.getNimi());
				      
				      henkilo=osallistujalista.get(valinta3);
				      henkilo.setAanestys(henkilo.getAanestys()+11);
				      osallistujalista.set(valinta3, henkilo);
				      System.out.println(henkilo.getNimi());
				      
				      
				      
				      
				      System.out.println("Putoamisvaarassa on ");
				      
				      int putoaja=getEnitenAania(pelaajia,osallistujalista);
				      henkilo=osallistujalista.get(putoaja);
				      System.out.println("\nEniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä. nro "+putoaja);
		
				      input.nextLine();
			// muut äänestävät hallituksesta pudotetavaa
			       nollaaAanestys( pelaajia, osallistujalista);
			
				      System.out.println("Seuraavaksi hallituksen ulkopuoliset äänestävät kenet \n"
					+ "hallituksesta tiputetaan. Mikäli kaikki äänestävät samaa hallituksen,"
					+ "jäsentä, hän tippuu hän.");
				      
			naytaPelaajia(true, true, true, false, pelaajia, osallistujalista);
			boolean epaluottamus=true;
			int ekaaanestetty=99;
			boolean ekaloydetty=false;
			int nouseva = 0;
			for (int i=0; i<pelaajia; i++) {
				henkilo=osallistujalista.get(i);
				if (!henkilo.isPudotettu() && !henkilo.isHallitus()) {
					System.out.print("Ketä "+i+". "+henkilo.getNimi()+"("+varit[henkilo.getRyhma()]+") äänestää: ");
					 valinta=getValinta(false, pelaajia, osallistujalista);
					 
					 
					 
				      if (epaluottamus && nouseva>0) {
				    	  if (valinta!=ekaaanestetty) { epaluottamus=false; }
				      }
				      
				      if (nouseva==0) { // mikäli ei vielä ole äänestetty ketään, mennään laittamaan eka valinta
				    	  nouseva=1;
				    	  ekaaanestetty=valinta;
				      }

					 
					 henkilo2=osallistujalista.get(valinta);
				      henkilo2.setAanestys(henkilo2.getAanestys()+1);
				      osallistujalista.set(valinta, henkilo2);
				      System.out.println(henkilo2.getNimi());

				}
	            
	            
	           
			}
			
			if (epaluottamus) {
				System.out.println("Epäluottamus hallitusta kohtaa syntyi, kaikki ovat samaa mieltä. Yksi hallituksen jäsen tippuu.");
				putoaja=getEnitenAania(pelaajia,osallistujalista);
			      henkilo=osallistujalista.get(putoaja);
				System.out.println("Hallituksen jäsen "+henkilo.getNimi()+" putoaa kisasta");
				henkilo.setPudotettu(true);
				osallistujalista.set(putoaja,henkilo);
			
			} else {
				//valinta2=getEnitenAania(pelaajia,osallistujalista);
				henkilo=osallistujalista.get(putoaja);
				System.out.println("Peruspelaaja "+henkilo.getNimi()+" putoaa kisasta");
				henkilo.setPudotettu(true);
				osallistujalista.set(putoaja,henkilo);
			}
			
	}
	
	private void nollaaAanestys(int pelaajia, ArrayList<henkilo> osallistujalista) {
		henkilo henkilo=null;
		for (int i=0; i<pelaajia; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
	//			mukana++;
			}
			henkilo.setAanestys(0);                     //Alustetaan äänimäärä 0:n kaikilla
	
			osallistujalista.set(i, henkilo);
		}	
	}
	
	private void naytaPelaajia(boolean pelit, boolean kaikkitulokset, boolean hallitus, boolean vainpelaajat, int pelaajia, ArrayList<henkilo> osallistujalista) {
	
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
							System.out.println();
						}
						}else {
							if (vainpelaajat) { if(!henkilo.isHallitus()) {
								System.out.print(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
								if (pelit) {System.out.print(" pelit "+henkilo.getPelityhteensa());}
								if (kaikkitulokset) {System.out.print(" tulokset "+henkilo.getKaikkitulokset());}
								System.out.println();
							}
								
							}else {
								System.out.print(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
								if (pelit) {System.out.print(" pelit "+henkilo.getPelityhteensa());}
								if (kaikkitulokset) {System.out.print(" tulokset "+henkilo.getKaikkitulokset());}
								System.out.println();
							}

						}
					
				}
			
		}
	}
	
	
	private int getEnitenAania(int pelaajia, ArrayList<henkilo> osallistujalista) {
		int kuka=0;
		 henkilo henkilo=null;
		int paras=0;
		String ekanimi="";
//		System.out.println("Tarkastetaan kuka sai eniten ääniä");

		 for (int i=0; i<pelaajia; i++) {
			 henkilo=osallistujalista.get(i);
			 if (!henkilo.isPudotettu()) {
				 System.out.println(i+" "+henkilo.getNimi()+" sai "+henkilo.getAanestys()+" pudotusääntä");
			     if(henkilo.getAanestys()>paras) {
			    	 paras=henkilo.getAanestys();
			    	 kuka=i;
			    	 ekanimi=henkilo.getNimi();
			     }
			 } 
		}	
		return kuka;
	}
	
	private int getValinta( boolean hallituksessa, int pelaajia, ArrayList<henkilo> osallistujalista) {
		int valinta=0;
		henkilo henkilo=null;
		Scanner input = new Scanner(System.in);
		boolean hyvaksytty=false;
        do {
      	  valinta=input.nextInt();
  	         if (valinta<pelaajia) {
  	         henkilo=osallistujalista.get(valinta);
  	         if (hallituksessa ) {
  	        	 if (!henkilo.isPudotettu() && !henkilo.isHallitus()) {
  	  	        	 hyvaksytty=true;
  	  	         }
  	         } else  if (!henkilo.isPudotettu() && henkilo.isHallitus()) {
	  	        	 hyvaksytty=true;
	  	         }
  	        
  	         }
      	  
        } while (!hyvaksytty);
        return valinta;
	}
	
	
	
	
		
}
