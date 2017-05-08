class ZombieGenerator{
	public void produceNormalZombie(){
		Zombie zombie = new Zombie("Normal Zombie");
		Thread zombieThread = new Thread(zombie);
		zombieThread.start();
	}

	public void produceConeZombie(){
		Zombie zombie = new Zombie("Cone Zombie");
		Thread zombieThread = new Thread(zombie);
		zombieThread.start();
	}

	public void produceFlagZombie(){
		Zombie zombie = new Zombie("Flag Zombie");
		Thread zombieThread = new Thread(zombie);
		zombieThread.start();
	}

}