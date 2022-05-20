public class DamageItem implements Item {
    private String itemName; 
    private double itemIncrease;
    private int itemCost;
    
    public DamageItem(String name, double increase , int cost){
		itemName = name;
		itemIncrease = increase;
		itemCost = cost;
	}

	public void applyItem(Monster monster) {
		double currentDamage = monster.getDamage();
		double newDamage = (currentDamage + (currentDamage*itemIncrease));
		monster.setDamage(newDamage);
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemIncrease() {
		return itemIncrease;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemName(String newItemName) {
		itemName = newItemName;
	}

	public void setItemIncrease(double newItemIncrease) {
		itemIncrease = newItemIncrease;
	}

	public void setItemCost(int newItemCost) {
		itemCost = newItemCost;
	}
}
