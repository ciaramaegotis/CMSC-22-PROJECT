class ZombieGenerator{
	public void produceNormalZombie(){									//shall produce a normal zombie and puts it in a thread and then runs
		Zombie zombie = new Zombie("Normal Zombie", 500, 150, 0);
		Thread zombieThread = new Thread(zombie);
		zombieThread.start();
	}

	public void produceConeZombie(){								//shall produce a cone zombie and puts it in a thread and then runs
		Zombie zombie = new Zombie("Cone Zombie", 500, 250, 1);
		Thread zombieThread = new Thread(zombie);
		zombieThread.start();
	}

	public void produceFlagZombie(){								//shall produce a flag zombie and puts it in a thread and then runs
		Zombie zombie = new Zombie("Flag Zombie", 500, 350, 2);
		Thread zombieThread = new Thread(zombie);
		zombieThread.start();
	}
}