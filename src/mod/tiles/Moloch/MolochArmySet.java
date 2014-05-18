package mod.tiles.Moloch;

import mod.ArmySet;
import mod.FieldModel;
import mod.Player;

public class MolochArmySet extends ArmySet {
	public MolochArmySet(Player owner, FieldModel board[]){
		super();
		list.add(new Bloker(owner, board));
		list.add(new Bloker(owner, board));
		list.add(new Bomba(owner, board));
		list.add(new Cyborg(owner, board));
		list.add(new Cyborg(owner, board));
		list.add(new DzialkoGaussa(owner, board));
		list.add(new Juggernaut(owner, board));
		list.add(new Klaun(owner, board));
		list.add(new Lowca(owner, board));
		list.add(new Lowca(owner, board));
		list.add(new Mozg(owner, board));
		list.add(new Obronca(owner, board));
		list.add(new Oficer(owner, board));
		list.add(new OpancerzonyLowca(owner, board));
		list.add(new OpancerzonyLowca(owner, board));
		list.add(new OpancerzonyWartownik(owner, board));
		list.add(new Rozpruwacz(owner, board));
		list.add(new Ruch(owner, board));
		list.add(new Sieciarz(owner, board));
		list.add(new Szturmowiec(owner, board));
		list.add(new Wartownik(owner, board));

	}
}
