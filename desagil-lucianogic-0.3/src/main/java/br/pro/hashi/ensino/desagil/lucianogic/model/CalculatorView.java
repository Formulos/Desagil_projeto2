package br.pro.hashi.ensino.desagil.lucianogic.model;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;



// Esta classe representa a interface de uma calculadora de densidade, com
// os dois campos de entrada (peso e raio) e o campo de saida (resultado).
public class CalculatorView extends JPanel implements MouseListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	// A componente JTextField representa um campo para digitacao de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	private	JCheckBox input0Field;
	private	JCheckBox input1Field;
	private	JCheckBox input2Field;
	private JCheckBox resultField;

	private Calculator calculator;


	public CalculatorView(Calculator calculator) {
		this.calculator = calculator;

		// A componente JLabel representa simplesmente um texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel inputLabel = new JLabel("Entrada:");

		JLabel resultLabel = new JLabel("Saida:");

		input0Field = new JCheckBox();
		input1Field = new JCheckBox();
		input2Field = new JCheckBox();
		resultField = new JCheckBox();

		// Esta linha garante que, sempre que o usuario digitar algo
		// em weightField, o metodo keyPressed abaixo sera chamado.
		// Voce usou a interface KeyListener no Projeto 1, lembra?
		input0Field.addMouseListener(this);
		input1Field.addMouseListener(this);
		input2Field.addMouseListener(this);


		// Esta linha garante que resultField nao seja digitavel.
		resultField.setEnabled(false);
		
		if (this.calculator.inputsize < 3){
			input2Field.setVisible(false);
			if (this.calculator.inputsize < 2){
				input1Field.setVisible(false);
			}
		}
			

		// Esta linha garante que os componentes sejam simplesmente
		// colocados em linha reta, mais especificamente na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/* A PARTIR DESTE PONTO VOCE DEVE ENTENDER SOZINHO */

		add(inputLabel);
		add(input0Field);
		add(input1Field);
		add(input2Field);
	
	
		add(resultLabel);
		add(resultField);
		
		MouseEvent event= null;
		this.mouseClicked(event);
		//para começar funcionando ja
	}


	@Override
	public void mouseClicked(MouseEvent event) {
		boolean input0, input1, input2;

		input0 = input0Field.isSelected();
		input1 = input1Field.isSelected();
		input2 = input2Field.isSelected();
		
		boolean result = calculator.read(input0, input1, input2);
		
		resultField.setSelected(result);
		
	}
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	@Override
	public void mousePressed(MouseEvent event) {
	}
	@Override
	public void mouseExited(MouseEvent event) {
	}
	@Override
	public void mouseEntered(MouseEvent event) {
	}
}
