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
				resultArea.setText(function);
			}
			
		});
		userFunction = new JTextField(20);
		userFunction.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
					String function = userFunction.getText();
					resultArea.setText(function);
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

}
