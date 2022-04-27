
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class setUp {
    
	private mainGame manager;
	private setupScreen screen;

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public setUp(mainGame incomingManager, setupScreen incomingScreen){
    	manager = incomingManager;
    	screen = incomingScreen;
    	gameDifficulty.difficulties difficulty = getDifficulty();
    	int maxDays = getMaxDays();
    	manager.setMaxDay(maxDays);
    	manager.setDifficulty(difficulty);
    	System.out.println(manager.getMaxDay());
    	System.out.println(manager.getDifficulty());
    }
    public String getPlayerName(){
        String name = screen.userNameTextField.getText();
        return name;
    }
    public int getMaxDays() {
    	int maxDays = screen.maxDaySlider.getValue();
    	return maxDays;
    }
    public gameDifficulty.difficulties getDifficulty(){
        String user_input = getSelectedButtonText(screen.difficultyButtonGroup);
        gameDifficulty.difficulties dif;
		switch(user_input.toLowerCase()) {
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
}