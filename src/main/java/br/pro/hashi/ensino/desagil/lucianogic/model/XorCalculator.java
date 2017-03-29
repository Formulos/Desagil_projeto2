package br.pro.hashi.ensino.desagil.lucianogic.model;
public class XorCalculator extends Calculator{
	private Switch swt0= new Switch();
	private Switch swt1= new Switch();
	private XorGate gate= new XorGate();
	
	public XorCalculator() {
		name = "XOR";
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