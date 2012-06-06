/**
 * 
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gui.GUIFrame;

/**
 * @author Palmer
 *
 */
public class FunctionFrame extends GUIFrame {

	private JMenuBar theMenuBar;
	private JMenu fileMenu;
	
	private JButton submitFunction;
	private JPanel inputPanel;
	private JPanel displayPanel;
	private JTextField userFunction;
	private JLabel functionLabel;
	private JTextArea resultArea;
	private Container container;
	
	private double[][] results;
	private int xMin, xMax;
	
	/**
	 * Constructor - constructs a new FunctionFrame object
	 */
	public FunctionFrame() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());
		
		container = new Container();
		container = this.getContentPane();
		
		//create the input panel
		inputPanel = new JPanel();
		submitFunction = new JButton("Enter");
		submitFunction.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String function = userFunction.getText();
				if(validateFunction(function)){
					results = computeAnswer(function, xMin, xMax);
					printResults(results);
				}
				else
					resultArea.setText("The function entered was not valid. Please try again");
			}
			
		});
		userFunction = new JTextField(20);
		userFunction.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
					String function = userFunction.getText();
					if(validateFunction(function)){
						results = computeAnswer(function, xMin, xMax);
						printResults(results);
					}
					else
						resultArea.setText("The function entered was not valid. Please try again");
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
			
		});

		functionLabel = new JLabel("Enter Function: ");
		inputPanel.add(functionLabel);
		inputPanel.add(userFunction);
		inputPanel.add(submitFunction);
		
		//create the display panel
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.blue);
		resultArea = new JTextArea(40, 50);
		resultArea.setEditable(false);
		displayPanel.add(resultArea);
		
		//add the panels to the frame
		container.add(inputPanel, BorderLayout.NORTH);
		container.add(displayPanel, BorderLayout.CENTER);
		
		
	}
	
	private boolean validateFunction(String userFunction) {
		// TODO Auto-generated method stub
		String[] expression;
		expression = userFunction.split("\\s");
		
		if(isOperation(expression[expression.length - 1]))
			return false;
		
		for(int i = 0; i < expression.length; i++){
			if(!isVariable(expression[i]) && !isNumeral(expression[i])){
				if(!isOperation(expression[i]))
					return false;
			}
		}
		return true;
	}

	private boolean isOperation(String string) {
		// TODO Auto-generated method stub
		if(string.matches("[\\+\\-\\*\\/]"))
			return true;
		return false;
	}

	private boolean isNumeral(String string) {
		// TODO Auto-generated method stub
		if(string.matches("\\d+"))
			return true;
		return false;
	}

	private boolean isVariable(String string) {
		// TODO Auto-generated method stub
		if(string.matches("\\d*x(\\^{1}(\\d+))?"))
			return true;
		return false;
	}
	
	private void printResults(double[][] results) {
		// TODO Auto-generated method stub
		String resultText = "";
		
		resultText = "\nX Values |      Y Values";
		resultText = resultText.concat("\n");
		resultText = resultText.concat("---------------------------");
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 2; j++){
				if(j % 2 != 1)
					resultText = resultText.concat("\n" + results[i][j] + "     ");
				else
					resultText = resultText.concat("| " + results[i][j]);
			}
		}
		resultArea.setText(resultText);
	}
	
	private double[][] computeAnswer(String userFunction, int minXValue, int maxXValue) {
		// TODO Auto-generated method stub
		double [][] answers = new double[11][2];
		String equation = userFunction;
		for(int i = 0; i < 11; i++){
			answers[i][0] = i + minXValue;
			answers[i][1] = evaulateFunction(equation, i);
		}
		return answers;
	}

private double evaulateFunction(String equation, double d) {
		
		String[] components;
		String varibles;
		String currentOperation = "";
		int value = 0;
		double result = 0;
		
		components = equation.split("\\s");
		for(int i = 0; i < components.length; i++){
			if(isVariable(components[i])){
				if(currentOperation.isEmpty())
					result += computeVariable(d, components[i]);
				else{
					double variValue = computeVariable(d, components[i]);
					result = computeOperation(result, variValue, currentOperation);
					currentOperation = "";
				}
			}
			else if(isOperation(components[i])){
				currentOperation = components[i];
			}
			else if(isNumeral(components[i])){
				value = Integer.parseInt(components[i]);
				if(currentOperation.isEmpty())
					result += value;
				else
					result = computeOperation(result, value, currentOperation);
			}
		}
		return result;
	}

private double computeVariable(double d, String string) {
	// TODO Auto-generated method stub
	double value = 0;
	int quantifier = 1;
	int exponent = 1;
	String [] variables = string.split("[x\\^]");
	if(variables.length == 0)
		value = d;
	else if(!variables[0].isEmpty()){
		quantifier = Integer.parseInt(variables[0]);
		value = quantifier * d;
	}
	
	else if(variables.length == 1){
		value = quantifier * d; 
	}
	else{
		exponent = Integer.parseInt(variables[2]);
		d = Math.pow(d, exponent);
		
		value = quantifier * d;
	}
	return value;
}

private double computeOperation(double result, double variValue, String currentOperation) {
	// TODO Auto-generated method stub
	double answer = 0;
	char operation = currentOperation.charAt(0);
	switch(operation){
	case '+':
		answer = result + variValue;
		break;
	case '-':
		answer = result - variValue;
		break;
	case '*':
		answer = result * variValue;
		break;
	case '/':
		answer = result / variValue;
		break;
	
	}
	return answer;
}
}
