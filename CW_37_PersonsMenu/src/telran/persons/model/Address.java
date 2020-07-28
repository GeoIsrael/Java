package telran.persons.model;

public class Address {
	String city;
	String street;
	int building;
	int aprt;

	public Address(String city, String street, int building, int aprt) {
		this.city = city;
		this.street = street;
		this.building = building;
		this.aprt = aprt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getAprt() {
		return aprt;
	}

	public void setAprt(int aprt) {
		this.aprt = aprt;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", building=" + building + ", aprt=" + aprt + "]";
	}

}
