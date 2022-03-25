import java.util.ArrayList;

/**
 * 
 */

/**
 * @author s5349
 *
 */
public class Interpreter {
	private ArrayList<String> predicates = new ArrayList<String>();
	private String[] dataExpresion;
	private ArrayList<String> symbols = new ArrayList<String>();
	
	/**
	 * 
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
	}
	
	/**
	 * 
	 * @param expresion
	 */
	public void Operator(String expresion) {	
		dataExpresion = expresion.split(" ");
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
			}else {
				continue;
			}
			
		}
		
	}
	
}

