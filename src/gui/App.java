package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class App {

	private JFrame frmNeuroshima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
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
		
		JButton newGameButton = new JButton("New Game");
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
