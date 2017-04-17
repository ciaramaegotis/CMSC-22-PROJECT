import java.util.Scanner;
import java.util.ArrayList;
class Main{
	public static void main(String[] args){
		int choice;
		int choicePlant;
		String name;
		int level1 = 2;
		int level2 = 3;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("[1]Start Game\n[2]See instructions\n[3]Credits\n[0]Exit\n>> ");
			choice = sc.nextInt();

			if (choice == 1){
				sc.nextLine();
				System.out.println("Enter your name: ");
				name = sc.nextLine();
				ArrayList<Mower> mowerray = new ArrayList<Mower>();
				mowerray.add(new Mower());
				mowerray.add(new Mower());
				mowerray.add(new Mower());
				mowerray.add(new Mower());
				mowerray.add(new Mower());
				Field field = new Field(mowerray);
				Player player = new Player(name, field);
				System.out.println("Hello " + name + "! Please choose your plant: ");
				player.seePlants(player.getLevel());
				for (int i = 0; i < ((player.getLevel()==1)? level1: level2) ; ++i){
					choicePlant = sc.nextInt();
					if (choicePlant == 1){

					}else if (choicePlant == 2){

					}else if (choicePlant == 3){
						
					}
				}
			}
		}while(choice != 0);
	}
}