import java.util.ArrayList;

/**
 * This class simulate a functionality of the quote word.
 */
public class Quote {

	/**
	 * Constructor of the class.
	 * @param expresion
	 */
	public Quote(String expresion) {
		String values = expresion.replace("(", " "); //Predicate
        values = values.replace(")", " ");
        String[] data = values.split(" ");
        
        ArrayList<String> words = new ArrayList<String>();
        extractData(words, data);
	}
	
	/**
	 * This method return the value of the quote operation
	 * 
	 * @param words: ArrayLista<String>, values of the expresion without spaces.
	 * @param data: String[], values of the operations with spaces.
	 */
	private void extractData(ArrayList<String> words, String[] data) {
		for(int i = 0; i < data.length; i++) {
			if(data[i].equals(" ")) {
				continue;
			}else {
				words.add(data[i]);
			}
		}
		String[] values = new String[words.size() - 1];
		for(int i = 0; i < words.size(); i++) {
			if(words.contains("quote")) {
				continue;
			}else {
				values[i] = words.get(i);
			}
		}
		String answer = values.toString();
		System.out.println(answer);
	}
}
