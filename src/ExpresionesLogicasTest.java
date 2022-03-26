import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpresionesLogicasTest {


  

    @Test
    void igualQue(){
      
        String enun = "(Equal 11 11)";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.res;
        assertEquals(true, resultado);
      
    }
  
    @Test
    void listas(){
      
        String enun = "(List (List 6 9 2))";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.res;
        assertEquals(true, resultado);
      
    }
  
    @Test
    void menorQue(){
      
        String enun = "(< 5 10)";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.res;
        assertEquals(true, resultado);
     
    }

    @Test
    void mayorQue(){
      
        String enun = "(> 50 9)";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.res;
        assertEquals(true, resultado);
      
    }

    /**  @Test
    void atomos(){
      
        String enun = "(Atom '(1))";
        ExpresionesLogicas expLog = new ExpresionesLogicas(enun);
        boolean resultado = expLog.res;
        assertEquals(false, resultado);
      
    }**/
  
}
