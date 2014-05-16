package mod;


public class FieldModel {
	public FieldModel neibours[];
	public Tile tile;
	public int position;
	
	FieldModel(){}
	FieldModel(int pos){
		neibours = new FieldModel[6];
		position = pos;
	}
	public void changeTile(Tile t){
		tile = t;
	}
	public int getPosition(){
		return position;
	}
	public Tile getTile(){
		return tile;
	}
	
}
