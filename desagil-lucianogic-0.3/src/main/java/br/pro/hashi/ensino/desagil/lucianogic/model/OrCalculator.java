package br.pro.hashi.ensino.desagil.lucianogic.model;
public class OrCalculator extends Calculator{
	private Switch swt0= new Switch();
	private Switch swt1= new Switch();
	private OrGate gate= new OrGate();
	
	public OrCalculator() {
		name = "OR";
		inputsize= 2;
		
		this.gate.doConnect(swt0, 0);
		this.gate.doConnect(swt1, 1);
	}

	@Override
	public boolean read(boolean alpha, boolean beta, boolean gamma) {
		this.swt0.setOn(alpha);
		this.swt1.setOn(beta);
		
		return this.gate.read();
	}
}