package cont.board;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	static File imageFile;
	private static Image getImage(String path){
		imageFile = new File(path);
		try { return ImageIO.read(imageFile);} 
		catch (IOException e) {e.printStackTrace();}	//jeżeli obrazki są załadowane, to to się nie zdarzy.
		return null;
	}
	public static class Borgo{
		static File imageFile;
		public static Image sztab(){
			return getImage("graphics/borgo/borgo01-sztab.png");
		}
		public static Image sztabSelected(){
			return getImage("graphics/borgo/selected/borgo01-sztab.png");
		}
		public static Image bitwa(){
			return getImage("graphics/borgo/borgo02-bitwa.png");
		}
		public static Image bitwaSelected(){
			return getImage("graphics/borgo/selected/borgo02-bitwa.png");
		}
		public static Image ruch(){
			return getImage("graphics/borgo/borgo03-ruch.png");
		}
		public static Image ruchSelected(){
			return getImage("graphics/borgo/selected/borgo03-ruch.png");
		}
		public static Image granat(){
			return getImage("graphics/borgo/borgo04-granat.png");
		}
		public static Image granatSelected(){
			return getImage("graphics/borgo/selected/borgo04-granat.png");
		}
		public static Image mutek(){
			return getImage("graphics/borgo/borgo05-mutek.png");
		}
		public static Image mutekSelected(){
			return getImage("graphics/borgo/selected/borgo05-mutek.png");
		}
		public static Image nozownik(){
			return getImage("graphics/borgo/borgo06-nozownik.png");
		}
		public static Image nozownikSelected(){
			return getImage("graphics/borgo/selected/borgo06-nozownik.png");
		}
		public static Image sieciarz(){
			return getImage("graphics/borgo/borgo07-sieciarz.png");
		}
		public static Image sieciarzSelected(){
			return getImage("graphics/borgo/selected/borgo07-sieciarz.png");
		}
		public static Image supermutant(){
			return getImage("graphics/borgo/borgo08-supermutant.png");
		}
		public static Image supermutantSelected(){
			return getImage("graphics/borgo/selected/borgo08-supermutant.png");
		}
		public static Image silacz(){
			return getImage("graphics/borgo/borgo09-silacz.png");
		}
		public static Image silaczSelected(){
			return getImage("graphics/borgo/selected/borgo09-silacz.png");
		}
		public static Image zabojca(){
			return getImage("graphics/borgo/borgo10-zabojca.png");
		}
		public static Image zabojcaSelected(){
			return getImage("graphics/borgo/selected/borgo10-zabojca.png");
		}
		public static Image medyk(){
			return getImage("graphics/borgo/borgo11-medyk.png");
		}
		public static Image medykSelected(){
			return getImage("graphics/borgo/selected/borgo11-medyk.png");
		}
		public static Image oficer(){
			return getImage("graphics/borgo/borgo12-oficer.png");
		}
		public static Image oficerSelected(){
			return getImage("graphics/borgo/selected/borgo12-oficer.png");
		}
		public static Image superoficer(){
			return getImage("graphics/borgo/borgo13-superoficer.png");
		}
		public static Image superoficerSelected(){
			return getImage("graphics/borgo/selected/borgo13-superoficer.png");
		}
		public static Image zwiadowca(){
			return getImage("graphics/borgo/borgo14-zwiadowca.png");
		}
		public static Image zwiadowcaSelected(){
			return getImage("graphics/borgo/selected/borgo14-zwiadowca.png");
		}
	}
	public static class Moloch{
		static File imageFile;
		public static Image bomba(){
			return getImage("graphics/moloch/moloch05-bomba.png");
		}
		public static Image bombaSelected(){
			return getImage("graphics/moloch/selected/moloch05-bomba.png");
		}
	}
}
