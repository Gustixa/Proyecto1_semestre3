import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author s5349
 *
 */
public class Parser {

    private static String functionName; //Function name
    private static String functionParameters; //Parameters of the function
    private static String functionBody; // Internatl functions
    private static LinkedList<String> parameters; //Stores the parameters
    private static LinkedList<String> tasks; //Stores the tasks

    /**
     * The parser, it dives the expression
     * @param function
     * @Pre Function must not be null
     */
    public static void parse(String function){
        functionName = "";
        functionParameters = "";
        functionBody = "";
        parameters =new LinkedList<>();
        tasks = new LinkedList<>();

        try {

            //Parser
            function = function.substring(function.indexOf(" ") + 1);
            
            //Take the name of the function.
            functionName = function.substring(0, (function.indexOf(" ")));
            
            function = function.substring(function.indexOf(" ") + 1);
            // Take de parameters of the function.
            functionParameters = function.substring(0, (function.indexOf(")") + 1));
            
            // Take the operations of the function.
            functionBody = function.trim().substring(function.indexOf("\n"));
            
            System.out.println("DEFUN " + functionName + " " + functionParameters + functionBody);

            // Extract and order the parameters.
            functionParameters = functionParameters.substring(1, functionParameters.indexOf(")"));
            System.out.println(functionParameters);
            String[] parametersArray = functionParameters.split(" ");
            String[] functionsArray = functionBody.split("\n");

            for (int i = 0; i < parametersArray.length; i++) {
                parameters.addLast(parametersArray[i]);
            }

            for (int i = 0; i < functionsArray.length; i++) {
                if (!functionsArray[i].equals("")) {
                    tasks.addLast(functionsArray[i]);
                }
            }

            //END OF PARSER

            Functions.defFun(new Defun(functionName, parameters, tasks)); //Defines and creates the function DEFUN
        }catch (Exception e){
            System.out.println("Error, check");
        }
    }
}
