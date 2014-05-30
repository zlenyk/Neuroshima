package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;

public class Odepchniecie extends mod.Tile {

	@Override
	public void put(int position, int rotation) {
		// TODO Auto-generated method stub
		/**docelowy algorytm odepchniecia:
		 * standardowo zostaje wywolana funkcja put dla tej plytki na jednym z dostepnych pol
		 * w funkcji put:
		 * wywolujemy funkcj� whoCanPush();
		 * wybieramy plytke kt�ra chcemy odepchnac(z listy kt�r� zwr�ci�a powy�sza funkcja)
		 * na rzecz plytki kt�r� wybralismy do odepchniecia, wywolujemy metod� whereCanBePushed(int dircetion) gdzie directiob to kierunek w kt�rym jest polozona plytka w stosunku do plytki odpychajacej
		 * gracz ktorego plytka jest odpychana wybiera pole na ktore chce zostac odepchniety(z listy zwroconej przez funkcje whereCanBePushed)
		 * wywolujemy funkcje najpierw pick, a nastepnie put na odepchnietej plytce(list� z pick sie nie przejmujemy, jako argumenty put podajemy normalnie pozycje na ktor� sie przemiescil, a rotacj� tak� jak� plytka miala wczesniej)
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
