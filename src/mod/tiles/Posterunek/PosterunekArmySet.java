package mod.tiles.Posterunek;

import mod.ArmySet;
import mod.FieldModel;
import mod.Player;

public class PosterunekArmySet extends ArmySet {
	public PosterunekArmySet(Player owner, FieldModel board[]){
		super();
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Biegacz(owner, board));
		list.add(new Biegacz(owner, board));
		list.add(new Ckm(owner, board));
		list.add(new Ckm(owner, board));
		list.add(new Komandos(owner, board));
		list.add(new Komandos(owner, board));
		list.add(new Komandos(owner, board));
		list.add(new Komandos(owner, board));
		list.add(new Komandos(owner, board));
		list.add(new Komandos(owner, board));
		list.add(new Likwidator(owner, board));
		list.add(new Likwidator(owner, board));
		list.add(new Likwidator(owner, board));
		list.add(new PancerzWspomagany(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Silacz(owner, board));
		list.add(new Snajper(owner, board));
		list.add(new Dywersant(owner, board));
		list.add(new Oficer(owner, board));
		list.add(new Zwiadowca(owner, board));
		list.add(new Zwiadowca(owner, board));
	}
}
