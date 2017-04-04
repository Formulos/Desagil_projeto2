package br.pro.hashi.ensino.desagil.lucianogic.model;

import java.net.URL;
import javax.swing.ImageIcon;

public class NotCalculator extends Calculator{
	private Switch swt0= new Switch();
	
	public NotCalculator() {
		name = "NOT";
		inputsize= 1;
		gate= new NotGate();
		this.led.connect(gate, 0);
		
		this.gate.doConnect(swt0, 0);
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
		
		return this.led.isOn();
	}
}