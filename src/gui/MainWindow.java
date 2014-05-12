package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cont.GUIController;
import cont.MainWindowController;

public class MainWindow extends Window{

	private JPanel contentPane;
	private MainWindowController controller;	
	
	/**
	 * Returns controller to this MainWindow.
	 */
	public MainWindowController getController(){
		return controller;
	}
	/**
	 * Create the frame.
	 */
	public MainWindow(GUIController gui,List<String> armies) {
		super(gui);
		controller = new MainWindowController(this,gui);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 667, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.closeGame();
			}
		});

		btnClose.setBounds(536, 78, 117, 25);
		contentPane.add(btnClose);
		
		Board board = new Board(armies);
		board.setBounds(12, 12, 496, 550);
		contentPane.add(board);
		
		JButton startGameButton = new JButton("Start Game!");
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startGame();
			}
		});
		startGameButton.setBounds(536, 12, 117, 25);
		contentPane.add(startGameButton);
	}
}
