package telran.treeSetIntr;

public class TestPlanet {
	public static void main(String[] args) {
		Galaxy gal = new Galaxy("Galaxy Bananas");
		Planet p1 = new Planet("Manky", 12345, 132320000);
		Planet p2 = new Planet("Banan-11", 23456, 82200000);
		Planet p3 = new Planet("Buben-15", 33333, 1111000);
		Planet p4 = new Planet("G-1", 98765, 1180000);
		Planet p5 = new Planet("Mumu", 333444, 123456789);
		Planet p6 = new Planet("Mumu-2", 155600, 9876543);
		
		gal.addPlanet(p1);
		gal.addPlanet(p2);
		gal.addPlanet(p3);
		gal.addPlanet(p4);
		gal.addPlanet(p5);
		gal.addPlanet(p6);
		gal.displayGalaxy();
		gal.addPlanet(p6);
		gal.displayGalaxy();
				
	}

}
