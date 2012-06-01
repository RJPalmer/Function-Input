/**
 * 
 */
package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import gui.*;
/**
 * @author Palmer
 *
 */
public class FunctionInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a new frame object
		FunctionFrame frame= new FunctionFrame();	
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setTitle("Function Input");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add a help menu
		frame.addMenu("Help");
		frame.setVisible(true);

	}

	

}
