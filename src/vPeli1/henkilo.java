package vPeli1;

import java.util.ArrayList;
import java.util.Arrays;

public class henkilo {
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

	private String nimi;	
	private boolean expressa;
		private boolean immuniteetti;
		private int pressakaudet;
		private boolean blokattu;
		private boolean pudotettu;
		private int poletit;
		private boolean hallitus;  // onko hallituksessa juuri nyt
		private int hallituksessa; // montako kertaa on aiemmin ollut hallituksessa
		private boolean presidentti;
		private  int tippumiskierros;
		private int ryhma;
		private int aliryhma;
		private int pelintulos;
		private int pelityhteensa;
		private int aanestys;
		private int kaikkipoletit;
		private int kaikkitulokset;
		private int numero;
		private String nimihallitus;
		
		
		public henkilo() {
			nimi="";
			expressa=false;
			immuniteetti=false;
			pressakaudet=0;
			blokattu=false;
			pudotettu=false;
			poletit=0;
			hallitus=false;
			hallituksessa=0;
			presidentti=false;
			tippumiskierros=0;
			ryhma=0;
			aliryhma=0;
			pelintulos=0;
			pelityhteensa=0;
			aanestys=0;
			kaikkipoletit=0;
			kaikkitulokset=0;
		}
		






		public int getPelintulos() {
			return pelintulos;
		}





		public void setPelintulos(int pelintulos) {
			this.pelintulos = pelintulos;
		}





		public henkilo(String nimi, boolean expressa, boolean immuniteetti, int pressakaudet, boolean blokattu,
				boolean pudotettu, int poletit, boolean hallitusAlumni, int hallituksessa, boolean presidentti,
				int tippumiskierros, int ryhma, int aliryhma, int pelintulos, int pelityhteensa, int aanestys, int kaikkipoletit, int kaikkitulokset) {
			super();
			this.nimi = nimi;
			this.expressa = expressa;
			this.immuniteetti = immuniteetti;
			this.pressakaudet = pressakaudet;
			this.blokattu = blokattu;
			this.pudotettu = pudotettu;
			this.poletit = poletit;
			this.hallitus = hallitusAlumni;
			this.hallituksessa = hallituksessa;
			this.presidentti = presidentti;
			this.tippumiskierros = tippumiskierros;
			this.ryhma = ryhma;
			this.aliryhma = aliryhma;
			this.pelintulos = pelintulos;
			this.pelityhteensa = pelityhteensa;
			this.aanestys = aanestys;
			this.kaikkipoletit=kaikkipoletit;
			this.kaikkitulokset=kaikkitulokset;
		}



		public int getKaikkipoletit() {
			return kaikkipoletit;
		}





		public void setKaikkipoletit(int kaikkipoletit) {
			this.kaikkipoletit = kaikkipoletit;
		}





		public int getKaikkitulokset() {
			return kaikkitulokset;
		}





		public void setKaikkitulokset(int kaikkitulokset) {
			this.kaikkitulokset = kaikkitulokset;
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





		public String[] getVarit() {
			return varit;
		}





		public void setVarit(String[] varit) {
			this.varit = varit;
		}





		public int getAanestys() {
			return aanestys;
		}





		public void setAanestys(int aanestys) {
			this.aanestys = aanestys;
		}





		public String getNimi() {
			return nimi;
		}



		public void setNimi(String nimi) {
			this.nimi = nimi;
		}



		public boolean isExpressa() {
			return expressa;
		}


		public void setExpressa(boolean expressa) {
			this.expressa = expressa;
		}


		public boolean isImmuniteetti() {
			return immuniteetti;
		}


		public void setImmuniteetti(boolean immuniteetti) {
			this.immuniteetti = immuniteetti;
		}


		public int getPressakaudet() {
			return pressakaudet;
		}


		public void setPressakaudet(int pressakaudet) {
			this.pressakaudet = pressakaudet;
		}


		public boolean isBlokattu() {
			return blokattu;
		}


		public void setBlokattu(boolean blokattu) {
			this.blokattu = blokattu;
		}


		public boolean isPudotettu() {
			return pudotettu;
		}


		public void setPudotettu(boolean pudotettu) {
			this.pudotettu = pudotettu;
		}


		public int getPoletit() {
			return poletit;
		}


		public void setPoletit(int poletit) {
			this.poletit = poletit;
		}


		public boolean isHallitus() {
			return hallitus;
		}


		public void setHallitus(boolean hallitus) {
			this.hallitus = hallitus;
		}


		public int getHallituksessa() {
			return hallituksessa;
		}


		public void setHallituksessa(int hallituksessa) {
			this.hallituksessa = hallituksessa;
		}


		public boolean isPresidentti() {
			return presidentti;
		}


		public void setPresidentti(boolean presidentti) {
			this.presidentti = presidentti;
		}


		public int getTippumiskierros() {
			return tippumiskierros;
		}


		public void setTippumiskierros(int tippumiskierros) {
			this.tippumiskierros = tippumiskierros;
		}


		public int getRyhma() {
			return ryhma;
		}


		public void setRyhma(int ryhma) {
			this.ryhma = ryhma;
		}


		public int getAliryhma() {
			return aliryhma;
		}


		public void setAliryhma(int aliryhma) {
			this.aliryhma = aliryhma;
		}



		public int getPelityhteensa() {
			return pelityhteensa;
		}





		public void setPelityhteensa(int pelityhteensa) {
			this.pelityhteensa = pelityhteensa;
		}





		@Override
		public String toString() {
			return "henkilo [osallistujalista=" + osallistujalista + ", pelaaja=" + Arrays.toString(pelaaja)
					+ ", kierrospeli=" + Arrays.toString(kierrospeli) + ", varit=" + Arrays.toString(varit) + ", nimi="
					+ nimi + ", expressa=" + expressa + ", immuniteetti=" + immuniteetti + ", pressakaudet="
					+ pressakaudet + ", blokattu=" + blokattu + ", pudotettu=" + pudotettu + ", poletit=" + poletit
					+ ", hallitus=" + hallitus + ", hallituksessa=" + hallituksessa + ", presidentti=" + presidentti
					+ ", tippumiskierros=" + tippumiskierros + ", ryhma=" + ryhma + ", aliryhma=" + aliryhma
					+ ", pelintulos=" + pelintulos + ", pelityhteensa=" + pelityhteensa + ", aanestys=" + aanestys
					+ ", kaikkipoletit=" + kaikkipoletit + ", kaikkitulokset=" + kaikkitulokset + "]";
		}

		






	
		
		
		
		
		
		
		


}
