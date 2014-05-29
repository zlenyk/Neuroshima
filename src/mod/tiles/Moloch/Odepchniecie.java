package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;

public class Odepchniecie extends mod.Tile {

	@Override
	public void put(int position, int rotation) {
		// TODO Auto-generated method stub
		/**docelowy algorytm odepchniecia:
		 * standardowo zostaje wywolana funkcja put dla tej plytki na jednym z dostepnych pol
		 * wybieramy plytke kt�ra chcemy odepchnac(pozniej dopisze funkcje ktora zwr�ci list� int�w, ktore pola moge odepchnac)
		 * gracz ktorego plytka jest odpychana wybiera pole na ktore chce zostac odepchniety(tu r�wniez dopisze funkcje ktorea zwroci liste dostepnych pol)
		 * wywolujemy funkcje najpierw pick, a nastepnie put na odepchnietej plytce(list� z pick sie nie przejmujemy, jako argumenty put podajemy normalnie pozycje na ktor� sie przemiescil, a rotacj� tak� jaka byla wczesniej)
		 * 
		 * og�lnie te funkcje dopisze dzis wieczorem, ale problem tu jest raczej z obslug� z gui wiec tym sie trzeba zajac :)
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
