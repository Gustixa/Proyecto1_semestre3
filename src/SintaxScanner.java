

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MAAG
 * This class will scan the sintax of expresions
 */
public class SintaxScanner {

	/***
	 * This method return a integer number that identifies the type of the operation
	 * @param Expresion The expresion given by the user
	 * @return An integer greater than 0 that indicates the type of the operation, -1 if the expression is not valid
	 */
	public static int getState(String expresion){
		if (evaluate("^[(][ ]*setq[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",expresion)) {
			//This is a simple assignment using setq
			return 1;
		}else if (evaluate("^[(]*[ ]*[+][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
			//This is a simple add operation of 2 operands
			return 2;
		}else if (evaluate("^[(]*[ ]*[-][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
			// This is a simple rest operations of 2 numbers
			return 3;
		}else if(evaluate("^[(]*[ ]*[*][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
			// This is a simple times operations of 2 numbers
			return 4;
		}else if(evaluate("^[(]*[ ]*[/][ ]+([a-z]+|[0-9]+)[ ]+([a-z]+|[0-9]+)[ ]*[)]$",expresion)) {
			// This is a simple divide operations of 2 numbers.
			return 5;
		}else if(evaluate("^[(]*[ ]*atom[ ]+([a-z]+|[0-9]+)+[ ]*(|[0-9)?[)]$",expresion)) {
			//This evaluate the predicate atom
			return 6;
		}else if(evaluate("^[(]*[ ]*list[ ]+([a-z]+|[0-9]+)+[ ]*(|[0-9)?[)]$",expresion)) {
			// This evaluate the predicate list
			return 7;
		}else if(evaluate("^[(]*[ ]*equal[ ]+([a-z]+|[0-9]+)+[ ]*(|[0-9)?[)]$",expresion)){
			// This evaluate the predicate equal
			return 8;
		}else if(evaluate("^[(]*[ ]*[<>=]?[ ]+([a-z]+|[0-9]+)+[ ]*(|[0-9)?[)]$",expresion)){
			//This evaluate thre predicates "<, > ="
			return 9;
		}else {
			return -1; //if no match found then the expression is incorrect
		}
	}
	
	/***
	 * Private method which evaluate an expression
	 * @param regex the patter of the expresion
	 * @param expresion The expresion given by the user
	 * @return true if is a match, false otherwise
	 */
	private static boolean evaluate(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(expresion);
	    return matcher.find();
	}
}