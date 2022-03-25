import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpresionesLogicasTest {

      @Test
    void atomos(){
      
        String enun = "(Atom '(1))";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.resultado;
        assertEquals(false, resultado);
      
    }
  
  

    @Test
    void igualQue(){
      
        String enun = "(Equal 10 11)";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.resultado;
        assertEquals(false, resultado);
      
    }
  
    @Test
    void listas(){
      
        String enun = "(List (List 6 9 2))";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.resultado;
        assertEquals(false, resultado);
      
    }
  
    @Test
    void menorQue(){
      
        String enun = "(< 5 10)";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.resultado;
        assertEquals(true, resultado);
     
    }

    @Test
    void mayorQue(){
      
        String enun = "(> 50 9)";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.resultado;
        assertEquals(true, resultado);
      
    }


}
