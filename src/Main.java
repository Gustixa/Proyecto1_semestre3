import java.io.IOException;
import java.util.Scanner;



/**
 * 
 */

/**
 * @author Samuel Argueta
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interpreter lisp = new Interpreter();
		Scanner in = new Scanner(System.in);
		System.out.println("Bienvenido al interpreter Lisp ingrese una expresion o escriba exit para salir");
		String opt = "";
		
		do {
			opt = in.nextLine();
			if(!opt.equals("exit")) {
				lisp.Operator(opt);
			}
			
		}while(!opt.equals("exit"));
	}
}
