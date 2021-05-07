package story;

class Tortoise extends Thread{

	public void run() {
		for(int distance = 1; distance <= 100; distance++) {
			System.out.println("Tortoise ran "+distance+" distance.");
			
			if(distance == 100) {
				System.out.println("------Tortoise wins the race!!!------");
			}
		}
	}
}

class Hare extends Thread {
	
	public void run() {
		for(int distance = 1; distance <= 100; distance++) {
			System.out.println("Hare ran "+distance+" distance.");
			
			if(distance == 50) {
				try {
					System.out.println("------Hare goes to sleep.------");
					Thread.sleep(3000);
					System.out.println("------Hare started the race again.------");
				}
				catch(InterruptedException e) {
				}
			}
		}
		System.out.println("------Hare finished the race!!!------");
	}
}

public class Race{
	
	public static void main(String[] args) {
		
		Tortoise tortoise = new Tortoise();
		Hare hare = new Hare();
		
		tortoise.start();
		hare.start();
		System.out.println("------Race Started------");
	}
}


