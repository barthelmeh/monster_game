public class Monster {
    private String monsterName;
    private int monsterMaxHealth;
    private int monsterDamage;
    private int monsterCurrentHealth;

    public Monster(String name, int health, int damage) {
        monsterName = name;
        monsterMaxHealth = monsterCurrentHealth = health;
        monsterDamage = damage;
    }

    public String getName() {
        return monsterName;
    }


    public void heal(Item item) {
        
    }
}
