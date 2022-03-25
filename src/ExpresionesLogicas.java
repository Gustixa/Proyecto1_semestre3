import java.util.Stack;
/**
 * Esta clase nos permite evaluar las expresiones logicas del programa
 * @author Sebastian Estrada
 * @version 0.1
 */
class ExpresionesLogicas{

    private Stack<String> tipo = new Stack<String>(); // Guarda el tipo de expresion logica
    private Stack<String> expresiones = new Stack<String>(); // Guarda las expresiones logicas del enunciado

    public static boolean res; // Se retornara indicando el booleano obtenido del enunciado

    /**
     * Este es el metodo constructor que como parametro requerira el enunciado
     * @param pre
     */
    public ExpresionesLogicas(String pre){
        res = Resultado(pre);
    }

    /**
     * Este metodo es en donde se obtendran los resultados de las expresiones logicas
     * @param pre Es un String en donde se encuentra el enunciado
     * @return retornara un booleano como el resultado de la expresion
     */
    private boolean Resultado(String pre){
        boolean lst = false; // Servira para identificar las listas
        String expresion = pre.replace(")", " "); // En nuestra expresion remplazara los ) por espacion

        // Si la expresion contiene ' tambien los remplazara por espacios 
        if (expresion.contains("'")){
            expresion = expresion.replace("'", " ");
            lst = true;
        }
        // Ya habiendo generado nuestros espacios se generara una lista separando nuestros espacios
        String tipos[] = expresion.split(" ");
        // Se verifica el tipo de expresion
        if (expresion.toLowerCase().contains("Atom") || expresion.toLowerCase().contains("Equal") || expresion.toLowerCase().contains("List") || expresion.toLowerCase().contains("<") || expresion.toLowerCase().contains(">")){
            tipo.push(tipos[1]);
        }

        // Se ingresa al Stack los numeros o signos
        for ( int i = 1; i<tipos.length ; i++){
            if (!tipos[i].equals("")) {
                expresiones.push(tipos[i]);
            }
        }

        // Se crean las variables relevantes para obtener un resultado
        int num;
        int num1;
        boolean result = true;

        try {
            if ( expresiones.get(1).equals("List") || expresiones.get(2).equals("List")){
                lst = true;
            }
        } catch (Exception e) {
            //System.out.println("Ha ocurrido un error, el mensaje es el siguiente: "+e.getMessage());
        }
        // Dependiendo del tipo de expresion logica se genera un resultado
        switch (expresiones.get(1)) {
            case "Atom":
                if (lst == true){
                    result = false;
                }else {
                    result = true;
                }
                break;
                
            case "Equal":
                num = Integer.parseInt(expresiones.pop());
                num1 = Integer.parseInt(expresiones.pop());

                if (num1 == num){
                    result = true;
                }else{
                    result = false;
                }
                break;
            case "List":
                if ( lst == true){
                    result = true;
                }else{
                    result = false;
                }
                break;
            case "<":
                num = Integer.parseInt(expresiones.pop());
                num1 = Integer.parseInt(expresiones.pop());

                if ( num1<num){
                    result = true; 
                }else {
                    result = false;
                }
                break;
            case ">":
                num = Integer.parseInt(expresiones.pop());
                num1 = Integer.parseInt(expresiones.pop());

                if (num1>num){
                    result = true;
                }else{
                    result = false;
                }
                break;
            default:
                break;
        }
        return result;
    }
}