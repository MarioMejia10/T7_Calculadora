import javax.swing.*;

import java.awt.*;

public class Calculadora extends JFrame{

JPanel principal;	

JPanel arriba;	

JPanel medio;
JPanel izq;
JPanel der;

JPanel abajo;
JTextField campo;
JTextField campo1;



RestaSuma eventos=new RestaSuma(this);

public Calculadora(){
	
	

	super("Calculadora");
	
	setSize(400,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Panel principal
	principal=new JPanel();
	
	BoxLayout todo=new BoxLayout(principal,BoxLayout.Y_AXIS);		
	principal.setLayout(todo);
	
	
	
//Primer Panel
	arriba=new JPanel();
	
	campo=new JTextField(30);
	//campo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); -->Hace que el cursor esté
	//en el campo de texto en el lado derecho en lugar del izquierdo

	
	campo1=new JTextField(30);
	campo1.setEditable(false);

	

	arriba.add(campo);
	arriba.add(campo1);
	
	
//Panel Medio
	
	medio=new JPanel();
	
	medio.setLayout(new GridLayout(1,2,10,10));
	
	
	
	//Panel izquierda
	
	izq=new JPanel();
	izq.setLayout(new GridLayout(4,3,5,5));
	
	JButton num1=new JButton("1");
	JButton num2=new JButton("2");
	JButton num3=new JButton("3");
	JButton num4=new JButton("4");
	JButton num5=new JButton("5");
	JButton num6=new JButton("6");
	JButton num7=new JButton("7");
	JButton num8=new JButton("8");
	JButton num9=new JButton("9");
	JButton num0=new JButton("0");
	JButton coma=new JButton(",");
	
	num1.addActionListener(eventos);
	num2.addActionListener(eventos);
	num3.addActionListener(eventos);
	num4.addActionListener(eventos);
	num5.addActionListener(eventos);
	num6.addActionListener(eventos);
	num7.addActionListener(eventos);
	num8.addActionListener(eventos);
	num9.addActionListener(eventos);
	num0.addActionListener(eventos);
	coma.addActionListener(eventos);
	



	
	izq.add(num1);
	izq.add(num2);
	izq.add(num3);
	izq.add(num4);
	izq.add(num5);
	izq.add(num6);
	izq.add(num7);
	izq.add(num8);
	izq.add(num9);
	izq.add(num0);
	izq.add(coma);
	
	
	//Panel derecha
	der=new JPanel();
	der=new JPanel();
	der.setLayout(new GridLayout(4,3,5,5));
	
	JButton mas=new JButton("+");
	JButton menos=new JButton("-");
	JButton mult=new JButton("*");
	JButton div=new JButton("/");
	JButton igual=new JButton("=");
	JButton c=new JButton("C");
	JButton flecha=new JButton("<==");
	
	mas.addActionListener(eventos);
	menos.addActionListener(eventos);
	mult.addActionListener(eventos);
	div.addActionListener(eventos);
	igual.addActionListener(eventos);
	c.addActionListener(eventos);
	flecha.addActionListener(eventos);
	
	der.add(mas);
	der.add(menos);
	der.add(mult);
	der.add(div);
	der.add(igual);
	der.add(c);
	der.add(flecha);
	
	medio.add(izq);
	medio.add(der);
	
	//Panel abajo
	
	abajo=new JPanel();
	
	
	principal.add(arriba);
	principal.add(medio);
	principal.add(abajo);
	
	
	add(principal);
	
	
	
	
	

	
	setVisible(true);
	
}

	public static void main(String[]args){
	
	Calculadora cal=new Calculadora();
	
	
	
	}
}

