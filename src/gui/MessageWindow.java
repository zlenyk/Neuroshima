package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cont.GUIController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageWindow {
	GUIController guiController;
	private JFrame frmMessage;
	private JLabel messageLabel;
	public MessageWindow(GUIController gui){
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
				hide();
			}
		});
		okButton.setBounds(105, 39, 90, 25);
		frmMessage.getContentPane().add(okButton);
	}
	public void setText(String text){
		messageLabel.setText(text);
	}
	public void showMessage(String s){
		messageLabel.setText(s);
		frmMessage.setVisible(true);
	}
	public void show(){
		frmMessage.setVisible(true);
	}
	public void hide(){
		frmMessage.setVisible(false);
	}
}
