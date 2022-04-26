import java.util.ArrayList;

public class player {
    private String playerName;
    private ArrayList<Monster> team = new ArrayList<Monster>();
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int currentMoney;
    private int currentPoints;

    public player(String name){
        playerName = name;
        currentMoney = 10;
        currentPoints = 0;
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
    }
    public void addItem(Item item){
        inventory.add(item);
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
    public void increasePoints(int points){
        currentPoints += points;
    }
    public int getPoints(){
        return currentPoints;
    }
}
