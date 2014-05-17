package mod.tiles.Hegemonia;

import mod.ArmySet;
import mod.Player;

public class HegemoniaArmySet extends ArmySet {
	public HegemoniaArmySet(Player owner){
		super();
		list.add(new Biegacz(owner));
		list.add(new Biegacz(owner));
		list.add(new Biegacz(owner));
		list.add(new Bydlak(owner));
		list.add(new Ganger(owner));
		list.add(new Ganger(owner));
		list.add(new Ganger(owner));
		list.add(new Ganger(owner));
		list.add(new Gladiator(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Ruch(owner));
		list.add(new Sieciarz(owner));
		list.add(new Sieciarz(owner));
		list.add(new Snajper(owner));
		list.add(new Straznik(owner));
		list.add(new SuperSieciarz(owner));
		list.add(new UniwersalnyZolnierz(owner));
		list.add(new UniwersalnyZolnierz(owner));
		list.add(new UniwersalnyZolnierz(owner));
	}
}
