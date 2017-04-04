package br.pro.hashi.ensino.desagil.lucianogic.model;

import java.net.URL;
import javax.swing.ImageIcon;

public class NandCalculator extends Calculator{
	private Switch swt0= new Switch();
	private Switch swt1= new Switch();
	
	public NandCalculator() {
		name = "NAND";
		inputsize= 2;
		gate= new NandGate();
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