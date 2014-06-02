package mod.tiles.Hegemonia;

import mod.ArmySet;
import mod.FieldModel;
import mod.Player;

public class HegemoniaArmySet extends ArmySet {
	public HegemoniaArmySet(Player owner, FieldModel board[]){
		super();
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Battle(owner, board));
		list.add(new Biegacz(owner, board));
		list.add(new Biegacz(owner, board));
		list.add(new Biegacz(owner, board));
		list.add(new Bydlak(owner, board));
		list.add(new Ganger(owner, board));
		list.add(new Ganger(owner, board));
		list.add(new Ganger(owner, board));
		list.add(new Ganger(owner, board));
		list.add(new Gladiator(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Sieciarz(owner, board));
		list.add(new Sieciarz(owner, board));
		list.add(new Snajper(owner, board));
		list.add(new Straznik(owner, board));
		list.add(new SuperSieciarz(owner, board));
		list.add(new UniwersalnyZolnierz(owner, board));
		list.add(new UniwersalnyZolnierz(owner, board));
		list.add(new UniwersalnyZolnierz(owner, board));
		list.add(new Boss(owner, board));
		list.add(new Oficer1(owner, board));
		list.add(new Oficer1(owner, board));
		list.add(new Oficer2(owner, board));
		list.add(new Zwiadowca(owner, board));
	}
}
