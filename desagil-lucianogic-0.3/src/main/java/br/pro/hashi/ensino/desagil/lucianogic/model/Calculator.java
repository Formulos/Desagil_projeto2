package br.pro.hashi.ensino.desagil.lucianogic.model;
public abstract class Calculator {
	protected String name;
	protected int inputsize;

	// O menu mostra a string devolvida por esse metodo.
	public String toString() {
		return name;
	}

	public abstract boolean read(boolean alpha, boolean beta, boolean gamma);
}
