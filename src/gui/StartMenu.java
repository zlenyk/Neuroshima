package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import mod.Config;
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
	public StartMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNeuroshima = new JFrame();
		frmNeuroshima.setTitle("Neuroshima");
		frmNeuroshima.setResizable(false);
		frmNeuroshima.setBounds(100, 100, 275, 300);
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
		
		JList<String> armiesList = createList();
		
		newGameButton.addActionListener(newGameAction(armiesList));

		
		frmNeuroshima.getContentPane().add(armiesList);
		
		frmNeuroshima.getContentPane().add(btnNewButton);
		frmNeuroshima.getContentPane().add(newGameButton);
		frmNeuroshima.getContentPane().add(somethingElseButton);
		frmNeuroshima.getContentPane().add(networkGameButton);

		controller = new StartMenuController(this);

	}
	
	private ActionListener newGameAction(final JList<String> armiesList){
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startNewGame(armiesList.getSelectedValuesList());
			}
		};
	}
	
	private JList<String> createList(){

		JList<String> list = new JList<String>(Config.getArmies());
		list.setBounds(185, 34, 74, 78);
		
		return list;
	}
}
