import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author rafae
 * Tokens de lisp
 */
public class Tokens {
	
	private static String[] token_list = { "+", "-", "*", "/", "=", "QUOTE", "DEFUN", "SETQ", "ATOM", "LIST", "EQUAL", "COND", "PARAM"};
	private static Tokens thisInstance = new Tokens(token_list);
    
	/**
	 * ArrayList.
	 */
	private ArrayList<String> token= new ArrayList<>();
  
    /**
     * HashMap.
     */
    private HashMap<String,Object[]> hMap;
    
    /**
     * Instancia.
     * @return
     */
    public static Tokens getInstance() {
        return thisInstance;
    }
    
    /**
     * Crea el listado de tokens.
     * @param tokenList
     */
    private Tokens(String[] tokenList) {
        token.addAll(Arrays.asList(tokenList));
        hMap = new HashMap<>();
    }
    
    /**
     * Devuelve el listado de tokens.
     * @return
     */
    public ArrayList<String> getTokens(){
        return token;
    }
    
    /**
     * Agrega un nuevo token.
     * @param newToken
     */
    public void addToken(String newToken){
        token.add(newToken.toLowerCase());
    }
    
    /**
     * Agrega una nueva función al HashMap.
     * @param token
     * @param function
     */
    public void addFunction(String token, Object[] function){
        hMap.put(token.toLowerCase(),function);
    }

    /**
     * Get para una función.
     * @param token
     * @return
     */
    public Object[] getFunction (String token){
        return hMap.get(token.toLowerCase());
    }
    
    /**
     * Verifica la existencia del token.
     * @param token
     * @return
     */
    public Boolean tokenExists(String token){
        if (token.contains(token.toLowerCase())) {
        	return true;
        }else {
        	return false;
        }
    }

    /**
     * Verifica la existencia de una función agregada por el usuario.
     * @param token
     * @return
     */
    public Boolean functionExists(String token){
        if (hMap.containsKey(token.toLowerCase())) {
        	return true;
        }else {
        	return false;
        }
    }

}
