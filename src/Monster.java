public class Monster {
    private String monsterName;
    private int monsterMaxHealth;
    private int monsterDamage;
    private int monsterCurrentHealth;
    private int monsterCost;
    private int monsterLevel = 0;
    private double criticalStrike;
	private boolean hasLeveledUp = false;

   
   
	public Monster(String name, int health, int damage, double critChance, int cost) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
        criticalStrike = critChance;
        monsterCost = cost;
    }
	 public boolean getLeveledUp() {
			return hasLeveledUp;
	}
	public void setHasLeveledUp(boolean newHasLeveledUp) {
		hasLeveledUp = newHasLeveledUp;
	}
    public void resetLevel() {
    	if (getLeveledUp() == true) {
    		setHasLeveledUp(false);
    	}
    }
    public String getName() {
        return monsterName;
    }

    public int getDamage(){
        return monsterDamage;
    }

    public int getMonsterCurrentHealth(){
        return monsterCurrentHealth;
    }

    public int getMonsterMaxHealth(){
        return monsterMaxHealth;
    }

    public double getCriticalStrike(){
        return criticalStrike;
    }

    public void setCurrentHealth(int newHealth) {
        monsterCurrentHealth = newHealth;
    }

    public void setMaxHealth(int newHealth) {
        monsterMaxHealth = newHealth;
    }

    public void setDamage(int newDamage) {
        monsterDamage = newDamage;
    }

	public int getMonsterLevel() {
		return monsterLevel;
	}
	public void setMonsterLevel(int newMonsterLevel) {
		monsterLevel = newMonsterLevel;
	}
	public int getCost() {
		return monsterCost;
	}
	public void levelUp() {
		setMonsterLevel(getMonsterLevel()+1);
		setCurrentHealth(getMonsterCurrentHealth()+10);
		setMaxHealth(getMonsterMaxHealth()+10);
		setDamage(getDamage()+10);
		hasLeveledUp = true;
	}
	public void setMonsterCost(int newMonsterCost) {
		monsterCost = newMonsterCost;
	}
	public String checkIfLeveledUp() {
		if (getLeveledUp()) {
			return getName() + "has leveled up";
		} else {
			return null;
		}
	}

}
