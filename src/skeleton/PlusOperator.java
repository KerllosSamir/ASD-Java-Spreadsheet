package skeleton;

public class PlusOperator extends MathOperator {

	@Override
	double apply(double left, double right) {
		
		return left+right;
	}

	@Override
	String getName() {
		
		return "+";
	}

}
