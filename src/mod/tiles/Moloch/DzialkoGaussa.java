package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class DzialkoGaussa extends Unit {
	DzialkoGaussa(Player owner, FieldModel board[]){
		super(owner,board);
		hp=2;
		initiative.add(1);

	}
	
	public void attack(){
		//shoot(rotation,1+shootBonus);
		int direction = rotation, power = 1;
		while(board[position].neighbours[direction]!=null){
			if(!(board[position].neighbours[direction].getTile() instanceof Empty) 
					&& board[position].neighbours[direction].getTile().getOwner()!=this.owner){
				
				if(board[position].neighbours[direction].getTile().shield[(direction+3)%6]==false) 
					board[position].neighbours[direction].getTile().hp-=power;
				else board[position].neighbours[direction].getTile().hp-=(power-1);
				
			}
		}
	}
	// Dzialo Gaussa strzela do wszystkich celow na swojej linii

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.dzialkogaussa();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.dzialkogaussaSelected();
	}
}
