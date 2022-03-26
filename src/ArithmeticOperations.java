import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * Esta clase nos ayudara a realizar las diversas operaciones aritmeticas que se pueden llevar a cabo
 * @author Sebastian Estrada
 * @version 0.1
 * 
 */
class ArithmeticOperations{

    private LinkedList<String> operaciones = new LinkedList<String>();// Aqui se encontraran las operaciones aritmeticas
    private String numero = ""; // Se guardara un numero de dos o mas digitos
    public float resultado; // Esta variable guarda un resultado de prueba

    /**
     * Este es el metodo constructor de las operaciones aritmeticas
     * @param funcion
     */
    public ArithmeticOperations(String funcion){
    	
        for (int i = 0; i<funcion.length(); i++){
            // Verifica si es un simbolo matematico
            if (funcion.charAt(i) == '+' || funcion.charAt(i) == '-' || funcion.charAt(i) == '*' || funcion.charAt(i) == '/'){ 
                operaciones.addFirst(String.valueOf(funcion.charAt(i)));
            // Verifica si es un numero  
            }else if(Character.isDigit(funcion.charAt(i))){
                // Verifica si es decimal
                if  (funcion.charAt(i+1) == '.'){
                    numero += Character.toString(funcion.charAt(i)) + Character.toString(funcion.charAt(i+1)) +  Character.toString(funcion.charAt(i+2));
                    i += 3;
                }

                // mientras sea digito pasa a la siguiente posicion de mi funcion
                while (Character.isDigit((funcion.charAt(i)))) {
                    numero += funcion.charAt(i);
                    i++;
                }

                operaciones.addFirst(numero);// Aqui se guarda las sub operaciones
                numero = ""; // Se establece el valor de numero
                
            }
            //Si identifica un parentesis cerrado resolvera una operacion y la resolvera
            if (funcion.charAt(i) == ')'){
                getOperation();
            }
        }
    }

    /**
     * Este es el metodo que nos permite obtener un resultado de las operaciones
     * @return un float
     */
    public float getOperation(){
    	float res = 0; // Guarda el resultado final
        try {
            LinkedList<String> operacionOrdenadas = new LinkedList<String>(); // Aqui se guardara las operaciones en orden
            String operador; // Guarda el operador que nos indica que operacion se va a realizar

            // Mientras se ingresen numeros se agregaran de primero en las operaciones ordenadas
            while (!operaciones.peekFirst().equals("+") && !operaciones.peekFirst().equals("-") && !operaciones.peekFirst().equals("*") && !operaciones.peekFirst().equals("/")){
                operacionOrdenadas.addFirst(operaciones.removeFirst());
            }

            operador = operaciones.removeFirst(); // Recoje el operador
            // Se establece un resultado previo antes de operar que en este caso es el numero previo a la operacion
            res = Float.parseFloat(String.valueOf(operacionOrdenadas.removeFirst())); 

            // mientras en operaciones ordenadas haya operaciones a realizar se realizar las operaciones dependiendo del operador
            while (operacionOrdenadas.size() > 0){
                switch (operador) {
                    case "+":
                        res += Float.parseFloat(operacionOrdenadas.removeFirst());   

                        break;
                    case "-":
                        res -= Float.parseFloat(operacionOrdenadas.removeFirst());  

                        break;
                    case "*":
                        res *= Float.parseFloat(operacionOrdenadas.removeFirst());

                        break;
                    case "/":
                    	try {
                    		res /= Float.parseFloat(operacionOrdenadas.removeFirst());	
                    	}catch(ArithmeticException e) {
                    		System.out.println("NO SE PUEDE DIVIDIR POR 0");
                    	}
                        break;
                    default:
                        break;
                }
            }
            operaciones.addFirst(String.valueOf(res)); // Se agrega a las operaciones nuestro resultado

            if ( operaciones.size() == 1){
                //System.out.println(res);
                this.resultado = res;
                return res;
            }
        } catch (Exception e) {
            System.err.println();
        }

        return this.resultado;
    }
}