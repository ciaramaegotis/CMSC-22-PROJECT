class Zombie{
	String normalZombie = "Normal Zombie";
	String coneZombie = "Cone Zombie";
	String flagZombie = "Flag Zombie";
	String kindofZombie;
	int lifePoints;
	int damagePoints;

	public Zombie(String kind){
		this.kindofZombie = kind;
		this.lifePoints = 100;
		this.damagePoints = 5;
	}

	public void eatPlant(Plants plant){
		plant.attackedPlant(this.damagePoints);
	}

	public void eatPlayer(Player player){
		player.setLife();
	}
}