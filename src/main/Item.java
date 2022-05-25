package main;
public interface Item {
    /**
     * gets item's name
     * @return String item's name
     */
    String getItemName();
    /**
     * gets item's increase percentage
     * @return double item's increase percentage
     */
    double getItemIncrease();
    /**
     * gets item's cost
     * @return int item's cost
     */
    int getItemCost();
    
    /**
     * sets item's name
     * @param itemName String item's new name
     */
    void setItemName(String newItemName);
    /**
     * sets item's increase percentage
     * @param newItemIncrease Double item's new increase percentage
     */
    void setItemIncrease(double newItemIncrease);
    /**
     * sets item's cost
     * @param newItemCost int item's cost
     */
    void setItemCost(int newItemCost);
    /**
     * Applys this item to a given monster
     * @param monster Monster specific monster that this item is getting applied to.
     */
    void applyItem(Monster monster);
}
