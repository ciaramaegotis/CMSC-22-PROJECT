import java.util.ArrayList;
import java.util.Iterator;

class Player{
	String name;
	boolean isAlive;
	ArrayList<Plants> plants;
	Field field;
	int sunPoints;
	int level;

	public Player(String name, Field field){
		this.name = name;
		this.isAlive = true;
		this.plants = new ArrayList<Plants>();
		this.field = field;
		this.level = 1;
	}

	public void setLife(){
		this.isAlive = false;
	}

	public void choosePlant(Plants plant){
		int isThere = 0;
		Iterator<Plants> iter = (this.plants).iterator();
		while (iter.hasNext()){
			Plants newPlant = iter.next();
			if (plant.getNamePlant() == newPlant.getNamePlant()){
				isThere = 1;
			}
		}
		if (isThere == 0){
			this.plants.add(plant);
			System.out.println("Successfully added the plant");
		}else{
			System.out.println("Please choose another plant.");
		}
	}

	public void placePlant(Plants plant){
		this.field.placePlant(plant);
	}

	public void removePlant(Plants plant){
		this.field.removePlant(plant);
	}

	public void getSun(int gainSun){
		this.sunPoints += gainSun;
	}

	public void seePlants(int level){
		if (level == 1){
			System.out.println("[1]Sunflower\n[2]Peashooter\n>> ");
		}else if (level == 2){
			System.out.println("[1]Sunflower\n[2]Peashooter\n[3]Potato\n");
		}
	}

	public void levelUp(){
		this.level += 1;
	}

	public int getLevel(){
		return this.level;
	}

	public boolean isLife(){
		return this.isAlive;
	}
}