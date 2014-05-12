package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import cont.GUIController;
import cont.StartMenuController;

public class StartMenu extends Window{

	private StartMenuController controller;
	
	public StartMenuController getController(){
		return controller;
	}

	/**
	 * Create the application.
	 */
	public StartMenu(GUIController gui) {
		super(gui);
		frame.setTitle("Neuroshima");
		frame.setResizable(false);
		frame.setBounds(100, 100, 237, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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

		
		
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(newGameButton);
		frame.getContentPane().add(somethingElseButton);
		frame.getContentPane().add(networkGameButton);

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
