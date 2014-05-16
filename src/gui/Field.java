package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Field extends JPanel{

	public Polygon polygon;
	Image image;
	Image selectedImage;
	boolean selected;
	public Field(Image img,Image selectImg) {
		super();
		setSize(124,108);
		image = img;
		selectedImage = selectImg;
		selected = false;
	}
	public Field(Image img){
		super();
		setSize(126,110);
		image = img;
	}
	public Image getImage(){
		return image;
	}
	public Image getSelectedImage(){
		return selectedImage;
	}
	@Override
	public void paintComponent(Graphics g){
		if(selected){
			g.drawImage(selectedImage,-14,-14,null);
		}
		else{
			g.drawImage(image,-14,-14,null);
		}
	}
	public void changeSelect(){
		selected = !selected;
		repaint();
	}
}
