package shapesSVG;
/**
/* Clase Rectangulo
/* @author Luis Angel Hernández Martinez
/* @param ancho de tipo double
/* @param alto de tipo double
/* @param perimetro de tipo double
/* @param area de tipo double
/* @param a de tipo Vector2
**/
public class Rectangulo{
    private double ancho;
    private double alto;
    private double perimetro;
    private double area;
    private Vector2 a;
    
    

/**
/*Primer constructor 
/*Recibe dos double y un tipo Vector 2
/* asigna los tres parametros que recibe como elementos del objeto
**/
    public Rectangulo(Vector2 a, double ancho, double alto){
	this.a=a;
	this.ancho=ancho;
	this.alto=alto;
    }

    
/**
/*Segundo constructor 
/*@param x1 de tipo double
/*@param y1 de tipo double
/*@param x2 de tipo double
/*@param y2 de tipo double
/*@param x3 de tipo double
/*@param y3 de tipo double
/*y con x1 y y1 crea un objeto y se le asigna a ancho y alto
**/
    public Rectangulo(double x, double y, double ancho, double alto){
	a= new Vector2(x,y);
	this.alto=alto;
	this.ancho=ancho;
	
    }

    
/**
/* Constructor vacío
/* Crea un vector en el punto  a(3.0,3.0),un ancho de 10 y alto de 20 
**/
    public Rectangulo(){
	a= new Vector2(3.0,3.0);
	this.ancho=10;
	this.alto=20;

    }

     
/**
/* Metodo toSVG
/* Con los elementos crea una cadena SVG
**/
    public String toSVG(){

	String rectangulo="<rect x='"+this.a.getX()+"' y='"+this.a.getY()+"' width='"+this.ancho+"' height='"+this.alto+"' fill:'blue' />";
	
	return rectangulo;
    }

    
/**
/* Metodo toString
/* Con los elementos crea una cadena String que diga al objeto
**/
    public String toString(){
	String rectangulo="Tenemos un rectangulo con vectores: ("+this.a.getX()+","+this.a.getY()+")" +" \n" + " altura :" +this.alto+ "\n" +" ancho de :"+this.ancho ;
	return rectangulo;
    }

    
/**
/* Metodo equals
/*El cual compara los dos objetos y si son iguales regresa true, si no es así regresa false
**/
    public boolean equals(Rectangulo rectangulox){
	if(this.a.getX()==rectangulox.a.getX() && this.a.getY()==rectangulox.a.getY()&& this.alto==rectangulox.alto && this.ancho==rectangulox.ancho ){
	    return true;
	}
	return false;
    }
}

