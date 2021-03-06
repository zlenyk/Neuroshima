package mod.tiles.empty;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

public class Empty extends mod.Tile {
	public Empty(){
		field = new Field(getImage(),getSelectedImage(),getNettedImage());
	}

	@Override
	public Image getImage() {
		return ImageLoader.Empty.empty();
	}

	@Override
	public boolean isInstant(){
		return false;
	}
	
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Empty.emptySelected();
	}
	@Override
	public Image getNettedImage() {
		return ImageLoader.Empty.empty();
	}
	@Override
	public void put(int position, int rotation) {}

}
