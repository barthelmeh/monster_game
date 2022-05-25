package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Player;
import main.Monster;

class PlayerTest {
	
	@Test
	public void playerNameTest() {
		Player playerTest = new Player();
		playerTest.setPlayerName("test");
		assertEquals("test", playerTest.getPlayerName());
	}

	@Test
	public void addMoneyTest() {
		Player playerTest = new Player();
		playerTest.addMoney(10);
		assertEquals(20, playerTest.getCurrentMoney());
	}
	
	@Test
	public void decreaseMoneyTest() {
		Player playerTest = new Player();
		playerTest.decreaseMoney(5);
		assertEquals(5, playerTest.getCurrentMoney());
	}
	
	@Test
	public void scoreTest() {
		Player playerTest = new Player();
		playerTest.increaseScore(100);
		assertEquals(100, playerTest.getScore());
	}
	
	@Test 
	public void addMonsterTest() {
		Player playerTest = new Player();
		Monster monsterTest = new Monster("test", 100.0, 10.0, 0.5, 100);
		playerTest.addMonster(monsterTest);
		assertEquals(monsterTest, playerTest.getTeam().get(0));
	}
	
	@Test 
	public void removeMonsterTest() {
		Player playerTest = new Player();
		Monster monster1Test = new Monster("test", 100.0, 10.0, 0.5, 100);
		playerTest.addMonster(monster1Test);
		playerTest.releaseMonster(monster1Test);
		assertTrue(playerTest.getTeam().isEmpty());
	}
	
	
}
