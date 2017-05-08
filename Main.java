import java.util.Scanner;
import java.util.ArrayList;

class Main{
	public static void main(String[] args){
		int choice = 4, playChoice = 0, plantChoice = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<Plants> playerPlants = new ArrayList<Plants>();

		do{
			System.out.print("[1] START GAME\n[2] LOAD GAME\n[0] EXIT\nChoice: ");
			choice = sc.nextInt();
			if (choice == 1){
				ArrayList<Mower> arrayMower = new ArrayList<Mower>();
				Player player = new Player("ciara", new Field(arrayMower));
				do{
					System.out.print("[1] ADD PLANT\n[2] PROCEED TO GAME\n[0] EXIT\nChoice: ");
					playChoice = sc.nextInt();
					if (playChoice == 1){
						System.out.println("CHOOSE PLANT");
						player.seePlants(player.level);
						if (player.level == 1){
							while (player.plants.size() != 2){
								System.out.print("Enter plant: ");
								plantChoice = sc.nextInt();
								if (plantChoice == 1){
									player.choosePlant(new Sunflower("Sunflower"));
								}else if (plantChoice == 2){
									player.choosePlant(new Peashooter("Peashooter"));
								}
								player.seePlants(player.level);
							}
						}else if (player.level == 2){
							while (player.plants.size() != 3){
								System.out.print("Enter plant: ");
								plantChoice = sc.nextInt();
								if (plantChoice == 1){
									player.choosePlant(new Sunflower("Sunflower"));
								}else if (plantChoice == 2){
									player.choosePlant(new Peashooter("Peashooter"));
								}else if (plantChoice == 3){
									player.choosePlant(new Potato("Potato"));
								}
								player.seePlants(player.level);
							}
						}
					}else if (playChoice == 2){
						if (player.plants.size() == 0){
							System.out.println("You cannot proceed to the game without any plant.");
						}else{
							//control panel
						}
					}else if (playChoice == 0){
						System.out.println("Back to the Main Menu.");
					}
				}while (playChoice != 0);
			}else if (choice == 2){
				//shall load the previous game
				System.out.println("Working progress.");
			}else if (choice == 0){
				System.out.println("Goodbye!");
				//save game
			}

		}while (choice != 0);
	}
}
