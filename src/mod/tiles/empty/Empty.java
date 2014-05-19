package mod.tiles.empty;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

public class Empty extends mod.Tile {
	public Empty(){
		field = new Field(getImage(),getSelectedImage());
	}


@Override
public Image getImage() {
	return ImageLoader.Empty.empty();
}

@Override
public Image getSelectedImage() {
	return ImageLoader.Empty.emptySelected();
}


@Override
public void put(int position, int rotation) {}

}
