package mod.tiles.Borgo;

import mod.ArmySet;
import mod.Player;

public class BorgoArmySet extends ArmySet {
	public BorgoArmySet(Player owner){
		super();
		list.add(new Granat(owner));
		list.add(new Mutek(owner));
		list.add(new Mutek(owner));
		list.add(new Mutek(owner));
		list.add(new Mutek(owner));
		list.add(new Mutek(owner));
		list.add(new Mutek(owner));
		list.add(new Nozownik(owner));
		list.add(new Nozownik(owner));
		list.add(new Nozownik(owner));
		list.add(new Nozownik(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Sieciarz(owner));
		list.add(new Sieciarz(owner));
		list.add(new Silacz(owner));
		list.add(new Silacz(owner));
		list.add(new SuperMutant(owner));
		list.add(new Zabojca(owner));
		list.add(new Zabojca(owner));
	}
}
