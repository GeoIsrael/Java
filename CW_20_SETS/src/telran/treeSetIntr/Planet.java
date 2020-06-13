package telran.treeSetIntr;

public class Planet implements Comparable<Planet>{                 //класс имплементирует компарабл
	private String name;
	private long size;
	private int timeToEarth;
	public Planet(String name, long size, int timeToEarth) {
		super();
		this.name = name;
		this.size = size;
		this.timeToEarth = timeToEarth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public int getTimeToEarth() {
		return timeToEarth;
	}
	public void setTimeToEarth(int timeToEarth) {
		this.timeToEarth = timeToEarth;
	}
	@Override
	public String toString() {
		return "  "+ name+ "    " +  size + " \t" +  timeToEarth;
	}
	@Override
	public int compareTo(Planet o) {
		
		return this.timeToEarth-o.timeToEarth;
	}
		
	
}
