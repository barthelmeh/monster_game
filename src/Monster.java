public class Monster implements Cloneable {
    private String monsterName;
    private double monsterMaxHealth;
    private double monsterDamage;
    private double monsterCurrentHealth;
    private int monsterCost;
    private int monsterLevel = 0;
    private double criticalStrike;
	private boolean hasLeveledUp = false;

	public Monster(String name, double health, double damage, double critChance, int cost) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
        criticalStrike = critChance;
        monsterCost = cost;
    }
	public Monster clone() throws CloneNotSupportedException {
		Monster monster = (Monster) super.clone();
		return monster;
	}
	 public boolean getLeveledUp() {
			return hasLeveledUp;
	}
	public void setHasLeveledUp(boolean newHasLeveledUp) {
		hasLeveledUp = newHasLeveledUp;
	}
    public void resetLevel() {
    	if (getLeveledUp() == true) {
    		System.out.println("asdf");
    		setHasLeveledUp(false);
    	}
    }
    public String getName() {
        return monsterName;
    }

    public double getDamage(){
        return monsterDamage;
    }

    public double getMonsterCurrentHealth(){
        return monsterCurrentHealth;
    }

    public double getMonsterMaxHealth(){
        return monsterMaxHealth;
    }

    public double getCriticalStrike(){
        return criticalStrike;
    }

    public void setCurrentHealth(double newHealth) {
        monsterCurrentHealth = newHealth;
    }

    public void setMaxHealth(double newHealth) {
        monsterMaxHealth = newHealth;
    }

    public void setDamage(double newDamage) {
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
		if (getLeveledUp() == true) {
			System.out.println("1");
			return " Level Up!";
		} else {
			System.out.println("2");
			return "";
		}
	}

}
