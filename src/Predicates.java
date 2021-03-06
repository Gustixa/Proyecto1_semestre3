import java.util.Stack;

/**
 * This class simulate the Predicates functionality.
 * 
 * @author Samuel Argueta, Sebastian Tuch
 *
 */
public class Predicates {
    public static boolean result; //returns true or false, depending on the result

    /**
     * Constructor
     * @param predicate
     */
    public Predicates(String predicate) {
        result = result(predicate); //obtains the result from the result method
        
    }

    /**
     * Method used to get the result
     * @param predicate
     * @return true or false
     * @Pre Predicate expression must not be null
     */
    private boolean result(String predicate) {
    	Stack<String> typePredicate = new Stack<>(); //Stack used to store the predicate type
        Stack<String> predicates = new Stack<>(); //store the predicates
        
        
        boolean lista = false; //checks if it is a list or not
        String predicado = predicate.replace("(", " "); //Predicate
        predicado = predicado.replace(")", " ");

        //Verifier
        if (predicado.contains("'")) {
            predicado = predicado.replace("'", " ");
            lista = true;
        }

        String tipos[] = predicado.split(" "); //Divider

        // Verificar si el primer signo de lo que se quiera verificar sea uno de los predicado disponibles
        if (predicado.toLowerCase().contains("Atom") || predicado.toLowerCase().contains("Equal") || predicado.toLowerCase().contains("List")
                || predicado.toLowerCase().contains("<") || predicado.toLowerCase().contains(">") || predicado.toLowerCase().contains("=")) {
            typePredicate.push(tipos[1]);
        }

        // Ir metiendo los numeros o signos que hayan metido en el HashMap
        for (int i = 1; i < tipos.length; i++) {
            if (!tipos[i].equals("")) {
                predicates.push(tipos[i]);
            }
        }

        // Verificar si el tipo de predicado es atom, equal, list, <, > y luego hacer las comparaciones
        int numA;
        int numB;
        boolean result = true;

        try {
            if (predicates.get(1).equals("List") || predicates.get(2).equals("List")) {
                lista = true;
            }
        } catch (Exception e) {
            // if we only use (Atom number)
        }

        // Search the case for the value.
        switch (predicates.get(1)) {
            case "Atom":
                if (lista == true) {
                    result = false;
                } else {
                    result = true;
                }                
                return result;

            case "Equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                break;

            case "List":
                if (lista == true) {
                    result = true;
                } else {
                    result = false;
                }
                break;

            case "<":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA < numB) result = true;

                else {
                    result = false;
                }
                break;

            case ">":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA > numB) result = true;


                else {
                    result = false;
                }
                break;
            case "=":
            	numB = Integer.parseInt(predicates.pop());
            	numA = Integer.parseInt(predicates.pop());
            	if(numA == numB) result = true;
            	
            	else {
            		result = false;
            	}
        }

        switch (predicates.get(0)) {
            case "Atom":
                if (lista == true) {
                    result = false;
                } else {
                    result = true;
                }
                break;

            case "Equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                break;

            case "List":
                if (lista == true) {
                    result = true;
                } else {
                    result = false;
                }
                break;

            case "<":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA < numB) result = true;

                else {
                    result = false;
                }
                break;

            case ">":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA > numB) result = true;


                else {
                    result = false;
                }
                break;
            case "=":
            	numB = Integer.parseInt(predicates.pop());
            	numA = Integer.parseInt(predicates.pop());
            	if(numA == numB) result = true;
            	else {
            		result = false;
            	}
            	break;
        }
        return result;
    }
    
    
}
