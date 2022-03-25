import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class it's use to simulate the functionality of the interpreter.
 * 
 * @author Samuel Argueta
 *
 */
public class Interpreter {
	private ArrayList<String> predicates = new ArrayList<String>();
	private String[] dataExpresion;
	private ArrayList<String> symbols = new ArrayList<String>();
	private HashMap<String, Integer> myVars;
	
	/**
	 * This is the constructor, where all the arrays ara initializes.
	 */
	public Interpreter() {
		predicates.add("atom");
		predicates.add("list");
		predicates.add("equal");
		predicates.add("<");
		predicates.add(">");
		predicates.add("=");
		symbols.add("+");
		symbols.add("*");
		symbols.add("-");
		symbols.add("/");
		myVars = new HashMap<String, Integer>();
	}
	
	/**
	 * This method it use to do an operation by the input.
	 * @param expresion
	 */
	public void Operator(String expresion) {	
		dataExpresion = expresion.split(" ");
		String regex1 = "^[(][ ]*setq[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$";
		String regex2 = "^[(][ ]*setq[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$";
		
		if(evaluate(regex1, expresion)) {
			variableAssigment(expresion).performOperation();
		}else if(evaluate(regex2, expresion)){
			
		}else {
			for(int i = 0; i < dataExpresion.length; i++) {
				if (predicates.contains(dataExpresion[i])) {
					// If there is a predicate expresion, will do this. The position 1, it's because
					// in the array there ara "(, )"
					Predicates answer = new Predicates(expresion);
					String value = "";
					if(Predicates.result == true) {
						value = "T";
					}else {
						value = "NIL";
					}
					System.out.println(value);
					break;
				}else if(dataExpresion[i].equals("defun")) {
					// The position 1, it's because in the array there ara "(, )"
					String name = ""; //name of the function
					
		            if(dataExpresion[i+1].equals(" ")) {
		            	continue;
		            }else {
		            	name = dataExpresion[i+1];
		            	String[] parameters = new String[dataExpresion.length - (i+1)]; //Parameters
		            	for(int j = dataExpresion.length - (i+1); j < dataExpresion.length; i++) {
		            		parameters[i] = dataExpresion[j];
		            	}
		            	Functions.doFun(name, parameters); //EXECUTES THE FUNCION
		            	break;
		            }
				}else if(symbols.contains(dataExpresion[i])){
					ArithmeticOperations operations = new ArithmeticOperations(expresion);
					float result = operations.getOperation();
					//System.out.println(result);
				}else {
					continue;
				}
			}
		}
	}
	
	/**
	 * This method verify if the patron regex it's valid for an operation.
	 * @param regex
	 * @param expresion
	 * @return
	 */
	private boolean evaluate(String regex, String expresion) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(expresion);
	    return matcher.find();
	}
	
	/**
	 * This method assign a value to a variable using SETQ.
	 * @param expresion
	 * @return
	 */
	private IOperationResult variableAssigment(String expresion) {
		 Pattern pattern = Pattern.compile("[ ]+[a-z]+[ ]+", Pattern.CASE_INSENSITIVE); //
	     Matcher matcher = pattern.matcher(expresion);
	     String varName = "";
	     Integer varValue = 0;
	     if (matcher.find()) {
	         varName = matcher.group();
	     }
	     
	     pattern = Pattern.compile("[ ]+[0-9]+[ ]*", Pattern.CASE_INSENSITIVE); //
	     matcher = pattern.matcher(expresion);
	     if (matcher.find()) {
	    	 varValue = Integer.parseInt(matcher.group().trim());
	     }
	     
	     //Agrego la variable
	     myVars.put(varName, varValue);
	     
	     //Using anonymous Inner class
	     IOperationResult assigmentResult = new IOperationResult() {
			
			String key = "";
			String value = "";
			
			@Override
			public void performOperation() {
				System.out.println("Variable: " + key + " asignada con valor " + value);				
			}

			@Override
			public void addResults(String key, String result) {
				this.key = key;
				this.value = result;
			}
				
		};

		assigmentResult.addResults(varName, varValue.toString());
		
	    return assigmentResult;   
	}
	
}

