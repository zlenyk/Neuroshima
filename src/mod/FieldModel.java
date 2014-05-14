package mod;


public class FieldModel {
	public FieldModel neibours[];
	public Tile tile;
	public int position;
	public Tile getTile(){
		return tile;
	}
	FieldModel(){}
	FieldModel(Tile t,int pos){
		neibours = new FieldModel[6];
		tile = t;
		position = pos;
	}
	
}
