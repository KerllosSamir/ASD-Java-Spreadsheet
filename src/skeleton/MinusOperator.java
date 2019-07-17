package skeleton;

public class MinusOperator extends MathOperator {

	@Override
	double apply(double left, double right) {
		// TODO Auto-generated method stub
		return left-right;
	}

	@Override
	String getName() {

		return "-";
	}

}
