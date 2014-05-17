package mod.tiles.Moloch;

import mod.ArmySet;
import mod.Player;

public class MolochArmySet extends ArmySet {
	public MolochArmySet(Player owner){
		super();
		list.add(new Bloker(owner));
		list.add(new Bloker(owner));
		list.add(new Bomba(owner));
		list.add(new Cyborg(owner));
		list.add(new Cyborg(owner));
		list.add(new DzialkoGaussa(owner));
		list.add(new Juggernaut(owner));
		list.add(new Klaun(owner));
		list.add(new Lowca(owner));
		list.add(new Lowca(owner));
		list.add(new Mozg(owner));
		list.add(new Obronca(owner));
		list.add(new Oficer(owner));
		list.add(new OpancerzonyLowca(owner));
		list.add(new OpancerzonyLowca(owner));
		list.add(new OpancerzonyWartownik(owner));
		list.add(new Rozpruwacz(owner));
		list.add(new Ruch(owner));
		list.add(new Sieciarz(owner));
		list.add(new Szturmowiec(owner));
		list.add(new Wartownik(owner));

	}
}
