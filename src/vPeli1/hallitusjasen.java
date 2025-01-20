package vPeli1;

public class hallitusjasen {
	private int pelaajanumero;
	private String nimi;
	 int aanestys;
	
	
	
	public hallitusjasen() {
		pelaajanumero=0;
		nimi="";
		aanestys=0;
	}




	public int getAanestys() {
		return aanestys;
	}




	public void setAanestys(int aanestys) {
		this.aanestys = aanestys;
	}




	public hallitusjasen(int pelaajanumero, String nimi, int aanestys) {
		super();
		this.pelaajanumero = pelaajanumero;
		this.nimi = nimi;
		this.aanestys = aanestys;
	}



	public int getPelaajanumero() {
		return pelaajanumero;
	}



	public void setPelaajanumero(int pelaajanumero) {
		this.pelaajanumero = pelaajanumero;
	}



	public String getNimi() {
		return nimi;
	}



	public void setNimi(String nimi) {
		this.nimi = nimi;
	}



	@Override
	public String toString() {
		return "hallitusjasen [pelaajanumero=" + pelaajanumero + ", nimi=" + nimi + ", aanestys=" + aanestys + "]";
	}
	
	
	

}
