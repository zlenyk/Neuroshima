package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;

public class Odepchniecie extends mod.Tile {

	@Override
	public void put(int position, int rotation) {
		// TODO Auto-generated method stub
		/**docelowy algorytm odepchniecia:
		 * standardowo zostaje wywolana funkcja put dla tej plytki na jednym z dostepnych pol
		 * wybieramy plytke która chcemy odepchnac(pozniej dopisze funkcje ktora zwróci listê intów, ktore pola moge odepchnac)
		 * gracz ktorego plytka jest odpychana wybiera pole na ktore chce zostac odepchniety(tu równiez dopisze funkcje ktorea zwroci liste dostepnych pol)
		 * wywolujemy funkcje najpierw pick, a nastepnie put na odepchnietej plytce(list¹ z pick sie nie przejmujemy, jako argumenty put podajemy normalnie pozycje na ktor¹ sie przemiescil, a rotacjê tak¹ jaka byla wczesniej)
		 * 
		 * ogólnie te funkcje dopisze dzis wieczorem, ale problem tu jest raczej z obslug¹ z gui wiec tym sie trzeba zajac :)
		 */
		
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.odepchniecie();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.odepchniecieSelected();
	}
	
}
