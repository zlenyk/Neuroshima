package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import mod.Config;
import cont.ArmiesChoiceController;
import cont.GUIController;

public class PlayerProfile implements Window{
	
	private JFrame frame;
	private ArmiesChoiceController controller;
	private JTextField player1Name;
	private JTextField player2Name;
	
	
	public PlayerProfile(GUIController gui){
		controller = new ArmiesChoiceController(this,gui);

		frame = new JFrame();
		frame.setTitle("Neuroshima");
		frame.setResizable(false);
		frame.setBounds(100, 100, 200, 287);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseChoose = new JLabel("Please choose 2 armies");
		lblPleaseChoose.setBounds(12, 10, 180, 15);
		
		final JList<String> list = new JList<String>(Config.getArmies());
		list.setBounds(12, 30, 148, 68);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> playersNames = new ArrayList<String>();
				playersNames.add(player1Name.getText());
				playersNames.add(player2Name.getText());

				controller.startNewGame(list.getSelectedValuesList(),playersNames);
			}
		});
		okButton.setBounds(43, 221, 117, 25);
		
		frame.getContentPane().add(lblPleaseChoose);
		frame.getContentPane().add(okButton);
		frame.getContentPane().add(list);
		
		player1Name = new JTextField();
		player1Name.setBounds(12, 128, 114, 19);
		frame.getContentPane().add(player1Name);
		player1Name.setColumns(10);
		
		player2Name = new JTextField();
		player2Name.setBounds(12, 179, 114, 19);
		frame.getContentPane().add(player2Name);
		player2Name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Player 1");
		lblNewLabel.setBounds(12, 112, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Player 2");
		lblNewLabel_1.setBounds(12, 163, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
	}
	public ArmiesChoiceController getController(){
		return controller;
	}
	
	@Override
	public JFrame getFrame() {
		return frame;
	}
}
