public class Monster implements Cloneable {
    private String monsterName;
    private double monsterMaxHealth;
    private double monsterDamage;
    private double monsterCurrentHealth;
    private int monsterCost;
    private int monsterLevel = 0;
    private double criticalStrike;
	private boolean hasLeveledUp = false;
	/**
	 * Class Constructor that specifies name, health, damage, critical chance and cost of mosnter
	 * @param name String name of monster
	 * @param health Double health of monster current and max
	 * @param damage Double damage of monster that can be dealt
	 * @param critChance Double percentage of critical hit change of mosnter
	 * @param cost int cost of the monster
	 */
	public Monster(String name, double health, double damage, double critChance, int cost) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
        criticalStrike = critChance;
        monsterCost = cost;
    }
	/**
	 * Clone of monster
	 * @return Monster clone
	 */
	public Monster clone() throws CloneNotSupportedException {
		Monster monster = (Monster) super.clone();
		return monster;
	}
	/**
	 * get to check if monster has leveled up in past day
	 * @return boolean to check if monster has leveled up
	 */
	 public boolean getLeveledUp() {
			return hasLeveledUp;
	}
	/**
	 * set monster's leveled up status 
	 * @param newHasLeveledUp boolean new level up status
	 */
	public void setHasLeveledUp(boolean newHasLeveledUp) {
		hasLeveledUp = newHasLeveledUp;
	}
	/**
	 * resets has leveled up status to false
	 */
    public void resetLevel() {
    	if (getLeveledUp() == true) {
    		setHasLeveledUp(false);
    	}
    }
	/**
	 * Gets name of monster
	 * @return String name of monster
	 */
    public String getName() {
        return monsterName;
    }
	/**
	 * Gets damage of monster
	 * @return Double damage of monster
	 */
    public double getDamage(){
        return monsterDamage;
    }
	/**
	 * Gets current health of monster
	 * @return Double monsters current health
	 */
    public double getMonsterCurrentHealth(){
        return monsterCurrentHealth;
    }
	/**
	 * Gets current monster's max health 
	 * @return Double monsters max health
	 */
    public double getMonsterMaxHealth(){
        return monsterMaxHealth;
    }
	/**
	 * Gets the Critical Strike change of mosnter
	 * @return Double mosnter's critical Strike chance 
	 */
    public double getCriticalStrike(){
        return criticalStrike;
    }
	/**
	 * Sets monster current health
	 * @param newHealth Double monster's new current health 
	 */
    public void setCurrentHealth(double newHealth) {
        monsterCurrentHealth = newHealth;
    }
	/**
	 * Sets mosnters max health
	 * @param newHealth Double monster's new max health
	 */
    public void setMaxHealth(double newHealth) {
        monsterMaxHealth = newHealth;
    }
	/**
	 * Sets monsters damage
	 * @param newDamage Double monster's new damage
	 */
    public void setDamage(double newDamage) {
        monsterDamage = newDamage;
    }
	/**
	 * Gets monster's current level
	 * @return int monster's current level
	 */
	public int getMonsterLevel() {
		return monsterLevel;
	}
	/**
	 * Sets monster's current level
	 * @param newMonsterLevel int monster's new level
	 */
	public void setMonsterLevel(int newMonsterLevel) {
		monsterLevel = newMonsterLevel;
	}
	/**
	 * Gets monster's current cost
	 * @return int monster's current cost
	 */
	public int getCost() {
		return monsterCost;
	}
	/**
	 * levels up the moster by increase monster level by one and damage and health increasing by 10 
	 */
	public void levelUp() {
		setMonsterLevel(getMonsterLevel()+1);
		setCurrentHealth(getMonsterCurrentHealth()+10);
		setMaxHealth(getMonsterMaxHealth()+10);
		setDamage(getDamage()+10);
		hasLeveledUp = true;
	}
	/**
	 * Sets monster's cost
	 * @param newMonsterCost int monster's new cost
	 */
	public void setMonsterCost(int newMonsterCost) {
		monsterCost = newMonsterCost;
	}
	/**
	 * checks if level up occured during random event 
	 * @return String Level up if true else blank
	 */
	public String checkIfLeveledUp() {
		if (getLeveledUp() == true) {
			return " Level Up!";
		} else {
			return "";
		}
	}
}
