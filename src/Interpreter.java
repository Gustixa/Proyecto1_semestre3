import java.util.Stack;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * @author MAAG
 *
 */
public class Interpreter {

	private HashMap<String, Integer> myVars;
	
	/**
	 * 
	 */
	public Interpreter() {
		myVars = new HashMap<String, Integer>();
	}
	
	/**
	 * 
	 * @param expresion
	 * @return
	 */
	public IOperationResult Operate(String expresion) {
		int state = SintaxScanner.getState(expresion);
		
		switch(state) {
			case 1:{
				return variableAssigment(expresion);
			}
			case 2:{
				return Operations(expresion, "suma");
			}
			case 3:{
				return Operations(expresion, "resta");
			}
			case 4:{
				return Operations(expresion, "multiplicacion");
			}
			case 5:{
				return Operations(expresion, "division");
			}
			case 6:{
				return booleanOperations(expresion);
			}
			case 7:{
				
			}case 8:{
				
			}case 9:{
				
			}
			default:{		
				//Using anonymous Inner class
				IOperationResult errorResult = new IOperationResult() {
	
					
					@Override
					public void performOperation() {
						System.out.println("ERROR: Invalid expression");
						
					}
	
					@Override
					public void addResults(String key, String result) {
						// TODO Auto-generated method stub
					}
					@Override
					public void booleanOperation(boolean comparison) {
						
					}
					
				};
				return errorResult;
			}
		}
	}
	
	/**
	 * 
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
			@Override
			public void booleanOperation(boolean comparison) {
				
			}
				
		};

		assigmentResult.addResults(varName, varValue.toString());
		
	    return assigmentResult;  
	    
	}
	
	/**
	 * 
	 * @param expresion
	 * @return
	 */
	private IOperationResult Operations(String expresion, String typeOperation) {
		Pattern pattern = Pattern.compile("([a-z]+|[0-9]+)", Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    Integer total = 0;
	    if(matcher.find()) {
	    	total =Integer.parseInt(matcher.group().trim());
	    }
	    while (matcher.find()) {
	    	if(typeOperation.equals("suma")) {
	    		total += Integer.parseInt(matcher.group().trim());
	    		System.out.println(total);
	    	}else if(typeOperation.equals("resta")) {
	    		System.out.println(Integer.parseInt(matcher.group().trim()));
	    		total -= Integer.parseInt(matcher.group().trim());
	    	}else if(typeOperation.equals("multiplicacion")) {
	    		System.out.println(Integer.parseInt(matcher.group().trim()));
	    		total *= Integer.parseInt(matcher.group().trim());
	    		System.out.println(total);
	    	}else if(typeOperation.equals("division")) {
	    		try {
	    			total /= Integer.parseInt(matcher.group().trim());	
	    		}catch(ArithmeticException e) {
	    			System.out.println("NO SE PUEDE DIVIDIR ENTRE 0.");
	    		}		
	    	}	
	    }
	    AritmethicOperationResult miResult = new AritmethicOperationResult();
	    miResult.addResults(typeOperation, "" + total);
	    miResult.SeparatingData(expresion);
	    return miResult;
	}
	
	/**
	 * 
	 * @param expresion
	 * @return
	 */
	private IOperationResult booleanOperations(String expresion) {
		Pattern pattern = Pattern.compile("([a-z]|[0-9])" , Pattern.CASE_INSENSITIVE); //
	    Matcher matcher = pattern.matcher(expresion);
	    booleanOperationResult result = new booleanOperationResult();
		result.booleanOperation(matcher.find());
	    return result;
		
	}
}
