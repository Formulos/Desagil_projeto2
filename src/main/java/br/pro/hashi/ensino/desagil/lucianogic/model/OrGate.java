package br.pro.hashi.ensino.desagil.lucianogic.model;

public class OrGate extends Gate {
	private NandGate nandGate;
	private NotGate notGate_0;
	private NotGate notGate_1;

	public OrGate() {
		super(2);
		nandGate = new NandGate();
		notGate_0 = new NotGate();
		notGate_1 = new NotGate();
	}

	@Override
	public boolean read() {
		return nandGate.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		if (index==0){
			notGate_0.connect(emitter, 0);
		}else{
			notGate_1.connect(emitter, 0);
		}
		nandGate.connect(notGate_0, 0);
		nandGate.connect(notGate_1, 1);
	}
}
