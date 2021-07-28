import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class RestaSuma implements ActionListener{

    Calculadora ca;	

    String texto;
    static String signo;
    static double acumulador=0;

    public RestaSuma(Calculadora calcul){

        ca=calcul;


    }

    public boolean existePunto(String cadena){  //Metodo que comprueba si existe un punto en los caracteres introducidos
        boolean resultado=false;

        for(int i=0;i<cadena.length();i++){

            if(cadena.substring(i, i+1).equals(".")){
                resultado=true;
                break;
            }

        }
        return resultado;

    }


    public void signoMetodo(String signo){


        if(signo.equals("+")){

            texto=ca.campo.getText();

            acumulador=acumulador+Double.parseDouble(texto);
            
        }else if(signo.equals("-")){

            texto=ca.campo.getText();

            if(acumulador!=0){

                acumulador=acumulador-Double.parseDouble(texto);

            }else if(acumulador==0){
                double acumulador1=Double.parseDouble(texto);
                acumulador=acumulador1-acumulador*-1;

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        String comando=ev.getActionCommand();

        if(comando.equals("1")){

            ca.campo.setText(ca.campo.getText()+"1"); 
        }else if(comando.equals("2")){

            ca.campo.setText(ca.campo.getText()+"2");

        }else if(comando.equals("3")){

            ca.campo.setText(ca.campo.getText()+"3");

        }else if(comando.equals("4")){

            ca.campo.setText(ca.campo.getText()+"4");

        }else if(comando.equals("5")){

            ca.campo.setText(ca.campo.getText()+"5");

        }else if(comando.equals("6")){

            ca.campo.setText(ca.campo.getText()+"6");

        }else if(comando.equals("7")){

            ca.campo.setText(ca.campo.getText()+"7");

        }else if(comando.equals("8")){

            ca.campo.setText(ca.campo.getText()+"8");

        }else if(comando.equals("9")){

            ca.campo.setText(ca.campo.getText()+"9");

        }else if(comando.equals("0")){

            ca.campo.setText(ca.campo.getText()+"0");

        }else if(comando.equals("<==")){ //Aqui borro el ultimo caracter escrito

            String cadena=ca.campo.getText();

            if(cadena.length()>0){

                ca.campo.setText(cadena.substring(0,(cadena.length()-1)));//Con esto lo que hace
                //es escribir la cadena desde 0 hasta la longitud de la cadena-1, o sea
                //no escribe el ultimo valor, o sea aparentemente borra el ultimo valor

            }
			
			
        }else if(comando.equals(",")){

            if(ca.campo.getText().equals("")){

                ca.campo.setText("0.");

            }	else{
                if(!existePunto(ca.campo.getText())){
                    /*el metodo "existePunto" devuelve "true" en caso de existir un punto, si no existe
                     * entonces escribe el punto
                     */

                    ca.campo.setText(ca.campo.getText()+",");	

                }


            }

			
        }else if(comando.equals("C")){
            ca.campo.setText("");
            ca.campo1.setText("");
            acumulador=0;

        }
	
        if(comando.equals("+")){

            if(signo==null){

                signo="+"; //Esto del "signo" lo hago para así poder continuar sumando o restando a
                //una operación ya hecha...por ejemplo si he puesto "5-3"..y quisiera sumarle +4..
                //..o sea 5-3+4, al hacerlo de esta manera me funciona correctamente, si no lo hiciera así
                //entonces me daría un error

               

            }
            signoMetodo(signo);

            if(!ca.campo.getText().equals("")){  //Si hay algo escrito en el campo de texto "campo", entonces
                //escribe el acumulador en el "campo1" y borra "campo"...(el acumulador ya se ha calculado
                //con el metodo "signoMetodo(signo);")

                String text;
			
                text=Double.toString(acumulador);

                ca.campo.setText("");

                ca.campo1.setText(text);

                signo="+";
		
            }

        }else if(comando.equals("-")){
            if(signo==null){
                signo="-";
            }
            signoMetodo(signo);
            if(!ca.campo.getText().equals("")){
				
                String text;

                text=Double.toString(acumulador);
			
                ca.campo.setText("");
                ca.campo1.setText(text);
			
                signo="-";

			
				
            }

        }else if(comando.equals("=")){
            if(signo==null){
				
            }
            signoMetodo(signo);
            if(!ca.campo.getText().equals("")){
				
                String text;

                text=Double.toString(acumulador);
                ca.campo.setText("");
                ca.campo1.setText(text);
			
                acumulador=0;

            }
			
        }

	
    }
}
