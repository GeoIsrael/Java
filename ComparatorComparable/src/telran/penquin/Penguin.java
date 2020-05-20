package telran.penquin;

public class Penguin {
	private float weight;
	private int price;
	private String name;
	
	public Penguin(float weight, int price, String name) {
		this.weight = weight;
		this.price = price;
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Penguin [weight=" + weight + ", price=" + price + ", name=" + name + "]";
	}

	
	
	
	
	
}
