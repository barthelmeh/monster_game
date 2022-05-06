public class item {
	private String itemName = null; 
    private int itemIncrease = 0;
    private int itemCost = 0;
    
    public item(String name, int increase , int cost){
		itemName = name;
		itemIncrease = increase;
		itemCost = cost;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemIncrease() {
		return itemIncrease;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemIncrease(int itemIncrease) {
		this.itemIncrease = itemIncrease;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

}
