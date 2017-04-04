package br.pro.hashi.ensino.desagil.lucianogic.model;

import java.net.URL;
import javax.swing.ImageIcon;

public class XorCalculator extends Calculator{
	private Switch swt0= new Switch();
	private Switch swt1= new Switch();
	
	public XorCalculator() {
		name = "XOR";
		inputsize= 2;
		gate= new XorGate();
		this.led.connect(gate, 0);
		
		this.gate.doConnect(swt0, 0);
		this.gate.doConnect(swt1, 1);
	}
	
	@Override
	public ImageIcon loadIcon() {
		String filename= this.name;
		URL url = getClass().getResource("/img/" + filename + ".png");
		return new ImageIcon(url);
	}

	@Override
	public boolean read(boolean alpha, boolean beta, boolean gamma) {
		this.swt0.setOn(alpha);
		this.swt1.setOn(beta);
		
		return this.led.isOn();
	}
}