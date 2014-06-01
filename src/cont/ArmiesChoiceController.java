package cont;

import gui.PlayerProfile;

import java.util.List;

import mod.Config;
import mod.InvalidConfigException;

/**
 * @author zygmunt
 * Controls behavior and apperance of armies-choice-window.
 */
public class ArmiesChoiceController implements WindowController{
		
	GUIController guiController;
	PlayerProfile playerProfile;
	public ArmiesChoiceController(PlayerProfile ac,GUIController gui){
		guiController = gui;
		playerProfile = ac;
	}
	/**
	 * @param gui
	 * @return controller to the newly created armies-choice-window.
	 * Creates and displays new army-choice-window.
	 */
	public static ArmiesChoiceController openNewArmiesChoice(GUIController gui){
		PlayerProfile ac = new PlayerProfile(gui);
		ac.getFrame().setVisible(true);
		return ac.getController();
	}
	/**
	 * @param armies
	 * Implements start-game-button. Passes armies-list to GUIController and asks to create new game.
	 * @throws InvalidConfigException 
	 */
	public void startNewGame(List<String> armies,List<String> playersNames){
		String check = checkConfig(armies,playersNames);

		if(check.equals("OK")){
			guiController.startNewGame(armies,playersNames);
		}
		else{
			armies.clear();
			guiController.reportError(check, this);
		}
	}

	/**
	 * @param armies
	 * @param playersNames
	 * @return message about the result of checking
	 * Checks whether input provided by player(chosen armies and players' names) meets configuration rules.
	 */
	private String checkConfig(List<String>armies,List<String>playersNames){
		if(armies.size() != 2){
			return MessageBuilder.armiesErrorMessage();
		}
		if(playersNames.size() != Config.getPLAYERS()){
			return MessageBuilder.playersCountErrorMessage();
		}
		for(int i = 0; i<playersNames.size(); i++){
			if(playersNames.get(i).length() > 20 || playersNames.get(i).length() < 2){
				return MessageBuilder.lettersErrorMessage();
			}
		}
		return "OK";
	}
	@Override
	public void show() {
		playerProfile.getFrame().setVisible(true);
	}
	@Override
	public void hide() {
		playerProfile.getFrame().setVisible(false);		
	}
	@Override
	public void repaint() {
		playerProfile.getFrame().repaint();
	}
}
