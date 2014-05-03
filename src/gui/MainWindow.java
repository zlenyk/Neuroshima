package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cont.MainWindowController;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JFrame parent;
	private MainWindowController controller;
	
	public void initMainWindow(){
		final MainWindow mainWindow = this;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow.showWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch and returns controller to new MainWindow.
	 */
	public static MainWindowController getInstance(final JFrame _parent,List<String> armies){
		return new MainWindow(_parent,armies).controller;
	}
	
	public void showWindow(){
		this.setVisible(true);
		parent.setVisible(false);
	}
	public void hideWindow(){
		this.setVisible(false);
		parent.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	private MainWindow(JFrame _parent,List<String> armies) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.closeGame();
			}
		});
		btnClose.setBounds(319, 12, 117, 25);
		contentPane.add(btnClose);
		
		Board board = new Board(200,armies);
		board.setBounds(12, 0, 262, 259);
		contentPane.add(board);
		
		parent = _parent;
		controller = new MainWindowController(this);
	}
}
