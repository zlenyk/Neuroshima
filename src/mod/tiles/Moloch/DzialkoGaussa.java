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
		int tmpPos = position;
		int direction = rotation, power = 1;
		while(board[tmpPos].neighbours[direction]!=null){
			if(!(board[tmpPos].neighbours[direction].getTile() instanceof Empty) 
					&& board[tmpPos].neighbours[direction].getTile().getOwner()!=this.owner){
				
				if(board[tmpPos].neighbours[direction].getTile().shield[(direction+3)%6]==false) 
					board[tmpPos].neighbours[direction].getTile().hp-=power;
				else board[tmpPos].neighbours[direction].getTile().hp-=(power-1);
				
			}
			tmpPos = board[tmpPos].neighbours[direction].getPosition();
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
