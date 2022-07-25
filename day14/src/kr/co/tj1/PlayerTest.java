package kr.co.tj1;

public class PlayerTest {

	public static void main(String[] args) {
		Player p = new Player();
		p.upgradeLevel(new BeginnerLevel());
		p.play(1);
		p.upgradeLevel(new AdvancedLevel());
		p.play(2);
		p.upgradeLevel(new SuperLevel());
		p.play(3);
	}

}
