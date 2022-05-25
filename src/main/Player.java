package main;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private ArrayList<Monster> team = new ArrayList<Monster>();
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int currentMoney;
    private int currentPoints;
    /**
     * Class constructor giving player 0 points and 10 coins
     */
    public Player(){
        currentMoney = 10;
        currentPoints = 0;
    }
    /**
     * Class constructor specifying player name, a starter mosnter and starter item and setting point to 0 and coins to 10
     * @param name
     * @param monster
     * @param item
     */
    public Player(String name, Monster monster, Item item){
        playerName = name;
        team.add(monster);
        inventory.add(item);
        currentMoney = 10;
        currentPoints = 0;
    }
    /**
     * resets all monsters has levelled up check
     */
    public void resetLevels() {
        for (Monster monster : team) {
            monster.resetLevel();
        }
    }
    /**
     * added starter monster and item to team and inventory 
     * @param monster Monster starter added to team
     * @param item Item starter added to inventory
     */
    public void addStarters(Monster monster, Item item) {
    	team.add(monster);
    	inventory.add(item);
    }
    /**
     * sets players name
     * @param name String player's new name
     */
    public void setPlayerName(String name){
        playerName = name;
    }
    /**
     * gets players name to be displayed back to them
     * @return String player's name
     */
    public String getPlayerName(){
        return playerName;
    }
    /**
     * gets players current team
     * @return ArrayList<Monster> current team
     */
    public ArrayList<Monster> getTeam(){
        return team;
    }
    /**
     * gets players current iventory
     * @return ArrayList<Item> current inventory
     */
    public ArrayList<Item> getInventory(){
        return inventory;
    }
    /**
     * adds monster to team and decrease money from user
     * @param monster Monster new addition to team
     */
    public void addMonster(Monster monster){
        team.add(monster);
        decreaseMoney(monster.getCost());
    }
    /**
     * Adds monster to team that occured from random event
     * @param monster Monster new addition to team
     */
    public void addRandomMonster(Monster monster) {
    	team.add(monster);
    }
    /**
     * added item to inventory and decrease money from user
     * @param item Item new addition to inventory
     */
    public void addItem(Item item){
        inventory.add(item);
        decreaseMoney(item.getItemCost());
    }
    /**
     * gets current money of user
     * @return int current money
     */
    public int getCurrentMoney(){
        return currentMoney;
    }
    /**
     * adds money to user
     * @param amount int new money
     */
    public void addMoney(int amount){
        currentMoney += amount;
    }
    /**
     * decreases money to user
     * @param amount int amount lost
     */
    public void decreaseMoney(int amount){
        currentMoney -= amount;
    }
    /**
     * removes monster from team
     * @param monster Monster that is released
     */
    public void releaseMonster(Monster monster){
        team.remove(monster);
    }
    /**
     * increases users score after battle
     * @param points int gained from battle
     */
    public void increaseScore(int points){
        currentPoints += points;
    }
    /**
     * gets current score of the user
     * @return int current score
     */
    public int getScore(){
        return currentPoints;
    }
    
}
