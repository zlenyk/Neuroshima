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
		 * wywolujemy funkcjê whoCanPush();
		 * wybieramy plytke która chcemy odepchnac(z listy któr¹ zwróci³a powy¿sza funkcja)
		 * na rzecz plytki któr¹ wybralismy do odepchniecia, wywolujemy metodê whereCanBePushed(int dircetion) gdzie directiob to kierunek w którym jest polozona plytka w stosunku do plytki odpychajacej
		 * gracz ktorego plytka jest odpychana wybiera pole na ktore chce zostac odepchniety(z listy zwroconej przez funkcje whereCanBePushed)
		 * wywolujemy funkcje najpierw pick, a nastepnie put na odepchnietej plytce(list¹ z pick sie nie przejmujemy, jako argumenty put podajemy normalnie pozycje na ktor¹ sie przemiescil, a rotacjê tak¹ jak¹ plytka miala wczesniej)
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
