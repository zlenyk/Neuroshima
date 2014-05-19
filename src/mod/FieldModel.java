package mod;

import java.awt.Point;
import java.awt.Polygon;


public class FieldModel {
	public FieldModel neighbours[];
	public Tile tile;
	public int position;
	private Polygon polygon;
	private Point location;

	FieldModel(){}
	
	FieldModel(int pos){
		neighbours = new FieldModel[6];
		position = pos;
	}
	public void setShape(int[] pointsX,int[] pointsY){
		polygon = new Polygon(pointsX,pointsY,pointsX.length);
	}
	public void setLocation(int x,int y){
		location = new Point(x,y);
	}
	public Point getLocation(){
		return location;
	}
	public void changeTile(Tile t){
		tile = t;
	}
	public void selectTile(){
		tile.getField().changeSelect();
	}
	public int getPosition(){
		return position;
	}
	public Tile getTile(){
		return tile;
	}
	
	public boolean contains(Point p){
		return polygon.contains(p);
	}
}
