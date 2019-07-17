package skeleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

	private SpreadSheet spreadSheet;
	private MathOperator MathOperator;

	public ExpressionParser(SpreadSheet spreadSheet) {
		this.spreadSheet = spreadSheet;
	}

	public double expressionValue(String expression) 
	{
		String cleanExpression = expression.replace(" ", "");
		// cleanExpression = "1+[1,1]*10-[1,1]+15/3";
		String re1 = "(\\[)"; // Any Single Character 1
		String re2 = "(\\d+)"; // Any Single Digit 1
		String re3 = "(,)"; // Any Single Character 2
		String re4 = "(\\d+)"; // Any Single Digit 2
		String re5 = "(\\])"; // Any Single Character 1

		Pattern pattern = Pattern.compile(re1 + re2 + re3 + re4 + re5, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(cleanExpression);

		while (matcher.find()) {
			String cellStr = matcher.group();
			Pattern rowPattern = Pattern.compile("(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher rowMatcher = rowPattern.matcher(cellStr);

			int cellRow = 0;
			int cellColumn = 0;

			if (rowMatcher.find()) {
				cellRow = Integer.parseInt(rowMatcher.group());
			}
			if (rowMatcher.find()) {
				cellColumn = Integer.parseInt(rowMatcher.group());
			}

			if (spreadSheet.getCell(cellRow, cellColumn) != null
					&& !(spreadSheet.getCell(cellRow, cellColumn) instanceof EmptyCell)) {
				String cellValue = spreadSheet.getCell(cellRow, cellColumn).getStringValue();
				cleanExpression = cleanExpression.replace(cellStr, cellValue);
			} else {
				cleanExpression = cleanExpression.replace(cellStr, "0");
			}

		}
		cleanExpression = evaluteMultiBraces(cleanExpression);

		return computeEquation(cleanExpression);
	}

	public boolean isNumber(String token) 
	{
		String regex = "\\d+";
		if (token.matches(regex)) 
		{
			return true;
		}
		return false;
	}
	
	public boolean isString(String token) 
	{
		
		String regex = "\".*\"";
		if (token.matches(regex)) 
		{
			return true;
		}
		return false;
	}
	
	private String evaluteMultiBraces(String cleanExpression) {

		int lastLeftBrace = cleanExpression.lastIndexOf('(');

		if (lastLeftBrace > -1) {
			String subEquation = cleanExpression.substring(lastLeftBrace);

			int firstRighttBrace = subEquation.indexOf(')');

			if (lastLeftBrace > -1 && firstRighttBrace > -1) {
				String bracesBlock = cleanExpression.substring(lastLeftBrace, firstRighttBrace + lastLeftBrace + 1);

				double computedValue = computeEquation(bracesBlock);
				cleanExpression = cleanExpression.replace(bracesBlock, Double.toString(computedValue));
				return evaluteMultiBraces(cleanExpression);
			}
		}

		return cleanExpression;
	}

	private double computeEquation(String equation) {
		MathOperator plus = new PlusOperator();
		MathOperator minus = new MinusOperator();
		MathOperator mul = new MultiplyOperator();
		MathOperator div = new DivisionOperator();

		double result = 0.0;
		equation = equation.replace("-0", "+0").replace("(", "").replace(")", "");

		String noMinus = equation.replace("-", "+-");
		String[] byPluses = noMinus.split("\\+");

		for (String multipl : byPluses) {
			String[] byMultipl = multipl.split("\\*");
			double multiplResult = 1.0;
			for (String operand : byMultipl) {
				if (operand.contains("/")) {
					String[] division = operand.split("\\/");
					double divident = Double.parseDouble(division[0]);
					for (int i = 1; i < division.length; i++) {
						divident = div.apply(divident, Double.parseDouble(division[i]));
						// divident /= Double.parseDouble(division[i]);
					}
					multiplResult = mul.apply(multiplResult, divident);
					// multiplResult *= divident;
				} else {
					multiplResult = mul.apply(multiplResult, Double.parseDouble(operand));
					// multiplResult *= Double.parseDouble(operand);
				}
			}
			result = plus.apply(result, multiplResult);
			// result += multiplResult;
		}

		return result;
	}
}
