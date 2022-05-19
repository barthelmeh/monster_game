import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	
	private MainGame manager;
	private ArrayList<Monster> playerTeam;
	private String monsterLeave;

	public RandomEvent(MainGame incomingManager) {
		manager = incomingManager;
		playerTeam = manager.getPlayer().getTeam();
		randomEvents();
	}

	public String getMonsterLeave() {
		return monsterLeave;
	}
	private void randomEvents() {
		Random rand = new Random();
		int index = 0;
		for (Monster monster : playerTeam) {
			int randomNumber = rand.nextInt(1,7);
			if (randomNumber == 6) {
				playerTeam.remove(index);
				monsterLeave = monster.getName() + "has left";
				break;
			} else if (randomNumber >=2 && randomNumber <= 4) {
				monster.levelUp();
			}
			index++;
		}
	}
}
