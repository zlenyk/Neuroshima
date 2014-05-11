package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Field extends JPanel{

	//Image image;
	Polygon polygon;
	Image image;
	public Field(Image img,int[] pointsX,int[] pointsY) {
		super();
		setSize(124,108);
		polygon = new Polygon(pointsX,pointsY,pointsX.length);
		image = img;
	}
	public Field(Image img){
		super();
		setSize(126,110);
		image = img;
	}
	
	/*@Override
	public boolean contains(int x,int y){
		return polygon.contains(new Point(x,y));
	}*/
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image,-14,-14,null);
	}
}
