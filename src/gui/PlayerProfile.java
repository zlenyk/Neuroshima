package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import mod.Config;
import cont.GUIController;
import cont.MessageBuilder;

public class ArmiesChoice implements Window{

	private JFrame frame;
	private PlayerProfile playerProfile;
	public ArmiesChoice(final GUIController gui,String p,final PlayerProfile pp){
		
		frame = new JFrame();
		frame.setTitle("Neuroshima");
		frame.setResizable(false);
		frame.setBounds(100, 100, 191, 179);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		playerProfile = pp;
		
		JLabel label = new JLabel("Choose army for " + p);
		label.setBounds(12, 12, 161, 15);
		frame.getContentPane().add(label);
		
		final JList<String> list = new JList<String>(Config.getUnchosenArmies());
		list.setBounds(12, 31, 161, 73);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValuesList().size() < 1){
					gui.showMessage(MessageBuilder.mustChooseOneArmy());
					return;
				}
				String army = list.getSelectedValuesList().get(0);
				Config.chooseArmy(army);
				hide();
				pp.setArmy(army);
			}
		});
		btnNewButton.setBounds(34, 116, 117, 25);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void show(){
		frame.setVisible(true);
	}
	public void hide(){
		frame.setVisible(false);
		playerProfile.getFrame().setVisible(true);
	}
	@Override
	public JFrame getFrame() {
		return frame;
	}
}
