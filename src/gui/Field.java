package gui;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.JPanel;


public class Field extends JPanel{

	public Polygon polygon;
	Image image;
	Image selectedImage;
	boolean selected;
	int rotation = 0;
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
	public boolean isSelected(){
		return selected;
	}
	public void rotate(){
		rotation = (rotation + 1) % 6;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
	//	super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int drawLocationX = -14;
		int drawLocationY = -14;
		
		double rotationRequired = Math.toRadians(rotation*60);
		double locationX = image.getWidth(null) / 2;
		double locationY = image.getHeight(null) / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		if(selected){
			g2d.drawImage(op.filter((BufferedImage) selectedImage, null), drawLocationX, drawLocationY, null);
		}
		else{
			g2d.drawImage(op.filter((BufferedImage) image, null), drawLocationX, drawLocationY, null);
		}
	}
	public void changeSelect(){
		selected = !selected;
		repaint();
	}
}
