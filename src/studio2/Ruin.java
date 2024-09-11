package studio2;

import java.util.Scanner;

import java.util.Random;

public class Ruin {
 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		System.out.println("Start Amount: ");
		double startAmount = in.nextDouble();
		
		System.out.println("Win Chance: ");
		double winChance = in.nextDouble();
		
		System.out.println("Win Limit: ");
		double winLimit = in.nextDouble();
		
		System.out.println("Total Simulations: ");
		int sims = in.nextInt();
		
		int losses = 0;
		int wins = 0;
				
		
		for (int day = 1; day <= sims; day ++ ) {

			double randomValue = Math.random();
			
			if (randomValue < winChance) {
				
				startAmount ++;
				System.out.println("Day " + day + " Win! Amount = $" + startAmount);
				wins++;
				
			}
			
			if (randomValue > winChance) {
				
				startAmount --;
				System.out.println("Day " + day + " Ruin! Amount = $" + startAmount);
				losses++;
				
			}
			
			if (startAmount == winLimit) {
				
				System.out.println("Simulations: " + day);
				break;
				
			}
			
			if (startAmount == 0) {
				
				System.out.println("Simulations: " + day);
				break;
				
			}
		}
		
		System.out.println("Wins: " + wins + " Losses: " + losses);
		
		double ruinRate = losses / (losses + wins);
		double a = (1 - winChance)/(winChance);
		
		if (winChance == 0.5) {
			
			double expectedRuin = 1 - startAmount/winLimit;
			System.out.println("Expected Ruin: " + expectedRuin);
			}
			
			else {
				double expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, startAmount));
				System.out.println("Expected Ruin: " + expectedRuin);
		}
		

	
	}

}
