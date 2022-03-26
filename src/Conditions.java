import java.util.ArrayList;

/**
 * This class simulate the functionality of a conditional.
 * 
 * @author Samuel Argueta
 * @since 1.0
 * @version 1.0
 *
 */
public class Conditions {
	
	/**
	 * This methos it's the constructor of the class. 
	 * @param expresion
	 */
	public Conditions(String expresion) {
		String values = expresion.replace("(", " "); //Predicate
        values = values.replace(")", " ");
        String[] data = values.split(" ");
        float resultOperation = 0.0f;
        ArrayList<String> words = new ArrayList<String>();
        boolean result = orderingData(words,data);
        if(result) {
        	resultOperation = Operate(result, words, data);	
        }
        
        System.out.println(resultOperation);
	}
	
	/**
	 * This method helps to use a contidional with operations.
	 * 
	 * @param result: boolean
	 * @param words: ArrayList<String>
	 * @param data: String[]
	 * 
	 * @return
	 */
	private float Operate(boolean result, ArrayList<String> words, String[] data) {
		float OperationResult = 0.0f;
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i).contains("+") || words.get(i).contains("-") || words.get(i).contains("*") || words.get(i).contains("/") ) {
				String values = data.toString();
				ArithmeticOperations operation = new ArithmeticOperations(values);
				OperationResult = operation.getOperation();
				
			}else {
				continue;
			}
		}
		return OperationResult;
	}
	
	/**
	 * This class it use to get a boolean value, for example, if the condition has a value like
	 * ( < 5 8 ) the answer must to be true (T in LISP language)
	 * 
	 * @param words: ArrayList<String>, values of the expresion without an space.
	 * @param data: String[], values of the expresion with spaces.
	 * @return Predicates.result: boolean, a true or false value.
	 */
	private boolean orderingData(ArrayList<String> words, String[] data) {
		for(int i = 0; i < data.length; i++) {
			if(data[i].equals(" ")) {
				continue;
			}else {
				words.add(data[i]);
			}
		}
		String predicate = data.toString();
		Predicates predicates = new Predicates(predicate);
		return Predicates.result;
	}
	
	
}
