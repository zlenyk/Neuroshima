package gui;

import java.awt.Graphics;
import java.awt.Image;


public class Field extends Hexagon{

	Image image;
	int height;
	int width;
	public Field(int side,Image img) {
		super(side);
		image = img;
		height = img.getHeight(null);
		width = img.getWidth(null);
	}
	public void paobserverintComponent(Graphics g){
		g.drawImage(image,50,50,height,width,null);
	}
}
