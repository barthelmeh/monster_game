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

	public String getMonsterLeave() {
		return monsterLeave;
	}
	public String getMonsterEnter() {
		return monsterEnter;
	}

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
