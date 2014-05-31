package mod.tiles.Borgo;

import mod.ArmySet;
import mod.FieldModel;
import mod.Player;

public class BorgoArmySet extends ArmySet {
	public BorgoArmySet(Player owner, FieldModel board[]){
		super();
		list.add(new Granat(owner, board));
		list.add(new Mutek(owner, board));
		list.add(new Mutek(owner, board));
		list.add(new Mutek(owner, board));
		list.add(new Mutek(owner, board));
		list.add(new Mutek(owner, board));
		list.add(new Mutek(owner, board));
		list.add(new Nozownik(owner, board));
		list.add(new Nozownik(owner, board));
		list.add(new Nozownik(owner, board));
		list.add(new Nozownik(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Sieciarz(owner, board));
		list.add(new Sieciarz(owner, board));
		list.add(new Silacz(owner, board));
		list.add(new Silacz(owner, board));
		list.add(new SuperMutant(owner, board));
		list.add(new Zabojca(owner, board));
		list.add(new Zabojca(owner, board));
		list.add(new Oficer(owner, board));
		list.add(new Oficer(owner, board));
		list.add(new SuperOficer(owner, board));
		list.add(new Zwiadowca(owner, board));
		list.add(new Zwiadowca(owner, board));
	}
}
