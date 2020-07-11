package telran.calculator.model;

public class Pow implements IOperation {

	@Override
	public double action(double a, double b) {
		return Math.pow(a, b);
	}

}
