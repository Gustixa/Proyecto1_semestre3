

/**
 * 
 */

/**
 * @author s5349
 *
 */
public class booleanOperationResult implements IOperationResult {
	
	String key;
	String result;
	
	@Override
	public void performOperation() {
		System.out.println(key);
	}

	@Override
	public void addResults(String key, String result) {
		this.key = key;
		this.result = result;
	}
	
	@Override
	public void booleanOperation(boolean matcher) {
		if(matcher) {
			System.out.println("T");
		}else {
			System.out.println("nil");
		}
	}
}
