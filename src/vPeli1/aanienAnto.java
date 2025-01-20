package vPeli1;

import java.util.ArrayList;

public class aanienAnto {
	private boolean blokattu;
	private boolean pudotettu;
	private ArrayList<aanestyshenkilo> henkilojaaanet = new ArrayList<aanestyshenkilo>();
	
	public aanienAnto(boolean blok, boolean pud, ArrayList<aanestyshenkilo> henkilojaaanet) {
		this.blokattu = blok;
		this.pudotettu = pud;
		this.henkilojaaanet = henkilojaaanet;
	}








	public aanienAnto() {
		super();
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

	public ArrayList<aanestyshenkilo> getHenkilojaaanet() {
		return henkilojaaanet;
	}

	public void setHenkilojaaanet(ArrayList<aanestyshenkilo> henkilojaaanet) {
		this.henkilojaaanet = henkilojaaanet;
	}

	@Override
	public String toString() {
		return "aanienAnto [blokattu=" + blokattu + ", pudotettu=" + pudotettu + ", henkilojaaanet=" + henkilojaaanet
				+ "]";
	}


	
	
	
	
	

}
