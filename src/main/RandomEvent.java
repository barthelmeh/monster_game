package main;
import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	
	private MainGame manager;
	private ArrayList<Monster> playerTeam;
	private String monsterLeave;
	private String monsterEnter;
	/**
	 * Class Constructor specify the Main Game running in the background
	 * @param incomingManager MainGame running in the background
	 */
	public RandomEvent(MainGame incomingManager) {
		manager = incomingManager;
		playerTeam = manager.getPlayer().getTeam();
		randomLeave();
		monsterEnter();
	}
	/**
	 * get Monster leave string
	 * @return String get if monster has left
	 */
	public String getMonsterLeave() {
		return monsterLeave;
	}
	/**
	 * get Monster enter string
	 * @return String get if monster has entered
	 */
	public String getMonsterEnter() {
		return monsterEnter;
	}
	/**
	 * generates random number between 1-20 if 1 then monster enters
	 */
	private void monsterEnter(){
		// Monster has joined the party over night
		ArrayList<Monster> avaiableMonsters = new ArrayList<Monster>(manager.getAllMonsters());
		Random rand = new Random();
		int randomNumber = rand.nextInt(1,21);
		if (randomNumber == 1 && playerTeam.size() < 4){
			int randomIndex = rand.nextInt(avaiableMonsters.size());
			try {
				Monster randomMonster = avaiableMonsters.get(randomIndex).clone();
				monsterEnter = randomMonster.getName() + " has joined your team";
				manager.getPlayer().addRandomMonster(randomMonster);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * generates random number between 1-6 if 6 then monster left else if number is 2-4 then that mosnter levels up
	 */
	private void randomLeave() {
		// Monster has left the party over night
		Random rand = new Random();
		int index = 0;
		for (Monster monster : playerTeam) {
			int randomNumber = rand.nextInt(1,7);
			if (randomNumber == 6 && playerTeam.size() > 1) {
				playerTeam.remove(index);
				monsterLeave = monster.getName() + " has left";
				break;
			} else if (randomNumber >=2 && randomNumber <= 4) {
				monster.levelUp();
			}
			index++;
		}
		
	}
}
