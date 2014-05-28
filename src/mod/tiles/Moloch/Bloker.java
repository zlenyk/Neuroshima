package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Bloker extends Unit {
	Bloker(Player owner, FieldModel board[]){
		super(owner,board);
		hp=3;

		shield[0] = true;
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.bloker();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.blokerSelected();
	}
	
}
