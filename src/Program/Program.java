package Program;

import java.util.Scanner;

import entities.StandardHero;
import entities.Warrior;
import entities.Wizard;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StandardHero heroWar = null;
		StandardHero heroEnemy = new Wizard("Lord IA", 40, 40, 240);
		boolean sair = false;

		while (sair != true) {

			System.out.println("---------------------------------------");
			System.out.println("---------------GAMEHERO----------------");
			System.out.println("---------------------------------------");

			System.out.println("(1) Create a Heros   (2)Arena   (3)Exit");
			int answard = sc.nextInt();
			sc.nextLine();

			switch (answard) {
			case 1:
				System.out.println("Name:");
				String name = sc.nextLine();
				System.out.println("---Choose your class---");
				System.out.println("(1)Warrior    (2)Wizard");
				answard = sc.nextInt();
				switch (answard) {
				case 1:
					heroWar = new Warrior(name, 30, 50, 200);
					System.out.println("--Legends of your Hero--");
					System.out.println(heroWar);
					break;
				case 2:
					heroWar = new Wizard(name, 15, 60, 180);
					System.out.println("--Legends of your Hero--");
					System.out.println(heroWar);
					break;
				}
				break;
			case 2:
				if (heroWar == null) {
					System.out.println("You need to create a hero first!");
					break;
				}
				System.out.println("\n--------Starts Battle---------");
				int count = 1;

				while (heroWar.beAlive() && heroEnemy.beAlive()) {
					System.out.println("\n--- Round " + count + " ---");
					System.out.println(heroWar.getName() + " " + heroWar.getHP());
					System.out.println(heroEnemy.getName() + " " + heroEnemy.getHP());

					if (heroWar.getHP() <= 30) {
						heroWar.hability(heroEnemy);
					}
					if (heroEnemy.getHP() <= 30) {
						heroEnemy.hability(heroWar);
					} 
					
					heroWar.Attack(heroEnemy);

					if (heroEnemy.beAlive()) {
						heroEnemy.Attack(heroWar);
					}
					
					
					count++;
				}

				System.out.println("\n-----End of the battle-----");
				if (heroWar.beAlive()) {
					System.out.println("Vitory! " + heroWar.getName() + " won the battle!");
				} else {
					System.out.println("Deffeat! you were defeated by " + heroEnemy.getName() + "...");
				}
				break;
			case 3:
				System.out.println("Closing...");
				sair = true;
				break;
			default:
				System.out.println("Wrong number, try again!");
				break;
			}
		}
		sc.close();
	}
}
