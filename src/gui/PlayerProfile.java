package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mod.Config;
import cont.ArmiesChoiceController;
import cont.GUIController;

public class PlayerProfile implements Window{
	
	private JFrame frame;
	private PlayerProfile thisObject;
	private ArmiesChoiceController controller;
	private JTextField player1Name;
	private JTextField player2Name;
	private List<String> armiesList;
	private GUIController guiController;
	
	public PlayerProfile(GUIController gui){
		controller = new ArmiesChoiceController(this,gui);
		guiController = gui;
		thisObject = this;
		
		frame = new JFrame();
		frame.setTitle("Neuroshima");
		frame.setResizable(false);
		frame.setBounds(100, 100, 180, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		armiesList = new ArrayList<String>();
				
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ArmiesChoice ac = new ArmiesChoice(guiController,player1Name.getText(),thisObject);
				getFrame().setVisible(false);
				ac.show();
			}
		});
		okButton.setBounds(20, 120, 117, 25);
		
		frame.getContentPane().add(okButton);
		
		JLabel lblNewLabel = new JLabel("Player 1");
		lblNewLabel.setBounds(12, 10, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		player1Name = new JTextField();
		player1Name.setBounds(12,30, 114, 19);
		frame.getContentPane().add(player1Name);
		player1Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Player 2");
		lblNewLabel_1.setBounds(12, 60, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		player2Name = new JTextField();
		player2Name.setBounds(12, 80, 114, 19);
		frame.getContentPane().add(player2Name);
		player2Name.setColumns(10);
		
	}
	public void setArmy(String army){
		armiesList.add(army);
		if(armiesList.size() == Config.getPLAYERS()){
			List<String> playersNames = new ArrayList<String>();
			playersNames.add(player1Name.getText());
			playersNames.add(player2Name.getText());

			Config.fillArmies();
			controller.startNewGame(armiesList,playersNames);
		}
		else{
			ArmiesChoice ac = new ArmiesChoice(guiController,player2Name.getText(),thisObject);
			getFrame().setVisible(false);
			ac.show();
		}
	}
	public ArmiesChoiceController getController(){
		return controller;
	}
	
	@Override
	public JFrame getFrame() {
		return frame;
	}
}
