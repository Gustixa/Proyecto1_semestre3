import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperacionesAritmeticasTest {

    @Test
    void suma(){
      
        String enun = "(+ 11 7)";
        OperacionesAritmeticas operacionAritmetica = new OperacionesAritmeticas((enun));
        float igual = operacionAritmetica.resultado;
        assertEquals(18, igual);

    }

    @Test
    void resta(){
      
        String enun = "(- 50 29)";
        OperacionesAritmeticas operacionAritmetica = new OperacionesAritmeticas((enun));
        float igual = operacionAritmetica.resultado;
        assertEquals(21, igual);

    }

    @Test
    void multiplicacion(){
      
        String enun = "(* 4 9)";
        OperacionesAritmeticas operacionAritmetica = new OperacionesAritmeticas((enun));
        float igual = operacionAritmetica.resultado;
        assertEquals(36, igual);

    }

    @Test
    void division(){
      
        String enun = "(/ 18 6)";
        OperacionesAritmeticas operacionAritmetica = new OperacionesAritmeticas((enun));
        float igual = operacionAritmetica.resultado;
        assertEquals(3, igual);

    }

    @Test
    void varias(){
      
        String enun = "(+ (/ 15 3) (- 9 5) 10)";
        OperacionesAritmeticas operacionAritmetica = new OperacionesAritmeticas((enun));
        float igual = operacionAritmetica.resultado;
        assertEquals(19, igual);

    }
}
