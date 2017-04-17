abstract class Plants{
	String name;
	int lifePoints;

	public Plants(String name){
		this.name = name;
	}

	void attackedPlant(int damage){
		this.lifePoints -= damage;
	}

}