package br.pro.hashi.ensino.desagil.lucianogic.model;
public class MuxCalculator extends Calculator{
	private Switch swt0= new Switch();
	private Switch swt1= new Switch();
	private Switch swt2= new Switch();
	
	public MuxCalculator() {
		name = "MUX";
		inputsize= 3;
		gate= new MuxGate();
		
		this.gate.doConnect(swt0, 0);
		this.gate.doConnect(swt1, 1);
		this.gate.doConnect(swt2, 2);
	}

	@Override
	public boolean read(boolean alpha, boolean beta, boolean gamma) {
		this.swt0.setOn(alpha);
		this.swt1.setOn(beta);
		this.swt2.setOn(gamma);
		
		return this.led.isOn();
	}
}