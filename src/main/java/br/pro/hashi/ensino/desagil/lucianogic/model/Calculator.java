package br.pro.hashi.ensino.desagil.lucianogic.model;
public abstract class Calculator {
	protected Gate gate;
	protected String name;
	protected int inputsize;
	protected LED led= new LED(255, 0, 0);

	// O menu mostra a string devolvida por esse metodo.
	public String toString() {
		return name;
	}
	
	public void recolor(int red, int green, int blue){
		this.led= new LED(red, green, blue);
		this.led.connect(gate, 0);
	}

	public abstract boolean read(boolean alpha, boolean beta, boolean gamma);
}
