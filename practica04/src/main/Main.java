
package main;
import  shapesSVG.*;
import shapesSVG.Linea;


public class Main{

    public static void main(String args []){
	String inicio= "<svg height='700' width='700'>";
	String cierre="</svg>";
	Vector2 vector = new Vector2(50.0,200.0);
	Vector2 vector2 = new Vector2(500.0,200.0);

       	System.out.println(inicio);
	System.out.println(vector.toSVG());

	

	

Linea linea1= new Linea(vector,vector2);
System.out.println(linea1.toSVG());




	Vector2 vector7= new Vector2(250.0,50.0);
	Rectangulo rectangulo = new Rectangulo(vector7,80,100);
       	System.out.println(rectangulo.toSVG());
	System.out.println(vector7.toSVG());

	Triangulo trian= new Triangulo(250,250,250,350,350,350);
       	System.out.println(trian.toSVG());

	Vector2 vector6 = new Vector2(600.0,100.0);
	Circulo circ= new Circulo(vector6,50.0);
       	System.out.println(circ.toSVG());
	System.out.println(vector6.toSVG());
	
		System.out.println(cierre);
    }
}

