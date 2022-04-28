import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class setUp {
    
	private mainGame manager;
	private setupScreen screen;

    

    public setUp(mainGame incomingManager, setupScreen incomingScreen){
    	manager = incomingManager;
    	screen = incomingScreen;
    	gameDifficulty.difficulties difficulty = getDifficulty();
    	int maxDays = getMaxDays();
    	manager.setMaxDay(maxDays);
    	manager.setDifficulty(difficulty);

        
        manager.getPlayer().setPlayerName(getPlayerName());
        manager.getPlayer().addMonster(getUsersStarterMonster());
        System.out.println(getUsersStarterMonster());
    	System.out.println(manager.getMaxDay());
    	System.out.println(manager.getDifficulty());
    }
    public String getPlayerName(){
        String name = screen.userNameTextField.getText();
        return name;
    }
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    public int getMaxDays() {
    	int maxDays = screen.maxDaySlider.getValue();
    	return maxDays;
    }
    public gameDifficulty.difficulties getDifficulty(){
        String userInput = getSelectedButtonText(screen.difficultyButtonGroup);
        gameDifficulty.difficulties dif;
		switch(userInput.toLowerCase()) {
            case "easy":
                dif = gameDifficulty.difficulties.EASY;
                break;
            case "medium":
                dif = gameDifficulty.difficulties.MEDIUM;
                break;
            case "hard":
                dif = gameDifficulty.difficulties.HARD;
                break;
            default:
                dif = gameDifficulty.difficulties.MEDIUM;
        }

        return dif;
    }
    public Monster getUsersStarterMonster(){
        String userInput = getSelectedButtonText(screen.starterButtonGroup);
        ArrayList<Monster> monsters = manager.getStarterMonsters();
        for (Monster monster : monsters){
            if (monster.getName().equals(userInput)){
                return monster;
            }
        } return null;
    }
}