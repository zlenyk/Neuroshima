package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import cont.GUIController;
import cont.StartMenuController;

public class StartMenu {

	private JFrame frmNeuroshima;
	private StartMenuController controller;
	
	public JFrame getFrame(){
		return frmNeuroshima;
	}
	
	public StartMenuController getController(){
		return controller;
	}

	/**
	 * Create the application.
	 */
	public StartMenu(GUIController gui) {
		frmNeuroshima = new JFrame();
		frmNeuroshima.setTitle("Neuroshima");
		frmNeuroshima.setResizable(false);
		frmNeuroshima.setBounds(100, 100, 237, 281);
		frmNeuroshima.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNeuroshima.getContentPane().setLayout(null);

		JButton somethingElseButton = new JButton("Something Else");
		JButton networkGameButton = new JButton("Network Game");
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton newGameButton = new JButton("New Game");
		
		newGameButton.setBounds(56, 30, 117, 25);
		somethingElseButton.setBounds(56, 80, 117, 25);
		networkGameButton.setBounds(56, 130, 117, 25);
		btnNewButton.setBounds(56, 180, 117, 25);

		networkGameButton.setEnabled(false);
				
		newGameButton.addActionListener(newGameAction());

		
		
		frmNeuroshima.getContentPane().add(btnNewButton);
		frmNeuroshima.getContentPane().add(newGameButton);
		frmNeuroshima.getContentPane().add(somethingElseButton);
		frmNeuroshima.getContentPane().add(networkGameButton);

		controller = new StartMenuController(this,gui);

	}
	
	private ActionListener newGameAction(){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.chooseArmies();
			}
		};
	}
	
}
