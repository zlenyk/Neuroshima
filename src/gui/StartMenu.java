package gui;

import java.awt.EventQueue;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu window = new StartMenu();
					window.frmNeuroshima.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmNeuroshima.setBounds(100, 100, 233, 300);
		frmNeuroshima.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNeuroshima.getContentPane().setLayout(null);

		JButton somethingElseButton = new JButton("Something Else");
		JButton networkGameButton = new JButton("Network Game");
		JButton btnNewButton = new JButton("Close");
		JButton newGameButton = new JButton("New Game");
		
		newGameButton.setBounds(56, 30, 117, 25);
		somethingElseButton.setBounds(56, 80, 117, 25);
		networkGameButton.setBounds(56, 129, 117, 25);
		btnNewButton.setBounds(56, 175, 117, 25);

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
		list.setBounds(185, 34, 34, 78);
		
		return list;
	}
}
