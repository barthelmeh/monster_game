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
            //setItems();
            //setStarterItems();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        manager.launchSetupScreen();
    }
    public void setItems() throws FileNotFoundException {
    	ArrayList<Item> items = new ArrayList<Item>();
    	BufferedReader br = null;
        try {
            File file = new File("Text Files/items.txt");
            br = new BufferedReader(new FileReader(file));

            String item;

            while ((item = br.readLine()) != null){
                String[] values = item.split(",");
                
                switch(values[3]) {
                    case "1":
                        HealthItem healthObj = new HealthItem(values[0],Double.parseDouble(values[1]),Integer.parseInt(values[2]));
                        items.add(healthObj);
                        break;
                    case "2":
                        MaxHealthItem maxHealthObj = new MaxHealthItem(values[0],Double.parseDouble(values[1]),Integer.parseInt(values[2]));
                        items.add(maxHealthObj);
                        break;
                    case "3":
                        DamageItem damageObj = new DamageItem(values[0],Double.parseDouble(values[1]),Integer.parseInt(values[2]));
                        items.add(damageObj);
                        break;
                }
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
        manager.setAllItems(items);
    }
    public void setStarterItems(){
        ArrayList<Item> avaiableItems = manager.getAllItems();
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
        	System.out.println(avaiableItems.size());
            int randomIndex = rand.nextInt(avaiableItems.size());
            Item randomItem = avaiableItems.get(randomIndex);
            manager.getStarterItems().add(randomItem);
            avaiableItems.remove(randomIndex);
        }
    }
    private void setMonsters() throws FileNotFoundException {
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        BufferedReader br = null;
        try {
            File file = new File("Text Files/monsters.txt");
            br = new BufferedReader(new FileReader(file));

            String monster;

            while ((monster = br.readLine()) != null){
                String[] values = monster.split(",");
                Monster obj = new Monster(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]),Double.parseDouble(values[3]));
                monsters.add(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // Close the file
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }manager.setAllMonsters(monsters);
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
    	player newPlayer = manager.getPlayer();
    	screen = incomingScreen;
    	gameDifficulty.difficulties difficulty = getDifficulty();
    	int maxDays = getMaxDays();
    	manager.setMaxDay(maxDays);
    	manager.setDifficulty(difficulty);

        
    	newPlayer.setPlayerName(getPlayerName());
    	newPlayer.addMonster(getUsersStarterMonster());
    	newPlayer.addItem(getUsersStarterItem());
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
        String userInput = getSelectedButtonText(screen.starterMonsterButtonGroup);
        ArrayList<Monster> monsters = manager.getStarterMonsters();
        for (Monster monster : monsters){
            if (monster.getName().equals(userInput)){
                return monster;
            }
        } return null;
    }
    private Item getUsersStarterItem() {
    	String userInput = getSelectedButtonText(screen.starterItemButtonGroup);
    	ArrayList<Item> items = manager.getStarterItems();
    	for (Item item : items) {
    		System.out.println(item.getItemName());
    		System.out.println(userInput);
    		if (item.getItemName().equals(userInput)) {
    			return item;
    		}
    	} return null;
	}
}