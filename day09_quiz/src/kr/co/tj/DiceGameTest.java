package kr.co.tj;

import java.util.Scanner;

class DiceGame{
	private int diceFace;
	private int userGuess;
	
	DiceGame() {
		
	}
	private void RollDice() {
		diceFace = (int)(Math.random()*6)+1;
	}
	private int getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	private void checkUserGuess() {
		if(diceFace == userGuess) {
			System.out.println("맞았습니다.");
		}else {
			System.out.println("틀렸습니다.");
		}
	}
	public void startPlaying() {
		this.userGuess = getUserInput("예상값을 입력하시오:");
		RollDice();
		checkUserGuess();
	}
	
}

public class DiceGameTest {

	public static void main(String[] args) {
		DiceGame game = new DiceGame();
		game.startPlaying();
	}

}
