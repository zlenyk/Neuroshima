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
		field = new Field(getImage(),getSelectedImage());
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
	if(!(board[position].tile instanceof Empty) && !board[position].tile.isSztab()){
		board[position].tile.takeDmg(1);
		if(board[position].tile.getHp()<=0) board[position].tile.die();
	}
	for(int i=0;i<6;i++){
		if(!(board[position].neighbours[i].tile instanceof Empty) && !board[position].neighbours[i].tile.isSztab()){
			board[position].neighbours[i].tile.takeDmg(1);
			if(board[position].neighbours[i].tile.getHp()<=0) board[position].neighbours[i].tile.die();
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
}
