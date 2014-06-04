package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class Bomba extends mod.Tile {
	public Bomba(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage(),getNettedImage());
		this.owner = owner;
		this.board = board;
	}
	@Override
public LinkedList<Integer> pick(){
	LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
	whereCanPut.add(5);
	whereCanPut.add(7);
	whereCanPut.add(8);
	whereCanPut.add(10);
	whereCanPut.add(12);
	whereCanPut.add(13);
	whereCanPut.add(15);
	return whereCanPut;
}
@Override
public void put(int position, int rotation){
	if(!(board[position].getTile() instanceof Empty) && !board[position].getTile().isSztab()){
		board[position].getTile().takeDmg(1);
		if(board[position].getTile().getHp()<=0) board[position].getTile().die();
	}
	for(int i=0;i<6;i++){
		if(!(board[position].neighbours[i].getTile() instanceof Empty) 
				&& !board[position].neighbours[i].getTile().isSztab()){
			
			board[position].neighbours[i].getTile().takeDmg(1);
			
			if(board[position].neighbours[i].getTile().getHp()<=0){
				board[position].neighbours[i].getTile().die();
			}
		}
	}
}

@Override
public Image getImage() {
	return ImageLoader.Moloch.bomba();
}

@Override
public Image getSelectedImage() {
	return ImageLoader.Moloch.bombaSelected();
}

@Override
public Image getNettedImage() {
	return ImageLoader.Moloch.bomba();
}
}
