package vPeli1;

public class poistetutMetodit {
	
	
	 
/*		 
	 // etsitään eniten ääniä saanut ja laitetaan numero kohtaan eka
	 for (int i=0; i<pelaajia; i++) {
		 henkilo=osallistujalista.get(i);
		 if (!henkilo.isPudotettu()) {
			 System.out.println(i+" "+henkilo.getNimi()+" sai "+henkilo.getAanestys()+" ääntä hallitukseen");
		     if(henkilo.getAanestys()>paras) {
		    	 paras=henkilo.getAanestys();
		    	 eka=i;
		    	 hallitus.add(0, i);
		    	 ekanimi=henkilo.getNimi();
		     }
	 }
	 }
	 henkilo=osallistujalista.get(eka);
	 System.out.println("\nEniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä");
	 String hallitus1=henkilo.getNimi();
	 henkilo.setHallituksessa(henkilo.getHallituksessa()+1);  // lisätään yksi hallituskausien määrään
	 henkilo.setHallitus(true);              // lisätään, että on hallituksessa
	 osallistujalista.set(eka, henkilo);

	 
	 // etsitäänj 2. eniten ääniä saanut ja numero kohtaan toka
	 
	 for (int i=0; i<pelaajia; i++) {
		 henkilo=osallistujalista.get(i);
		 if (!henkilo.isPudotettu()) {
			 if(henkilo.getAanestys()<=paras && henkilo.getAanestys()>toiseksiparas && i!=eka) {
				 toiseksiparas=henkilo.getAanestys();
				 toka=i;
				 hallitus.add(1, i);
				 tokanimi=henkilo.getNimi();
			 }
		 }
	 }
	 henkilo=osallistujalista.get(toka);
	 System.out.println("Toiseksi eniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä");
	 String hallitus2=henkilo.getNimi();
	 henkilo.setHallituksessa(henkilo.getHallituksessa()+1);  // lisätään yksi hallituskausien määrään
	 henkilo.setHallitus(true);          // lisätään, että on hallituksessa
	 osallistujalista.set(toka, henkilo);
	 
	 // etsitään 3. eniten ääniä saanut ja numero kohtaan komas
	 
	 for (int i=0; i<pelaajia; i++) {
		 henkilo=osallistujalista.get(i);
		 if (!henkilo.isPudotettu()) {
			 if(henkilo.getAanestys()<=toiseksiparas && henkilo.getAanestys()>kolmanneksi && i!=eka && i!=toka) {
				 kolmanneksi=henkilo.getAanestys();
				 kolmas=i;
				 hallitus.add(2, i);;
				 kolmasnimi=henkilo.getNimi();
				 
			 }
		 }
	 }
	 henkilo=osallistujalista.get(kolmas);
	 System.out.println("Kolmanneksi eniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä");
	 String hallitus3=henkilo.getNimi();
	 henkilo.setHallituksessa(henkilo.getHallituksessa()+1);  // lisätään yksi hallituskausien määrään
	 henkilo.setHallitus(true);          // lisätään, että on hallituksessa
	 osallistujalista.set(kolmas, henkilo);
//	 System.out.println("onko hallituksessa"+henkilo.isHallitus());
	 
	
	 
	 System.out.println("\nHallitukseen menevät "+hallitus1+", "+hallitus2+", "+hallitus3);
	 
	  */


	
	/*
	private void putoavanAanestys() {
	    henkilo henkilo=null;
	     henkilo henkilo2=null;
	     henkilo henkilo3=null;
		 Scanner input = new Scanner(System.in);
			Random rand = new Random();
		 int valinta=0;
		 int valinta2=0;
		 int valinta3=0;
		 int mukana=pelaajienMaara();
		 int laskuri=0;
		 int pressanro=0;
		 String pressa="";
		 int hallitus1=0;
		 String hallitusyksi="";
		 int hallitus2=0;
		 String hallituskaksi="";
			// lasketaan montako pelaajaa on pelissä mukana
		naytaPelaajia(false,false,true,false);
		nollaaAanestys();
		
		*/
		
/*			for (int i=0; i<pelaaja.length; i++) {
				henkilo=osallistujalista.get(i);
				if (!henkilo.isPudotettu()) {
					mukana++;
				
						if (henkilo.isHallitus()) {
							if (henkilo.isPresidentti()) {
								pressa=henkilo.getNimi();
								pressanro=i;
//								System.out.println("pressa löytyi, on "+pressa);
							} else 
						
						if (hallitusyksi=="") {
							hallitus1=i;
							hallitusyksi=henkilo.getNimi();
//							System.out.println("hallitus 1 löytyi, on "+hallitusyksi);
						} else {
							hallitus2=i;
							hallituskaksi=henkilo.getNimi();
//							System.out.println("hallitus 2 löytyi, on "+hallituskaksi);
						}
						
					}
				}
				henkilo.setAanestys(0);                     //Alustetaan äänimäärä 0:n kaikilla
				osallistujalista.set(i, henkilo);
			}		 
			int puolet=(int)Math.floor(mukana/2); */

		/*
			System.out.println("Ensin hallitus äänestää, kenet he haluavat tiputtaa. \n"
					+ "Sen jälkeen muut äänestävät hallituksen luottamuksesta\n");
			*/
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
	/*		System.out.println("\nTässä pelaajat, joita hallitus voi äänestää");
			naytaPelaajia(true,true,false, true);
			for (int i=0; i<pelaaja.length; i++) {
				henkilo=osallistujalista.get(i);
				if (!henkilo.isHallitus() && !henkilo.isPudotettu()) {
					System.out.println(i+": "+henkilo.getNimi()+" "+varit[henkilo.getRyhma()]);
				}
		     }
			
			
			    boolean hyvaksytty=false;
	             hyvaksytty=false;
	             henkilo=osallistujalista.get(hallitus1);
	             
	             
	              System.out.print("Ketä "+henkilo.getNimi()+"("+varit[henkilo.getRyhma()]+") äänestää: ");
	              
	              valinta=getValinta(true);
         
	              hyvaksytty=false;
		          henkilo=osallistujalista.get(hallitus2);
		          System.out.print("Ketä "+hallituskaksi+"("+varit[henkilo.getRyhma()]+") äänestää:");
		          
		          valinta2=getValinta(true);
	              
		          
		          hyvaksytty=false;
			      henkilo=osallistujalista.get(pressanro);
			      System.out.print("Ketä presidentti "+pressa+"("+varit[henkilo.getRyhma()]+") äänestää:");
			      
			      valinta3=getValinta(true);
             
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
			      
			      int putoaja=getEnitenAania();
			      henkilo=osallistujalista.get(putoaja);
			      System.out.println("\nEniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä. nro "+putoaja);
	
			      input.nextLine();
		// muut äänestävät hallituksesta pudotetavaa
		       nollaaAanestys();
		
			      System.out.println("Seuraavaksi hallituksen ulkopuoliset äänestävät kenet \n"
				+ "hallituksesta tiputetaan. Mikäli kaikki äänestävät samaa hallituksen,"
				+ "jäsentä, hän tippuu hän.");
			      
		naytaPelaajia(true, true, true, false);
		boolean epaluottamus=false;
		int ekaaanestetty = 0;
		boolean ekaloydetty=false;
		for (int i=0; i<pelaaja.length; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu() && !henkilo.isHallitus()) {
				System.out.print("Ketä "+henkilo.getNimi()+"("+varit[henkilo.getRyhma()]+") äänestää: ");
				 valinta=getValinta(false);
			      if (!epaluottamus && ekaaanestetty==valinta) {
			    	  epaluottamus=true;
			      }
				 
				 if (!ekaloydetty) {
					 ekaloydetty=true;
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
			putoaja=getEnitenAania();
		      henkilo=osallistujalista.get(putoaja);
			System.out.println("Hallituksen jäsen "+henkilo.getNimi()+" putoaa kisasta");
			henkilo.setPudotettu(true);
			osallistujalista.set(putoaja,henkilo);
		
		} else {
			valinta2=getEnitenAania();
			henkilo=osallistujalista.get(valinta2);
			System.out.println("Peruspelaaja "+henkilo.getNimi()+" putoaa kisasta");
			henkilo.setPudotettu(true);
			osallistujalista.set(valinta2,henkilo);
		}
		


		// jos muut ovat keskittäneet äänenensä yhteen hallituksen jäseneen, hallituksen jäsen tipahtaa, muutoin hallituksen päättämä henkilö tippuu pelistä
		
		
		
	}
	*/
	/*
	private void nollaaAanestys() {
		henkilo henkilo=null;
		for (int i=0; i<pelaaja.length; i++) {
			henkilo=osallistujalista.get(i);
			if (!henkilo.isPudotettu()) {
	//			mukana++;
			}
			henkilo.setAanestys(0);                     //Alustetaan äänimäärä 0:n kaikilla
			henkilo.setHallitus(false);               //Alustetaan, ettei kukaan tällä hetkellä ole hallituksessa
			osallistujalista.set(i, henkilo);
		}	
	    
	}
	*/
	
	
	
	
	/*
	private void aanestaHallitusta() {
	     henkilo henkilo=null;
	     henkilo henkilo2=null;
		 Scanner input = new Scanner(System.in);
			Random rand = new Random();
		 int valinta=0;
		 int mukana=0;
		 int laskuri=0;
		 
		 System.out.println("\n-------------\n Äänestetään 3 edustajaa hallitukseen\n-------------\n");
			// lasketaan montako pelaajaa on pelissä mukana
			for (int i=0; i<pelaaja.length; i++) {
				henkilo=osallistujalista.get(i);
				if (!henkilo.isPudotettu()) {
					mukana++;
				}
				henkilo.setAanestys(0);                     //Alustetaan äänimäärä 0:n kaikilla
				henkilo.setHallitus(false);               //Alustetaan, ettei kukaan tällä hetkellä ole hallituksessa
				osallistujalista.set(i, henkilo);
			}		 
			int puolet=(int)Math.floor(mukana/2);

			System.out.println("Mukana ovat:");
			for (int j=0; j<pelaaja.length; j++) {   //esitellään äänestettävät
				henkilo2=osallistujalista.get(j);
				if (!henkilo2.isPudotettu()) {System.out.println(j+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);}
			} 

				for (int i=0; i<pelaaja.length; i++) { // käydään lista läpi 
					henkilo=osallistujalista.get(i);

					if (!henkilo.isPudotettu()) { //jos henkilö ei ole pudonnut, hän saa äänestää
						laskuri++;				
						System.out.print("Ketä "+henkilo.getNimi()+"("+varit[henkilo.getRyhma()]+") äänestää: ");
						do {
							valinta = input.nextInt();
							henkilo2=osallistujalista.get(valinta);
							if (henkilo2.isPudotettu()) { System.out.println("Valitsit pudonneen, valitse uudelleen: "); 
							} else	System.out.println(henkilo.getNimi()+" äänesti numeroa "+valinta+" "+henkilo2.getNimi()+" "+varit[henkilo2.getRyhma()]);
						} while (henkilo.isPudotettu()); 
						henkilo2.setAanestys(henkilo2.getAanestys()+1);
						osallistujalista.set(valinta, henkilo2);	
					}
				}		
			 

	
				int eka=0;
		 int paras=0;
		 int toka=0;
		 int toiseksiparas=0;
		 int kolmas=0;
		 int kolmanneksi=0;
		 String ekanimi="";
		 String tokanimi="";
		 String kolmasnimi="";
		 input.nextLine();
		 System.out.println("\nÄäniä saivat");
		 
		 
		 // etsitään eniten ääniä saanut ja laitetaan numero kohtaan eka
		 for (int i=0; i<pelaaja.length; i++) {
			 henkilo=osallistujalista.get(i);
			 if (!henkilo.isPudotettu()) {
				 System.out.println(i+" "+henkilo.getNimi()+" sai "+henkilo.getAanestys()+" ääntä hallitukseen");
			     if(henkilo.getAanestys()>paras) {
			    	 paras=henkilo.getAanestys();
			    	 eka=i;
			    	 hallitus.add(0, i);
			    	 ekanimi=henkilo.getNimi();
			     }
		 }
		 }
		 henkilo=osallistujalista.get(eka);
		 System.out.println("\nEniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä");
		 String hallitus1=henkilo.getNimi();
		 henkilo.setHallituksessa(henkilo.getHallituksessa()+1);  // lisätään yksi hallituskausien määrään
		 henkilo.setHallitus(true);              // lisätään, että on hallituksessa
		 osallistujalista.set(eka, henkilo);

		 
		 // etsitäänj 2. eniten ääniä saanut ja numero kohtaan toka
		 
		 for (int i=0; i<pelaaja.length; i++) {
			 henkilo=osallistujalista.get(i);
			 if (!henkilo.isPudotettu()) {
				 if(henkilo.getAanestys()<=paras && henkilo.getAanestys()>toiseksiparas && i!=eka) {
					 toiseksiparas=henkilo.getAanestys();
					 toka=i;
					 hallitus.add(1, i);
					 tokanimi=henkilo.getNimi();
				 }
			 }
		 }
		 henkilo=osallistujalista.get(toka);
		 System.out.println("Toiseksi eniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä");
		 String hallitus2=henkilo.getNimi();
		 henkilo.setHallituksessa(henkilo.getHallituksessa()+1);  // lisätään yksi hallituskausien määrään
		 henkilo.setHallitus(true);          // lisätään, että on hallituksessa
		 osallistujalista.set(toka, henkilo);
		 
		 // etsitään 3. eniten ääniä saanut ja numero kohtaan komas
		 
		 for (int i=0; i<pelaaja.length; i++) {
			 henkilo=osallistujalista.get(i);
			 if (!henkilo.isPudotettu()) {
				 if(henkilo.getAanestys()<=toiseksiparas && henkilo.getAanestys()>kolmanneksi && i!=eka && i!=toka) {
					 kolmanneksi=henkilo.getAanestys();
					 kolmas=i;
					 hallitus.add(2, i);;
					 kolmasnimi=henkilo.getNimi();
					 
				 }
			 }
		 }
		 henkilo=osallistujalista.get(kolmas);
		 System.out.println("Kolmanneksi eniten sai "+henkilo.getNimi()+" "+henkilo.getAanestys()+" ääntä");
		 String hallitus3=henkilo.getNimi();
		 henkilo.setHallituksessa(henkilo.getHallituksessa()+1);  // lisätään yksi hallituskausien määrään
		 henkilo.setHallitus(true);          // lisätään, että on hallituksessa
		 osallistujalista.set(kolmas, henkilo);
//		 System.out.println("onko hallituksessa"+henkilo.isHallitus());
		 
		 System.out.println("\nHallitukseen menevät "+hallitus1+", "+hallitus2+", "+hallitus3);
		 
		 




		 
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
		 String turha=input.nextLine();
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
	*/
	
	
	
/*
	private int getEnitenAania() {
		int kuka=0;
		 henkilo henkilo=null;
		int paras=0;
		String ekanimi="";
//		System.out.println("Tarkastetaan kuka sai eniten ääniä");

		 for (int i=0; i<pelaaja.length; i++) {
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
	
	private int getValinta(boolean hallituksessa) {
		int valinta=0;
		henkilo henkilo=null;
		Scanner input = new Scanner(System.in);
		boolean hyvaksytty=false;
        do {
      	  valinta=input.nextInt();
  	         if (valinta<pelaaja.length) {
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
	*/	
	
	
	
	
	/*
    private void rPeli(int jakso) {
    	Valtapeli_1 ohjelma = new Valtapeli_1();
    	  Scanner input = new Scanner(System.in);
	    System.out.println("Peli alkaa ryhminen jakamisella, Ryhmiin jaettavie pelaajia on");
		Random rand = new Random();
		henkilo henkilo=null;

		System.out.println("arvottiin kaksi joukkuetta");
		
        naytaPeliryhmat();

			
			System.out.println("\nPelataan peli "+kierrospeli[jakso]+"\n");
			
			//arvotaan jokaiselle pelaajalle "summa väliltä 1-20"
//			ohjelma.arvoPelaajantulos(20);

			for (int i=0; i<pelaaja.length; i++) {
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
			for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 0, eli ekat
				henkilo=osallistujalista.get(i);
				if (!henkilo.isPudotettu() && henkilo.getAliryhma()==0) {
					ekatyhteensa=ekatyhteensa+henkilo.getPelintulos();
					System.out.println(henkilo.getNimi()+" tulos: "+henkilo.getPelintulos());
				}
				
			}
	
			
			int tokatyhteensa=0;
			System.out.println("\nToka peliryhmä:");
			for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 1, eli tokat
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
		     		annetaanPisteita(0,1,3,2,0);
		     		annetaanPisteita(1,0,2,1,0);

		     	} else if (!ekatvoitti) { // jos ryhmä tokat voitti, heidän parhaat saa pisteitä
		     		System.out.println("\nTokat voitti pelin ja saavat +1 polettia per henkilö, paras +3\n"
		     				+ "hävinneen ryhmän paras saa 2 polettia ja toka 1:n\n");
		     	     annetaanPisteita(1,1,3,2,0);
			     		annetaanPisteita(0,0,2,1,0);
		     		
		     	}

			}
			naytaRyhmat();
			System.out.println();
			input.nextLine();
		};
		
	
	private void annetaanPisteita(int ryhma, int pisteitakaikille, int pparhaalle, int tokalle, int kolmannelle) {
		 henkilo henkilo=null;
		 int poletitnyt=0;
		 int suurin=0;
		 int kenella=0;
		 int maarapoletit=0;
		 int maara=0;
		 Integer tulos=0;
		 Integer suurin2=0;
		 
		for (int i=0; i<pelaaja.length; i++) {   //näytetään ryhmä 0, eli ekat
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
		
		for (int i=0; i<pelaaja.length; i++) { // testataan, monnellako on suurin luku sama
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
			for (int i=0; i<pelaaja.length; i++) { // testataan, monnellako on suurin luku sama
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
			 for (int i=0; i<pelaaja.length; i++) {
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
		
	private void yksiloPelidull() {
		
	};
	
	private void pariPelidull() {
		
	};
	*/
	
	
	
	
	
	
	
	
	

}
