package test;

import static org.junit.jupiter.api.Assertions.*;
import main.Monster;
import org.junit.jupiter.api.Test;

class MonsterTest {

	
	public Monster MonsterTest = new Monster("test",10,5,0.1,100);
	
	@Test
	public void nameTest() {
		assertEquals("test", MonsterTest.getName());
	}
	
	@Test
	public void damageTest() {
		assertEquals(5, MonsterTest.getDamage());
	}
	
	@Test
	public void currHealthTest() {
		assertEquals(10, MonsterTest.getMonsterCurrentHealth());
	}
	
	@Test
	public void maxHealthTest() {
		assertEquals(10, MonsterTest.getMonsterMaxHealth());
	}
	
	@Test
	public void criticalStrikeTest() {
		assertEquals(0.1, MonsterTest.getCriticalStrike());
	}
	
	@Test
	public void levelUpTest() {
		MonsterTest.levelUp();
		assertEquals(1,MonsterTest.getLevel());
		assertEquals(20,MonsterTest.getMonsterCurrentHealth());
		assertEquals(20,MonsterTest.getMonsterMaxHealth());
		assertEquals(15,MonsterTest.getDamage());
		assertTrue(MonsterTest.getHasLeveledUp());
	}

}
