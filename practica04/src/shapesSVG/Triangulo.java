package shapesSVG;
/**
/*Clase Triangulo
/*@author Luis Angel Hernández Martínez
/*@param a de tipo Vector2
/*@param b de tipo Vector2
/*@param c de tipo Vector2
/*@param perimetro es un double
/*@param area es un double
**/
public class Triangulo{
    private Vector2 a;
    private Vector2 b;
    private Vector2 c;
    private double perimetro;
    private double area;

/**
/*Primer constructor 
/*recibe dos vectores y asigna parametros
**/
    public Triangulo(Vector2 a, Vector2 b, Vector2 c){
	this.a=a;
	this.b=b;
	this.c=c;
    }

/**
/*Segundo constructor 
/*@param x1 es tipo double
/*@param y1 es tipo double
/*@param x2 es tipo double
/*@param y2 es tipo double
/*@param x3 es tipo double
/*@param y3 es tipo double
/*con x1 y y1 crea un objeto de la clase Vector2 y se lo asigna al elemento a del objeto
/*con x2 y y2 crea un objeto de la clase Vector2 y se lo asigna al elemento b del objeto
/*con x3 y y3 crea un objeto de la clase Vector2 y se lo asigna al elemento c del objeto
**/
    public Triangulo(double x1, double y1,double x2, double y2,double x3, double y3 ){
	this.a= new Vector2(x1,y1);
	this.b= new Vector2(x2,y2);
	this.c= new Vector2(x3,y3);
    }
/**
/* Constructor por default
/* Crea tres vectores en los puntos a(0,0),b(10,10) y c(5,10)
**/
    public Triangulo(){
	this.a= new Vector2(0.0,0.0);
	this.b= new Vector2(10.0,10.0);
	this.c= new Vector2(5.0,10.0);
    }
    
/**
/* Metodo toSVG
/* Mediante los elementos del objeto crea y regresa  una cadena que lo representagraficamente en svg
**/
    public String toSVG(){
	String tri="<polygon points= '"+this.a.getX()+","+this.a.getY()+" "+this.b.getX()+","+this.b.getY()+" "+this.c.getX()+","+this.c.getY()+"' />";

	return tri;
    }
/**
/* Metodo toString
/* Mediante los elementos del objeto crea y regresa  una cadena que describe al objeto
**/
    public String toString(){
	String salida="Es un triangulo dado por los puntos : \n Punto1: ("+this.a.getX()+","+this.a.getY()+") \n Punto2: ("+this.b.getX()+","+this.b.getX()+") \n Punto3: ("+this.c.getX()+","+this.c.getY()+")";
	return salida;
    }
/**
/* Metodo equals
/*@param segundo de la clase Triangulo
/* compara cada elemento de ambos objetos y en caso de ser iguales regresa true en caso contrario false
**/
    public boolean equals(Triangulo segundo){
	if(this.a.getX()==segundo.a.getX() && this.a.getY()==segundo.a.getY() && this.b.getX()==segundo.b.getX() && this.b.getY()==segundo.b.getY() && this.c.getX()==segundo.c.getX() && this.c.getY()==segundo.c.getY()) return true;
	return false;
    }

}
