import java.util.ArrayList;

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
		//check if nageexist na sa list yung plant (baka madouble)
		this.plants.add(plant);
	}

	public void placePlant(Plants plant){
		this.field.placePlant(plant);
	}

	public void removePlant(Plants plant){
		this.field.removePlant(plant);
	}

	public void getSun(int gainSun){
		//get Sun
		this.sunPoints += gainSun;
	}

	public void seePlants(int level){
		if (level == 1){
			System.out.println("[1]Sunflower\n[2]Peashooter\n>> ");
		}else if (level == 2){
			System.out.println("[1]Sunflower\n[2]Peashooter\n[3]Potato\n>> ");
		}
	}

	public void levelUp(){
		this.level += 1;
	}

	public int getLevel(){
		return this.level;
	}
}