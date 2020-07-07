package telran.cars.dao;

public abstract class AbstractRentCompany implements IRentCompany {
	protected int finePercent;
	protected int gasPrice;

	public AbstractRentCompany() {
		finePercent = 15;
		gasPrice = 10;
	}

	public int getFinePercent() {
		return finePercent;
	}

	public void setFinePercent(int finePercent) {
		this.finePercent = finePercent;
	}

	public int getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(int gasPrice) {
		this.gasPrice = gasPrice;
	}

}
