package telran.treeSetIntr;

import java.util.TreeSet;

public class Galaxy {
	private String name;
	private TreeSet<Planet> planets;
	
	public Galaxy(String name) {
		super();
		this.name = name;
		planets=new TreeSet<Planet>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPlanet(Planet p)
	{
		if(p==null)
		{
			System.out.println("arg is null");
			return;
		}
		planets.add(p);
	}
	
	public void removePlanet(Planet p)
	{
		if(p==null)
		{
			System.out.println("arg is null");
			return;
		}
		planets.remove(p);
	}
	
	public void displayGalaxy()
	{
		System.out.println("Name : " +  name);
		System.out.println("Total planets : " + planets.size());
		System.out.println("*****************************************************************");
		System.out.println("No. 	|Name  |Size   |Time To Earth     ");
		System.out.println("*****************************************************************");
		int count = 1;
		for(Planet planet : planets)
		{
			System.out.print(count + "\t");
			System.out.println(planet);
			count++;
		}
		System.out.println("*****************************************************************");
	}

}
