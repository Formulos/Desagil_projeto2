package br.pro.hashi.ensino.desagil.lucianogic.model;

public class XorGate extends Gate {
	private NandGate nandGate;
	private OrGate orGate;
	private AndGate andGate;
	
	
	
	public XorGate() {
		super(2);
		nandGate = new NandGate();
		orGate = new OrGate();
		andGate = new AndGate();
	}

	@Override
	public boolean read() {
		return andGate.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		nandGate.connect(emitter, index);
		orGate.connect(emitter, index);
		andGate.connect(nandGate, 0);
		andGate.connect(orGate, 1);
	}
}

