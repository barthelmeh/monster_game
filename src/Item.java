public interface Item {
    String getItemName();
    double getItemIncrease();
    int getItemCost();

    void setItemName(String itemName);
    void setItemIncrease(double itemIncrease);
    void setItemCost(int itemCost );
    
    void applyItem(Monster monster);
}
