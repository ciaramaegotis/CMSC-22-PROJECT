abstract class Plants implements Runnable{
	private String name;
	private int lifePoints;
	private static int plantID = 0;

	public Plants(String name){
		this.name = name;
		this.plantID += 1;
		Plants.plantID++;
	}

	void attackedPlant(int damage){
		this.lifePoints -= damage;
	}

	public String getNamePlant(){
		return this.name;
	}

	public int getLifePoints(){
		return this.lifePoints;
	}

	public int getPlantID(){
		return this.plantID;
	}

	public void setLifePoints(int life){
		this.lifePoints = life;
	}

	@Override
	public void run(){

	}

}