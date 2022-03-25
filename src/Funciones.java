import java.util.ArrayList;
import java.util.Arrays;
//import java.lang.Character;
public class funcion {
  
  String code;
  String name;
  String parameterValue;
  String parameter;
  String[] data;
  String[] exp;
  
  public funcion(String k){
    code = k;
    ArrayList<String>data = new ArrayList<String>(); 
    for(int i=0; i<code.length() ; i++){
      String symbol = code.substring(i,i+1);
      int counter =0;
      if(symbol.equalsIgnoreCase(" "){
        
      }
      else{
        int nextNum=1;
        char c1=symbol.charAt(0);
        if(Character.isDigit(c1)||Character.isLetter(c1)||symbol.equals(".")){
          while(nextNum==1){
            int j=0;
            for(j=i+1; i<code.length() ; i++){
              String nextNext=code.substring(j,j+1);
              char c=nextNext.charAt(0);
              if(Character.isDigit(ch)||Character.isLetter(c)||nextNext.equals(".")){
								symbol = symbol + nextNext; 
								counter = counter + 1;
							}
              else{
                nextNum=0;
                j=code.length() +1;
              }
              data.add(symbol);
              i = i+counter;
              
            }
          }
          data=new String[data.size()];
          for (int j = 0; j < data.size(); j++) {  
			    datos[j] = data.get(j); 
		        }
          name = data[2];
          parameter = data[4];
          exp = new String[data.length-7];
          for(int i=6; i <data.length-1; i++){
			      exp[i-6] = data[i];
		      }
          int recursive =0;
          public String work(){
            recursive =0;
            for (int i = 0; i<exp.length; i++){
			        if(exp[i].equals(name)){
				        recursive = recursive +1;; 
			       }
            }
            if(recursive==0){
              for(int i=0; i<exp.length; i++){
				        if(exp[i].equals(parameter)){
					        exp[i] = parameterValue;
				          }
			           }
              String expS="";
              for(int i = 0; i<exp.length;i++){
			        	expS = expS + " "+ exp[i]; 
			        }
              
              //Aquí debería ir la parte donde llamamos a las defun y la aritmética y todo eso aaaaaaaaaaaaaaaaa
              //String de decisión
              //Placeholder para todo lo que falta ajsjaj
              
              
            }
        }
      }
    }
  }
  	public String getParameter(){
		return parameter;
	}
	public void setParameter(String v){
		parameterValue = v;
	}
	
	public String check(){
		work(); 
		return Arrays.toString(exp); 
	}
}
