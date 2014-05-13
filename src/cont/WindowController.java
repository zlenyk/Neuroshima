package cont;

public interface WindowController {
	/**
	 * Interface for all the controllers which GUIController manages.
	 * Created to assure, that every window has certain methods implemented.
	 */
	public void show();
	public void hide();
	public void repaint();
}
