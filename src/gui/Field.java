package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
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
	public void setShape(int[] pointsX,int[] pointsY){
		polygon = new Polygon(pointsX,pointsY,pointsX.length);
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
	public boolean contains(int x,int y){
		if(polygon == null){
			System.out.println("DUPA");
			return false;
		}
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
