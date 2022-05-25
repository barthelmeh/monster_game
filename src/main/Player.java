package main;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private ArrayList<Monster> team = new ArrayList<Monster>();
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int currentMoney;
    private int currentPoints;
    
    public Player(){
        currentMoney = 10;
        currentPoints = 0;
    }
    public Player(String name, Monster monster, Item item){
        playerName = name;
        team.add(monster);
        inventory.add(item);
        currentMoney = 10;
        currentPoints = 0;
    }
    public void resetLevels() {
        for (Monster monster : team) {
            monster.resetLevel();
        }
    }
    public void addStarters(Monster monster, Item item) {
    	team.add(monster);
    	inventory.add(item);
    }
    public void setPlayerName(String name){
        playerName = name;
    }
    public String getPlayerName(){
        return playerName;
    }
    public ArrayList<Monster> getTeam(){
        return team;
    }
    public ArrayList<Item> getInventory(){
        return inventory;
    }
    public void addMonster(Monster monster){
        team.add(monster);
        decreaseMoney(monster.getCost());
    }
    public void addItem(Item item){
        inventory.add(item);
        decreaseMoney(item.getItemCost());
    }
    public int getCurrentMoney(){
        return currentMoney;
    }
    public void addMoney(int amount){
        currentMoney += amount;
    }
    public void decreaseMoney(int amount){
        currentMoney -= amount;
    }
    public void releaseMonster(Monster monster){
        team.remove(monster);
    }
    public void increaseScore(int points){
        currentPoints += points;
    }
    public int getScore(){
        return currentPoints;
    }
    
}
