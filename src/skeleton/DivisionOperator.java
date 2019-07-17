package skeleton;

public class DivisionOperator extends MathOperator {

	@Override
	double apply(double left, double right) {

		return left / right;
	}

	@Override
	String getName() {
		
		return "/";
	}

}
