package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.HealthItem;

class HealthItemTest {

	public HealthItem itemTest = new HealthItem("test", 100, 50);
	
	@Test
	public void getNameTest() {
		assertEquals("test", itemTest.getItemName());
	}
	
	@Test
	public void setNameTest() {
		itemTest.setItemName("new name");
		assertEquals("new name", itemTest.getItemName());
	}
	
	@Test
	public void getItemIncreaseTest() {
		assertEquals(100, itemTest.getItemIncrease());
	}
	
	@Test
	public void setItemIncreaseTest() {
		itemTest.setItemIncrease(12);
		assertEquals(12, itemTest.getItemIncrease());
	}
	
	@Test
	public void getItemCostTest() {
		assertEquals(50, itemTest.getItemCost());
	}
	
	@Test
	public void setItemCostTest() {
		itemTest.setItemCost(5);
		assertEquals(5, itemTest.getItemCost());
	}

}
