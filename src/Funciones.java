import java.util.LinkedList;

public class Functions {
	
    private static LinkedList<Defun> listFunctions = new LinkedList<>(); 
    private static LinkedList<String> functionTimes; 
    private static boolean isCOND = true; 
    private static boolean ANS = true;

    public static void defineFuncs(Defun DEFUN) {
        listFunctions.add(DEFUN);
    }

    public static void existsFUN(String name, String[] parameters) {

        boolean E = false; //Cuantificador existencial
        int token = 0;
        for (int i = 0; i < listFunctions.size(); i++) {
            if (listFunctions.get(i).getName().equals(name)) {
                token = i;
                System.out.println("Sí existe la función.");
                E = true;
            }
        }
        if (E == false) {
            System.out.println("No existe la función.");
        } else {
            functionTimes = listFunctions.get(token).getNewfunctions(parameters); 
            Functions.isCOND = listFunctions.get(token).isCOND; 
            functionTimes(); 

        }
    }


    public static void functionTimes() {

        if (isCOND == true) {
            if(ANS == true){
                if (functionTimes.size() != 0) {
                	
                    String run = functionTimes.removeFirst();
                    
                    if (run.contains("+") || run.contains("-") || run.contains("*") || run.contains("/")) {
                    	
                        new ArithmeticOperations(run);
                        
                    } 
                    else if (run.contains("<") || run.contains(">") || run.contains("Equal") || run.contains("Atom") || run.contains("List")
                            || run.contains("=")) {
                    	
                        new Predicates(run);
                        ANS = Predicates.ANS;
                        
                    }
                    Functions.functionTimes();
                } 
                else {
                    return;
                }
            }
        } 
        else {
            if (functionTimes.size() != 0) {
            	
                String run = functionTimes.removeFirst();
                
                if (run.contains("+") || run.contains("-") || run.contains("*") || run.contains("/")) {
                	
                    new ArithmeticOperations(run); 
                
                } 
                else if (run.contains("<") || run.contains(">") || run.contains("Equal") || run.contains("Atom") || run.contains("List")
                        || run.contains("=")) {
                    
                	new Predicates(run); 
                    ANS = Predicates.ANS;
                
                }
                
                Functions.functionTimes(); 
            } 
            else {
                return;
            }
            
        }
    }
}

