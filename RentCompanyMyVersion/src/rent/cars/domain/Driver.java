package rent.cars.domain;

public class Driver {

	private long licenseID;
	private String name;
	private int birthYear;
	private String phone;
	
	public Driver() {
	}

	public Driver(long licenseID, String name, int birthYear, String phone) {
		this.licenseID = licenseID;
		this.name = name;
		this.birthYear = birthYear;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getLicenseID() {
		return licenseID;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public String toString() {
		return "Driver [licenseID=" + licenseID + ", name=" + name + ", birthYear=" + birthYear + ", phone=" + phone
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (licenseID ^ (licenseID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (licenseID != other.licenseID)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
