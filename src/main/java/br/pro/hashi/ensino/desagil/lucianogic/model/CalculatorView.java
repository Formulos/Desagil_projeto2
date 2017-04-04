package br.pro.hashi.ensino.desagil.lucianogic.model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JColorChooser;



// Esta classe representa a interface de uma calculadora de densidade, com
// os dois campos de entrada (peso e raio) e o campo de saida (resultado).
public class CalculatorView extends JPanel implements ActionListener {

	// Necessario para serializar objetos desta classe.
	private static final long serialVersionUID = 1L;


	// A componente JTextField representa um campo para digitacao de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	private	JCheckBox input0Field;
	private	JCheckBox input1Field;
	private	JCheckBox input2Field;
	//private JCheckBox resultField;
	private JButton resultField;
	private JLabel inputLabel;
	private JLabel resultLabel;
	
	private JLabel imagecontainer;

	private Calculator calculator;
	private Color color;


	public CalculatorView(Calculator calculator) {
		
		int width= 250;
		int height= 140;
		
		setLayout(null);
		setPreferredSize(new Dimension(width, height));
		
		this.calculator = calculator;

		// A componente JLabel representa simplesmente um texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		inputLabel = new JLabel("Entrada:");

		resultLabel = new JLabel("Saída:");

		input0Field = new JCheckBox();
		input1Field = new JCheckBox();
		input2Field = new JCheckBox();
		resultField = new JButton();
		color= new Color(255, 0, 0);
		imagecontainer= new JLabel();
		
		imagecontainer.setIcon(calculator.loadIcon());

		// Esta linha garante que, sempre que o usuario digitar algo
		// em weightField, o metodo keyPressed abaixo sera chamado.
		// Voce usou a interface KeyListener no Projeto 1, lembra?
		input0Field.addActionListener(this);
		input1Field.addActionListener(this);
		input2Field.addActionListener(this);
		resultField.addActionListener(this);
		
		if (this.calculator.inputsize < 3){
			input2Field.setVisible(false);
			if (this.calculator.inputsize < 2){
				input1Field.setVisible(false);
			}
		}

		add(inputLabel);
		inputLabel.setBounds(0, 0, 70, 20);
		add(input0Field);
		input0Field.setBounds(20, 45, 20, 20);
		add(input1Field);
		input1Field.setBounds(20, 75, 20, 20);
		add(input2Field);
		input2Field.setBounds(100, 105, 20, 20);
	
	
		add(resultLabel);
		resultLabel.setBounds(160, 0, 70, 20);
		add(resultField);
		resultField.setBounds(180, 60, 40, 20);
		
		add(imagecontainer);
		imagecontainer.setBounds(30, 40, 200, 60);
		
		ActionEvent event= null;
		this.actionPerformed(event);
		//para começar funcionando ja
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event==null || event.getSource()!=resultField){
			boolean input0, input1, input2;
	
			input0 = input0Field.isSelected();
			input1 = input1Field.isSelected();
			input2 = input2Field.isSelected();
			
			boolean result = calculator.read(input0, input1, input2);
			
			if (result){
				calculator.recolor(color.getRed(), color.getGreen(), color.getBlue());
				resultField.setBackground(color);
			}else{
				resultField.setBackground(new Color(255, 255, 255));
			}
		}else{
			this.color = JColorChooser.showDialog(this, null, null);
			
			boolean input0, input1, input2;
			input0 = input0Field.isSelected();
			input1 = input1Field.isSelected();
			input2 = input2Field.isSelected();
			
			boolean result = calculator.read(input0, input1, input2);
			
			if (result){
				calculator.recolor(color.getRed(), color.getGreen(), color.getBlue());
				resultField.setBackground(color);
			}else{
				resultField.setBackground(new Color(255, 255, 255));
			}
			
		}
	}
}