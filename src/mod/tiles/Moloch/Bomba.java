package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.Player;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class Bomba extends mod.Tile {
	public Bomba(Player owner){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
	}

public LinkedList<Integer> pick(){
	LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
	whereCanPut.add(4);
	whereCanPut.add(5);
	whereCanPut.add(8);
	whereCanPut.add(9);
	whereCanPut.add(10);
	whereCanPut.add(13);
	whereCanPut.add(14);
	return whereCanPut;
}
public void put(int position, int rotation){
	board[position].tile.takeDmg(1);
	for(int i=0;i<6;i++) if(!(board[position].neighbours[0].tile instanceof Empty)) board[position].tile.takeDmg(1);
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
