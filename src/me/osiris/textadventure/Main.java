package me.osiris.textadventure;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		// System Objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		// Game Variables
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Minecraft Steve????" };
		int maxEnemyHealth = 75;
		int enemyAttackDmg = 25;
		
		// Player Variables
		int health = 100;
		int attackDmg = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmt = 30;
		int healthPotionDropChance = 50; // Percentage
		
		boolean running = true;
		
		System.out.println("Welcome to Osiris' Text Adventure!");
		
		GAME:
		while(running) {
			System.out.println("-----------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# A wild " + enemy + " has appeared! #\n");
			
			while (enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Flee!");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDmg);
					int damageTaken = rand.nextInt(enemyAttackDmg);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
					
					if (health < 1) {
						System.out.println("\t> You have taken too much damage! You are too weak to go on!");
						break;
					}
				}
				else if (input.equals("2")) {
					if(numHealthPotions > 0) {
						health += healthPotionHealAmt;
						numHealthPotions--;
						System.out.println("\t> You drank a health potion, healing yourself for " + healthPotionHealAmt
										+ "\n\t> You now have " + health + " HP."
										+ "\n\t> You have " + numHealthPotions + " health potions left!\n");
					}
					else {
						System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get some!");
					}
				}
				else if (input.equals("3")) {
					System.out.println("\tYou run away from the " + enemy + "!");
					continue GAME;
				}
				else {
					System.out.println("\tInvalid Response!");
				}
			}
			
			if(health < 1) {
				System.out.println("You limp out of the dungeon, weak from battle.");
				break;
			}
			
			System.out.println("-----------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left!");
			if (rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The" + enemy + " dropped and health potion! # ");
				System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
			}
			System.out.println("-----------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue Fighting");
			System.out.println("2. Exit Dungeon");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Response!");
				input = in.nextLine();
			}
			
			if (input.equals("1")) {
				System.out.println("You continue on your adventure!");
			}
			else if(input.equals("2")) {
				System.out.println("You exit the dungeon, successful from your adventures!");
				break;
			}
			
		}
		
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");
		
	}

}
