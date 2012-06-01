package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author Palmer
 *
 */
public class GUIFrame extends JFrame{
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
	 * Construct a new GUIFrame object
	 */
	public GUIFrame(){		
		createMenu();

		
		
	}

	/**
	 * Creates a basic menu bar that allows the user to exit the program
	 */
	private void createMenu() {
		// TODO Auto-generated method stub
		theMenuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK ));
		exitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(EXIT_ON_CLOSE);
			}
			
		});
		fileMenu.add(exitItem);
		theMenuBar.add(fileMenu);
		this.setJMenuBar(theMenuBar);
	}

	/**
	 * Creates a new menu on the menu bar
	 * @param string
	 */
	public void addMenu(String string) {
		// TODO Auto-generated method stub
		
		//create a new menu object
		JMenu newMenu = new JMenu(string);
		this.getJMenuBar().add(newMenu);
	}
	
}
