package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Field extends JPanel{

	Polygon polygon;
	Image image;
	Image selectedImage;
	boolean selected;
	public Field(Image img,Image selectImg,int[] pointsX,int[] pointsY) {
		super();
		setSize(124,108);
		polygon = new Polygon(pointsX,pointsY,pointsX.length);
		image = img;
		selectedImage = selectImg;
		selected = false;
	}
	public Field(Image img){
		super();
		setSize(126,110);
		image = img;
	}
	
	@Override
	public boolean contains(int x,int y){
		return polygon.contains(new Point(x,y));
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
