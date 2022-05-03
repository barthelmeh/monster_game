public class Monster {
    private String monsterName;
    private int monsterMaxHealth;
    private int monsterDamage;
    private int monsterCurrentHealth;
    private double criticalStrike;

    

    public Monster(String name, int health, int damage, double critChance) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
        criticalStrike = critChance;
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
    public void useItem(Item item) {
    }
}
