package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		
		controller = new StartMenuController(this);
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startNewGame();
			}
		});
		newGameButton.setBounds(56, 30, 117, 25);
		frmNeuroshima.getContentPane().add(newGameButton);
		
		JButton somethingElseButton = new JButton("Something Else");
		somethingElseButton.setBounds(56, 80, 117, 25);


		frmNeuroshima.getContentPane().add(somethingElseButton);
		
		JButton networkGameButton = new JButton("Network Game");
		networkGameButton.setEnabled(false);
		networkGameButton.setBounds(56, 129, 117, 25);
		frmNeuroshima.getContentPane().add(networkGameButton);
	}
}
