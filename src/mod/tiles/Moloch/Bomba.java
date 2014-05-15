package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import cont.board.ImageLoader;

public class Bomba extends mod.Tile {
	public Bomba(){
		field = new Field(getImage(),getSelectedImage());
	}

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
public void put(int position){
	board[position].tile.takeDmg(1);
	for(int i=0;i<6;i++) if(board[position].tile!=null) board[position].tile.takeDmg(1);
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
