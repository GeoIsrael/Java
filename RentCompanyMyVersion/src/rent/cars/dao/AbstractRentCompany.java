package rent.cars.dao;


public abstract class AbstractRentCompany implements IRentCompany {   //абстрактный класс, имплементирующий интерфейс
	protected int finePercent;
	protected int gasPrice;
	
	public AbstractRentCompany() {         //конструктор абстрактного класса
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
