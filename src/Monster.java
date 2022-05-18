public class Monster {
    private String monsterName;
    private int monsterMaxHealth;
    private int monsterDamage;
    private int monsterCurrentHealth;
    private int monsterCost;
    private double criticalStrike;

    

    public Monster(String name, int health, int damage, double critChance, int cost) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
        criticalStrike = critChance;
        monsterCost = cost;
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

	public int getCost() {
		return monsterCost;
	}

	public void setMonsterCost(int newMonsterCost) {
		monsterCost = newMonsterCost;
	}

}
