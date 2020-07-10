package rent.cars.domain;

import java.time.LocalDate;

public class RentRecord {

	private long licenseID;
	private String regNumber;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int gasTankPercent;
	private int rentDays;
	private double cost;
	private int damages;
	
	public RentRecord() {
	}

	public RentRecord(long licenseID, String regNumber, LocalDate rentDate, LocalDate returnDate) {
		this.licenseID = licenseID;
		this.regNumber = regNumber;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getGasTankPercent() {
		return gasTankPercent;
	}

	public void setGasTankPercent(int gasTankPercent) {
		this.gasTankPercent = gasTankPercent;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDamages() {
		return damages;
	}

	public void setDamages(int damages) {
		this.damages = damages;
	}

	public long getLicenseID() {
		return licenseID;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public int getRentDays() {
		return rentDays;
	}

	@Override
	public String toString() {
		return "RentRecord [licenseID=" + licenseID + ", regNumber=" + regNumber + ", rentDate=" + rentDate
				+ ", returnDate=" + returnDate + ", gasTankPercent=" + gasTankPercent + ", rentDays=" + rentDays
				+ ", cost=" + cost + ", damages=" + damages + "]";
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
		RentRecord other = (RentRecord) obj;
		if (licenseID != other.licenseID)
			return false;
		return true;
	}
	
	
	
	
	
	
}
