public class Item {
    private int healthIncrease = 0;
    private int maxHealthIncrease = 0;
    private int damageIncrease = 0;

    public void setHealthIncrease(int health){
        healthIncrease = health;
    }
    public void setMaxHealthIncrease(int health){
        maxHealthIncrease = health;
    }
    public void setDamageIncrease(int damage){
        damageIncrease = damage;
    }
    public int getHealthIncrease(){
        return healthIncrease;
    }
    public int getMaxHealthIncrease(){
        return maxHealthIncrease;
    }
    public int getDamageIncrease(){
        return damageIncrease;
    }
}
