public class Monster {
    private String monsterName;
    private int monsterMaxHealth;
    private int monsterDamage;
    private int monsterCurrentHealth;
    private int criticalStrike;

    

    public Monster(String name, int health, int damage, int critChance) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
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
    public void useItem(Item item) {
        monsterMaxHealth += item.getMaxHealthIncrease();
        monsterDamage += item.getDamageIncrease();
        monsterCurrentHealth += item.getHealthIncrease();
    }
}
