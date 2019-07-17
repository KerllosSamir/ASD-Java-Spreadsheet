package skeleton;

public class MultiplyOperator extends MathOperator {

	@Override
	double apply(double left, double right) {

		return left * right;
	}

	@Override
	String getName() {
		
		return "*";
	}

}
