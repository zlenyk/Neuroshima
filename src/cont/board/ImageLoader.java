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
		public static Image sztab(){
			return getImage("graphics/moloch/moloch01-sztab.png");
		}
		public static Image sztabSelected(){
			return getImage("graphics/selected/moloch/moloch01-sztab.png");
		}
		public static Image bitwa(){
			return getImage("graphics/moloch/moloch02-bitwa.png");
		}
		public static Image bitwaSelected(){
			return getImage("graphics/moloch/selected/moloch02-bitwa.png");
		}
		public static Image ruch(){
			return getImage("graphics/moloch/moloch03-ruch.png");
		}
		public static Image ruchSelected(){
			return getImage("graphics/moloch/selected/moloch03-ruch.png");
		}
		public static Image odepchniecie(){
			return getImage("graphics/moloch/moloch04-odepchniecie.png");
		}
		public static Image odepchniecieSelected(){
			return getImage("graphics/moloch/selected/moloch04-odepchniecie.png");
		}
		public static Image bloker(){
			return getImage("graphics/moloch/moloch06-bloker.png");
		}
		public static Image blokerSelected(){
			return getImage("graphics/moloch/selected/moloch06-bloker.png");
		}
		public static Image cyborg(){
			return getImage("graphics/moloch/moloch07-cyborg.png");
		}
		public static Image cyborgSelected(){
			return getImage("graphics/moloch/selected/moloch07-cyborg.png");
		}
		public static Image dzialkogaussa(){
			return getImage("graphics/moloch/moloch08-dzialkogaussa.png");
		}
		public static Image dzialkogaussaSelected(){
			return getImage("graphics/moloch/selected/moloch08-dzialkogaussa.png");
		}
		public static Image juggernaut(){
			return getImage("graphics/moloch/moloch09-juggernaut.png");
		}
		public static Image juggernautSelected(){
			return getImage("graphics/moloch/selected/moloch09-juggernaut.png");
		}
		public static Image klaun(){
			return getImage("graphics/moloch/moloch10-klaun.png");
		}
		public static Image klaunSelected(){
			return getImage("graphics/moloch/selected/moloch10-klaun.png");
		}
		public static Image lowca(){
			return getImage("graphics/moloch/moloch11-lowca.png");
		}
		public static Image lowcaSelected(){
			return getImage("graphics/moloch/selected/moloch11-lowca.png");
		}
		public static Image obronca(){
			return getImage("graphics/moloch/moloch12-obronca.png");
		}
		public static Image obroncaSelected(){
			return getImage("graphics/moloch/selected/moloch12-obronca.png");
		}
		public static Image opancerzonylowca(){
			return getImage("graphics/moloch/moloch13-opancerzonylowca.png");
		}
		public static Image opancerzonylowcaSelected(){
			return getImage("graphics/moloch/selected/moloch13-opancerzonylowca.png");
		}
		public static Image opancerzonywartownik(){
			return getImage("graphics/moloch/moloch14-opancerzonywartownik.png");
		}
		public static Image opancerzonywartownikSelected(){
			return getImage("graphics/moloch/selected/moloch14-opancerzonywartownik.png");
		}
		public static Image rozpruwacz(){
			return getImage("graphics/moloch/moloch15-rozpruwacz.png");
		}
		public static Image rozpruwaczSelected(){
			return getImage("graphics/moloch/selected/moloch15-rozpruwacz.png");
		}
		public static Image sieciarz(){
			return getImage("graphics/moloch/moloch16-sieciarz.png");
		}
		public static Image sieciarzSelected(){
			return getImage("graphics/moloch/selected/moloch16-sieciarz.png");
		}
		public static Image szturmowiec(){
			return getImage("graphics/moloch/moloch17-szturmowiec.png");
		}
		public static Image szturmowiecSelected(){
			return getImage("graphics/moloch/selected/moloch17-szturmowiec.png");
		}
		public static Image wartownik(){
			return getImage("graphics/moloch/moloch18-wartownik.png");
		}
		public static Image wartownikSelected(){
			return getImage("graphics/moloch/selected/moloch18-wartownik.png");
		}
		public static Image mozg(){
			return getImage("graphics/moloch/moloch19-mozg.png");
		}
		public static Image mozgSelected(){
			return getImage("graphics/moloch/selected/moloch19-mozg.png");
		}
		public static Image oficer(){
			return getImage("graphics/moloch/moloch20-oficer.png");
		}
		public static Image oficerSelected(){
			return getImage("graphics/moloch/selected/moloch20-oficer.png");
		}
		public static Image zwiadowca(){
			return getImage("graphics/moloch/moloch21-zwiadowca.png");
		}
		public static Image zwiadowcaSelected(){
			return getImage("graphics/moloch/selected/moloch21-zwiadowca.png");
		}
		public static Image medyk(){
			return getImage("graphics/moloch/moloch22-medyk.png");
		}
		public static Image medykSelected(){
			return getImage("graphics/moloch/selected/moloch22-medyk.png");
		}
		public static Image matka(){
			return getImage("graphics/moloch/moloch23-matka.png");
		}
		public static Image matkaSelected(){
			return getImage("graphics/moloch/selected/moloch23-matka.png");
		}
	}
	public static class Hegemonia{
		static File imageFile;
		public static Image sztab(){
			return getImage("graphics/hegemonia/hegemonia01-sztab.png");
		}
		public static Image sztabSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia01-sztab.png");
		}
		public static Image bitwa(){
			return getImage("graphics/hegemonia/hegemonia02-bitwa.png");
		}
		public static Image bitwaSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia02-bitwa.png");
		}
		public static Image ruch(){
			return getImage("graphics/hegemonia/hegemonia03-ruch.png");
		}
		public static Image ruchSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia03-ruch.png");
		}
		public static Image odepchniecie(){
			return getImage("graphics/hegemonia/hegemonia04-odepchniecie.png");
		}
		public static Image odepchniecieSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia04-odepchniecie.png");
		}
		public static Image snajper(){
			return getImage("graphics/hegemonia/hegemonia05-snajper.png");
		}
		public static Image snajperSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia05-snajper.png");
		}
		public static Image biegacz(){
			return getImage("graphics/hegemonia/hegemonia06-biegacz.png");
		}
		public static Image biegaczSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia06-biegacz.png");
		}
		public static Image bydlak(){
			return getImage("graphics/hegemonia/hegemonia07-bydlak.png");
		}
		public static Image bydlakSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia07-bydlak.png");
		}
		public static Image ganger(){
			return getImage("graphics/hegemonia/hegemonia08-ganger.png");
		}
		public static Image gangerSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia08-ganger.png");
		}
		public static Image gladiator(){
			return getImage("graphics/hegemonia/hegemonia09-gladiator.png");
		}
		public static Image gladiatorSelected(){
			return getImage("graphics/hegemonia/sleceted/hegemonia09-gladiator.png");
		}
		public static Image sieciarz(){
			return getImage("graphics/hegemonia/hegemonia10-sieciarz.png");
		}
		public static Image sieciarzSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia10-sieciarz.png");
		}
		public static Image straznik(){
			return getImage("graphics/hegemonia/hegemonia11-straznik.png");
		}
		public static Image straznikSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia11-straznik.png");
		}
		public static Image supersieciarz(){
			return getImage("graphics/hegemonia/hegemonia12-supersieciarz.png");
		}
		public static Image supersieciarzSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia12-supersieciarz.png");
		}
		public static Image uniwersalnyzolnierz(){
			return getImage("graphics/hegemonia/hegemonia13-uniwersalnyzolnierz.png");
		}
		public static Image uniwersalnyzolnierzSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia13-uniwersalnyzolnierz.png");
		}
		public static Image boss(){
			return getImage("graphics/hegemonia/hegemonia14-boss.png");
		}
		public static Image bossSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia14-boss.png");
		}
		public static Image kwatermistrz(){
			return getImage("graphics/hegemonia/hegemonia15-kwatermistrz.png");
		}
		public static Image kwatermistrzSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia15-kwatermistrz.png");
		}
		public static Image oficer1(){
			return getImage("graphics/hegemonia/hegemonia16-oficer1.png");
		}
		public static Image oficer1Selected(){
			return getImage("graphics/hegemonia/selected/hegemonia16-oficer1.png");
		}
		public static Image oficer2(){
			return getImage("graphics/hegemonia/hegemonia17-oficer2.png");
		}
		public static Image oficer2Selected(){
			return getImage("graphics/hegemonia/selected/hegemonia17-oficer2.png");
		}
		public static Image transport(){
			return getImage("graphics/hegemonia/hegemonia18-transport.png");
		}
		public static Image transportSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia18-transport.png");
		}
		public static Image zwiadowca(){
			return getImage("graphics/hegemonia/hegemonia19-zwiadowca.png");
		}
		public static Image zwiadowcaSelected(){
			return getImage("graphics/hegemonia/selected/hegemonia19-zwiadowca.png");
		}
	}
	public static class Posterunek{
		static File imageFile;
		public static Image sztab(){
			return getImage("graphics/hegemonia/posterunek01-sztab.png");
		}
		public static Image sztabSelected(){
			return getImage("graphics/hegemonia/selected/posterunek01-sztab.png");
		}
		public static Image bitwa(){
			return getImage("graphics/hegemonia/posterunek02-bitwa.png");
		}
		public static Image bitwaSelected(){
			return getImage("graphics/hegemonia/selected/posterunek02-bitwa.png");
		}
		public static Image ruch(){
			return getImage("graphics/hegemonia/posterunek03-ruch.png");
		}
		public static Image ruchSelected(){
			return getImage("graphics/hegemonia/selected/posterunek03-ruch.png");
		}
		public static Image snajper(){
			return getImage("graphics/hegemonia/posterunek04-snajper.png");
		}
		public static Image snajperSelected(){
			return getImage("graphics/hegemonia/selected/posterunek04-snajper.png");
		}
		public static Image biegacz(){
			return getImage("graphics/hegemonia/posterunek05-biegacz.png");
		}
		public static Image biegaczSelected(){
			return getImage("graphics/hegemonia/selected/posterunek05-biegacz.png");
		}
		public static Image ckm(){
			return getImage("graphics/hegemonia/posterunek06-ckm.png");
		}
		public static Image ckmSelected(){
			return getImage("graphics/hegemonia/selected/posterunek06-ckm.png");
		}
		public static Image komandos(){
			return getImage("graphics/hegemonia/posterunek07-komandos.png");
		}
		public static Image komandosSelected(){
			return getImage("graphics/hegemonia/selected/posterunek07-komandos.png");
		}
		public static Image likwidator(){
			return getImage("graphics/hegemonia/posterunek08-likwidator.png");
		}
		public static Image likwidatorSelected(){
			return getImage("graphics/hegemonia/selected/posterunek08-likwidator.png");
		}
		public static Image pancerzwspomagany(){
			return getImage("graphics/hegemonia/posterunek09-pancerzwspomagany.png");
		}
		public static Image pancerzwspomaganySelected(){
			return getImage("graphics/hegemonia/selected/posterunek09-pancerzwspomagany.png");
		}
		public static Image silacz(){
			return getImage("graphics/hegemonia/posterunek10-silacz.png");
		}
		public static Image silaczSelected(){
			return getImage("graphics/hegemonia/selected/posterunek10-silacz.png");
		}
		public static Image centrumrozpoznawania(){
			return getImage("graphics/hegemonia/posterunek11-centrumrozpoznawania.png");
		}
		public static Image centrumrozpoznawaniaSelected(){
			return getImage("graphics/hegemonia/selected/posterunek11-centrumrozpoznawania.png");
		}
		public static Image dywersant(){
			return getImage("graphics/hegemonia/posterunek12-dywersant.png");
		}
		public static Image dywersantSelected(){
			return getImage("graphics/hegemonia/selected/posterunek12-dywersant.png");
		}
		public static Image medyk(){
			return getImage("graphics/hegemonia/posterunek13-medyk.png");
		}
		public static Image medykSelected(){
			return getImage("graphics/hegemonia/selected/posterunek13-medyk.png");
		}
		public static Image oficer(){
			return getImage("graphics/hegemonia/posterunek14-oficer.png");
		}
		public static Image oficerSelected(){
			return getImage("graphics/hegemonia/selected/posterunek14-oficer.png");
		}
		public static Image skoper(){
			return getImage("graphics/hegemonia/posterunek15-skoper.png");
		}
		public static Image skoperSelected(){
			return getImage("graphics/hegemonia/selected/posterunek15-skoper.png");
		}
		public static Image zwiadowca(){
			return getImage("graphics/hegemonia/posterunek16-zwiadowca.png");
		}
		public static Image zwiadowcaSelected(){
			return getImage("graphics/hegemonia/selected/posterunek16-zwiadowca.png");
		}
	}
	public static class Empty{
		static File imageFile;
		public static Image empty(){
			return getImage("graphics/empty.png");
		}
		public static Image emptySelected(){
			return getImage("graphics/selected_empty.png");
		}
	}
}
