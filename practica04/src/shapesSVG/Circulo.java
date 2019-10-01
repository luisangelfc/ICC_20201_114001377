package shapesSVG;
/**
/*Clase que permite crear un Circulo 
/* @author Luis Angel Hernández Martínez
/*
**/
public class Circulo{
    private Vector2 centro;
    public double radio;
    public double perimetro;
    public double area;
/**
/*Primer Constructor de la clase  
/* @param centro que es de tipo Vector2 y radio  
/* Asigna los datos recibidos y se los asigna al objeto
**/
    public Circulo(Vector2 centro,double radio){
	this.centro=centro;
	this.radio=radio;
    }
/**
/* Segundo Constructor de la clase 
/* @param double x que es coordenada en x de el centro 
/* @param double y que es la coordenada en y de el centro
/* @param double radio el radio de la circunferencia
/* Con la x y y crea un vector que se le asigna al objeto de la clase Ciruclo
     **/     
    public Circulo(double x, double y, double radio){
	this.centro= new Vector2(x,y);
	this.radio=radio;
    }
/**
/* Constructor vacío
/* No recibe parametros y le asigna el Vector en las coordenadas (0,0)
/* Asigna un radio de 20
**/
    public Circulo(){
	this.centro= new Vector2(0.0,0.0);
	this.radio=20;
    }

/**
/*Metodo toSVG
/* Agarra los elementos del objeto, crea y regresa una cadena que representa graficamente el circulo en svg
**/
    public String toSVG(){
	String svg =  "<circle cx='"+this.centro.getX() +"' cy='"+ this.centro.getY() + "' r='"+this.radio+"' stroke= 'green' stroke width='4' fill='yellow' />";
	return svg;
    }
    
/**
/*Metodo toString
/* Es una metodo que crea y regresa una cadena con los elementos del objeto
**/
    public String toString(){
	String cadena= "El circulo esta dado por: \n el punto: ("+this.centro.getX()+","+this.centro.getY()+") \n con un radio de :"+this.radio;
	return cadena;
    }

/**
/*Clase equals
/* @param otro de de la clase Circulo
/* Compara cada elemento de dos circulos y regresa true si son iguales y false si son diferentes
**/
    public boolean equals(Circulo otro){
	if(this.centro.getX()==otro.centro.getX()&& this.centro.getY()==otro.centro.getY() && this.radio==otro.radio ) return true;															   return false;
    }


}
