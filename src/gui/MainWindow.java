package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cont.GUIController;
import cont.MainWindowController;

public class MainWindow implements Window{

	private JPanel contentPane;
	private JFrame frame;
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
	public MainWindow(GUIController gui,List<String> armies,List<String> playersNames) {
		
		controller = new MainWindowController(this,gui);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 715, 600);
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

		
		List<PlayerInfo> playerInfoList = new ArrayList<PlayerInfo>();
		int[] Y = {150,250};
		for(int i = 0; i < playersNames.size(); i++){
			PlayerInfo pi = new PlayerInfo(playersNames.get(i));
			playerInfoList.add(pi);
			pi.setBounds(510, Y[i],180,50);
			contentPane.add(pi);
		}
	}
	@Override
	public JFrame getFrame() {
		return frame;
	}
}
