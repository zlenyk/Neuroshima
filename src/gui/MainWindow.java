package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mod.Player;
import cont.GUIController;
import cont.MainWindowController;

public class MainWindow implements Window{

	private JPanel contentPane;
	private JFrame frame;
	private JButton btnPutTile;
	private MainWindowController controller;
	private List<PlayerInfo> playerInfoList;
	
	/**
	 * Returns controller to this MainWindow.
	 */
	public MainWindowController getController(){
		return controller;
	}
	/**
	 * Create the frame.
	 */
	public MainWindow(GUIController gui) {
		
		controller = new MainWindowController(this,gui);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 890, 600);
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

		btnClose.setBounds(669, 24, 117, 25);
		contentPane.add(btnClose);
		
		//Board board = new Board(armies);
		//board.setBounds(12, 12, 496, 550);
		//contentPane.add(board);
		
		JButton newxtTurnButton = new JButton("Next Turn!");
		newxtTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.nextTurn();
			}
		});
		newxtTurnButton.setBounds(536, 24, 117, 25);
		contentPane.add(newxtTurnButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(508, -11, 2, 582);
		contentPane.add(separator);
		
		btnPutTile = new JButton("Put Tile");
		btnPutTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.putTile();
			}
		});
		btnPutTile.setBounds(536, 61, 117, 25);
		btnPutTile.setEnabled(false);
		contentPane.add(btnPutTile);
		
	}
	public void addBoard(Board b){	
		b.setBounds(12, 12, 496, 550);
		contentPane.add(b);
	}
	public void enablePutTile(){
		btnPutTile.setEnabled(true);
	}
	public void disablePutTile(){
		btnPutTile.setEnabled(false);
	}
	public void fillPlayersList(List<Player>playersList){
		playerInfoList = new ArrayList<PlayerInfo>();
		int[] Y = {100,300};
		for(int i = 0; i < playersList.size(); i++){
			PlayerInfo pi = new PlayerInfo(playersList.get(i),getController());
			playerInfoList.add(pi);
			pi.setBounds(510, Y[i],360,150);
			contentPane.add(pi);
		}
	}
	public List<PlayerInfo> getPlayerInfoList(){
		return playerInfoList;
	}
	@Override
	public JFrame getFrame() {
		return frame;
	}
	
	public void repaint(){
		contentPane.repaint();
	}
}
