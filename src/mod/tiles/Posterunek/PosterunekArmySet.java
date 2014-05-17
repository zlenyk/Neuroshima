package mod.tiles.Posterunek;

import mod.ArmySet;
import mod.Player;

public class PosterunekArmySet extends ArmySet {
	public PosterunekArmySet(Player owner){
		super();
		list.add(new Biegacz(owner));
		list.add(new Biegacz(owner));
		list.add(new Ckm(owner));
		list.add(new Komandos(owner));
		list.add(new Komandos(owner));
		list.add(new Komandos(owner));
		list.add(new Komandos(owner));
		list.add(new Komandos(owner));
		list.add(new Likwidator(owner));
		list.add(new Likwidator(owner));
		list.add(new PancerzWspomagany(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Silacz(owner));
		list.add(new Snajper(owner));

	}
}
