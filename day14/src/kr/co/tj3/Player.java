package kr.co.tj3;

public class Player {
	PlayerLevel level;

	public PlayerLevel getLevel() {
		return level;
	}

	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
	}
	
	public void play(int count) {
		level.go(count);
	}
}
