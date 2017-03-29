package br.pro.hashi.ensino.desagil.lucianogic.model;

public class MuxGate extends Gate {
	private NotGate notGate;
	private OrGate orGate;
	private AndGate andGate_0;
	private AndGate andGate_1;
	
	
	
	public MuxGate() {
		super(3);
		notGate = new NotGate();
		andGate_0 = new AndGate();
		andGate_1 = new AndGate();
		orGate = new OrGate();
	}

	@Override
	public boolean read() {
		return orGate.read();
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		//supondo ABS
		
		if (index==2)
			notGate.connect(emitter, 0);
		
		if (index == 0){
			andGate_0.connect(emitter, 0);
			andGate_0.connect(notGate, 1);
		}else{
			andGate_1.connect(emitter, index-1);
		}
		orGate.connect(andGate_0, 0);
		orGate.connect(andGate_1, 1);
	}
}