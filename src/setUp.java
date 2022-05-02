import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class setUp {
    
	private mainGame manager;
	private setupScreen screen;

    public setUp(mainGame incomingManager){
        manager = incomingManager;
        try {
            setMonsters();
            setStarterMonsters();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        manager.launchSetupScreen();
    }
    private void setMonsters() throws FileNotFoundException {
        BufferedReader br = null;
        try {
            File file = new File("Text Files/monsters.txt");
            br = new BufferedReader(new FileReader(file));

            String monster;

            while ((monster = br.readLine()) != null){
                String[] values = monster.split(",");
                Monster obj = new Monster(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]),Double.parseDouble(values[3]));
                manager.addToAllMonsters(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // Close the file
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStarterMonsters(){
        ArrayList<Monster> avaiableMonsters = manager.getAllMonsters();
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int randomIndex = rand.nextInt(avaiableMonsters.size());
            Monster randomMonster = avaiableMonsters.get(randomIndex);
            manager.getStarterMonsters().add(randomMonster);
            avaiableMonsters.remove(randomIndex);
        }
    }
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