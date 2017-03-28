package br.pro.hashi.ensino.desagil.lucianogic.model;
public class NotCalculator extends Calculator{
	private Switch swt0= new Switch();
	private NotGate gate= new NotGate();
	
	public NotCalculator() {
		name = "NOT";
		inputsize= 1;
		
		this.gate.doConnect(swt0, 0);
	}

	@Override
	public boolean read(boolean alpha, boolean beta, boolean gamma) {
		this.swt0.setOn(alpha);
		
		return this.gate.read();
	}
}