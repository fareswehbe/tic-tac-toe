import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int playerPlay, computerPlay, index = 0;
		boolean playerCheck, computerCheck;
		char[][] gameboard = { {' ', '|', ' ', '|', ' '},
							   {'-', '+', '-', '+', '-'},
							   {' ', '|', ' ', '|', ' '},
							   {'-', '+', '-', '+', '-'},
							   {' ', '|', ' ', '|', ' '} };
		int[] chosenPositions = new int[9];
		
		ArrayList<Integer> playerPositions = new ArrayList<>();
		ArrayList<Integer> computerPositions = new ArrayList<>();
		
		
		printGameboard(gameboard);
		while (index < 9) {
			do {
				playerCheck = false;
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter a valid position (1-9): ");
				playerPlay = scan.nextInt();
				for (int i : chosenPositions) {
					if (playerPlay == i) {
						playerCheck = true;
					}
				}
			} while (playerPlay < 1 || playerPlay > 9 || playerCheck == true);
			placePiece(gameboard, playerPlay, "human");
			playerPositions.add(playerPlay);
			chosenPositions[index] = playerPlay;
			index++;
			printGameboard(gameboard);
			
			do {
				computerCheck = false;
				Random rand = new Random();
				computerPlay = rand.nextInt(9) + 1;
				for (int i : chosenPositions) {
					if (computerPlay == i) {
						computerCheck = true;
					}
				}
			} while (computerCheck == true);
			placePiece(gameboard, computerPlay, "computer");
			computerPositions.add(computerPlay);
			chosenPositions[index] = computerPlay;
			index++;
			printGameboard(gameboard);
			
		}
		
	}
	
	public static void printGameboard(char[][] gameboard) {
		System.out.println();
		for (char[] row : gameboard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void placePiece(char[][] gameboard, int play, String user) {
		
		char symbol = 'X';
		
		if (user.equals("human")) {
			symbol = 'X';
		} 
		else if (user.equals("computer")) {
			symbol = 'O';
		}
		
		switch (play) {
		case 1:
			gameboard[0][0] = symbol;
			break;
		case 2:
			gameboard[0][2] = symbol;
			break;
		case 3:
			gameboard[0][4] = symbol;
			break;
		case 4:
			gameboard[2][0] = symbol;
			break;
		case 5:
			gameboard[2][2] = symbol;
			break;
		case 6:
			gameboard[2][4] = symbol;
			break;
		case 7:
			gameboard[4][0] = symbol;
			break;
		case 8:
			gameboard[4][2] = symbol;
			break;
		case 9:
			gameboard[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	
	public static String checkWinner(ArrayList<Integer> positions, String user) {
		
		return "";
	}
}
