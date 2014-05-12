package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cont.GUIController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Message {
	GUIController guiController;
	private JFrame frmMessage;
	private JLabel messageLabel;
	public Message(GUIController gui){
		guiController = gui;
		frmMessage = new JFrame();
		frmMessage.setTitle("Message");
		frmMessage.setBounds(100, 100, 316, 100);
		frmMessage.getContentPane().setLayout(null);
		
		messageLabel = new JLabel("");
		messageLabel.setBounds(12, 12, 290, 15);
		frmMessage.getContentPane().add(messageLabel);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiController.closeMessage();
			}
		});
		okButton.setBounds(105, 39, 90, 25);
		frmMessage.getContentPane().add(okButton);
	}
	public void setText(String text){
		messageLabel.setText(text);
	}
	public void show(){
		System.out.println("DUPA");
		frmMessage.setVisible(true);
	}
	public void hide(){
		frmMessage.setVisible(false);
	}
}
