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
	private JButton btnRotateTile;
	private JButton btnDiscard;
	private JButton btnAccept;
	private JButton nextTurnButton;
	private JButton btnClose;
	
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
		
		initializeContentPane();
		initializeFrame();
		initializeSeparator();
		initializeButtons();
	}
	
	/**
	 * @param b
	 * Adds prepared board to MainWindow.
	 */
	public void addBoard(Board b){	
		b.setBounds(12, 12, 496, 550);
		contentPane.add(b);
	}
	
	/**
	 * @param playersList
	 * Creates PlayerInfo list and fills its information.
	 */
	public void fillPlayersList(List<Player>playersList){
		playerInfoList = new ArrayList<PlayerInfo>();
		int[] Y = {150,350};
		for(int i = 0; i < playersList.size(); i++){
			PlayerInfo pi = new PlayerInfo(playersList.get(i),getController());
			playerInfoList.add(pi);
			pi.setBounds(510, Y[i],360,150);
			contentPane.add(pi);
		}
	}
	/**
	 * @return list of PlayerInfo panels.
	 */
	public List<PlayerInfo> getPlayerInfoList(){
		return playerInfoList;
	}
	@Override
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Repaints mainWindow.
	 */
	public void repaint(){
		for(PlayerInfo pi : playerInfoList){
			pi.refreshPlayerInfo();
		}
		contentPane.repaint();
	}
	
	public void setPutTileEnabled(boolean b){
		btnPutTile.setEnabled(b);
	}
	public void setRotateFieldEnabled(boolean b){
		btnRotateTile.setEnabled(b);
	}
	public void setNextTurnEnabled(boolean b){
		nextTurnButton.setEnabled(b);
	}
	public void setAcceptEnabled(boolean b){
		btnAccept.setEnabled(b);
	}
	public void setDiscardEnabled(boolean b) {
		btnDiscard.setEnabled(b);
	}
	
	///////////////////private constructor functions///////////////
	
	private void initializeContentPane(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}
	
	private void initializeFrame(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 890, 600);
		frame.setContentPane(contentPane);
	}
	private void initializeSeparator(){
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(508, -11, 2, 582);
		contentPane.add(separator);
	}
	private void initializeButtons(){
		btnClose = new JButton		("Close");
		nextTurnButton = new JButton("Next Turn!");
		btnPutTile = new JButton	("Put Tile");
		btnRotateTile = new JButton	("Rotate");
		btnAccept = new JButton		("Accept");
		btnDiscard = new JButton	("Discard");
		
		btnClose.setBounds		(669, 24, 117, 25);
		nextTurnButton.setBounds(536, 24, 117, 25);
		btnPutTile.setBounds	(536, 61, 117, 25);
		btnRotateTile.setBounds	(669, 60, 117, 25);
		btnAccept.setBounds		(669, 96, 117, 25);
		btnDiscard.setBounds	(536, 98, 117, 25);

		btnPutTile.setEnabled(false);
		btnRotateTile.setEnabled(false);
		btnAccept.setEnabled(false);
		btnDiscard.setEnabled(false);
		
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.closeGame();
			}
		});		
		nextTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.nextTurn();
			}
		});
		btnPutTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.putTile();
			}
		});
		btnRotateTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.rotateField();
			}
		});
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.acceptTile();
			}
		});
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.discardTile();
			}
		});
		
		contentPane.add(btnClose);
		contentPane.add(nextTurnButton);
		contentPane.add(btnPutTile);
		contentPane.add(btnRotateTile);
		contentPane.add(btnAccept);
		contentPane.add(btnDiscard);
	}
}
