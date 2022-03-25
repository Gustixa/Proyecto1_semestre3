import java.util.LinkedList;
import java.util.Stack;
/**
 * @author MAAG
 *
 */
public class AritmethicOperationResult implements IOperationResult {

	String key;
	String result;
	//StackNodes<String> operators = new StackNodes<String>();
	Stack<String> operators = new Stack<String>();
	LinkedList<String> posfix = new LinkedList<String>();
	
	@Override
	public void performOperation() {
		System.out.println("El resultado de la operacion " + key + " es: " + result);
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
    public int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    /**
     * 
     * @param expression
     * @return
     */
    public String infixToPostFix(String expression){

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            //check if char is operator
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor ( 
                result += c;
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        return result;
    }
    
	/**
	 * 
	 * @param expresion
	 */
	public void SeparatingData(String expresion) {
		char[] data = expresion.toCharArray(); 
	}
	
	@Override
	public void addResults(String key, String result) {
		this.key = key;
		this.result = result;
	}
	
	@Override
	public void booleanOperation(boolean comparison) {
		
	}
	
	
}
