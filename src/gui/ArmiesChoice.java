package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import mod.Config;
import cont.ArmiesChoiceController;
import cont.GUIController;

public class ArmiesChoice {
	
	JFrame frmNeuroshima;
	private ArmiesChoiceController controller;
	
	public JFrame getFrame(){
		return frmNeuroshima;
	}
	
	public ArmiesChoice(GUIController gui){
		frmNeuroshima = new JFrame();
		frmNeuroshima.setTitle("Neuroshima");
		frmNeuroshima.setResizable(false);
		frmNeuroshima.setBounds(100, 100, 200, 213);
		frmNeuroshima.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmNeuroshima.getContentPane().setLayout(null);

		controller = new ArmiesChoiceController(this,gui);
		
		JLabel lblPleaseChoose = new JLabel("Please choose 2 armies");
		lblPleaseChoose.setBounds(12, 10, 180, 15);
		
		final JList<String> list = new JList<String>(Config.getArmies());
		list.setBounds(12, 34, 148, 89);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startNewGame(list.getSelectedValuesList());
			}
		});
		okButton.setBounds(41, 147, 117, 25);
		
		frmNeuroshima.getContentPane().add(lblPleaseChoose);
		frmNeuroshima.getContentPane().add(okButton);
		frmNeuroshima.getContentPane().add(list);
	}
	public ArmiesChoiceController getController(){
		return controller;
	}
}
