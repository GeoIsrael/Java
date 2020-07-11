package telran.calculator.model;

public class Add implements IOperation {

	@Override
	public double action(double a, double b) {
		return a + b;
	}

}
