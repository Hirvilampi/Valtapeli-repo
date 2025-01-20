package vPeli1;

public class aanestyshenkilo {
	private int numero;
	private int aania;
	
	public void aanestyshenkilo(int numero, int aania) {
		this.numero=numero;
		this.aania=aania;
	}
	
	public  aanestyshenkilo() {
		this.numero=0;
		this.aania=0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAania() {
		return aania;
	}

	public void setAania(int aania) {
		this.aania = aania;
	}

	@Override
	public String toString() {
		return "aanestyshenkilo [numero=" + numero + ", aania=" + aania + "]";
	}
	
	
}
