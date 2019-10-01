package shapesSVG;

/**
   /* @author Luis Angel Hernández Martínez
   /* Clase Linea
   /* @param a es vector de la línea
   /* @param b es el otro vector de la línea
   /* @param longitud que es la longitud de la línea

**/

public class Linea{
    
    private Vector2 a;
    private Vector2 b;
    private Double longitud;


    /**
       /* Constructor
       /* Recibe dos vectores, los cuales son la posición de sus extremos
       /* @param n es de tipo Vector2
       /* @param m es de tipo Vector2
       /* Crea una linea con base a esos vectores

    **/
    public Linea (Vector2 n, Vector2 m){
	this.a=m;
	this.b=n;

    }

    /** Segundo constructor
	/* @param x1 es de tipo double
	/* @param x2 es de tipo double
	/* @param y1  es de tipo double
	/* @param y2  es de tipo double
	/* Crea dos vectores
    **/

    public Linea (Double x1, Double x2, Double y1, Double y2){
	Vector2 a = new Vector2 (x1, y1);
	Vector2 b = new Vector2 (x2, y2);
	this.a=a;
	    this.b=b;
    }


    /**
       /* Constructor vacío
       /* No recibe parámetros
       /* Crea dos vectores uno (0.0,0.0) y otro (0.0, 0.0)
    **/

    public Linea (){
	Vector2 a= new Vector2 (0.0, 0.0);
	Vector2 b= new Vector2 (0.0, 0.0);
	this.a = a;
	this.b = b;
    }


    /**
       /* Metodo to SVG
       /*Por lo elementos del objeto, crea una cadena SVG
    **/

    public String toSVG (){
	String svg = "";
	svg = svg + "<line x1='"+this.a.getX()+"' y1='"+this.a.getY()+"' x2='"+this.b.getX()+"' y2='"+this.b.getY()+"' style='stroke:rgb(255,0,0);stroke-width:2' />";
	return svg;	

    }

    /**
       /* Método to String 
       /* Crea una cadena con los elementos del objeto

    **/

    public String toString (){
	String svg = "Linea por Vector 1: " + this.a + "\n "+"Vector 2: "+ this.b;
	return svg;

	/** Metodo equals
	    /* El cual compara los dos objetos y si son iguales regresa true, si no es así regresa false
	**/
    }
	public boolean equals(Linea linea2){

	    if(this.a.getX()==linea2.a.getX() && this.a.getY()==linea2.a.getY() && this.b.getX()==linea2.b.getX() && this.b.getY()==linea2.b.getY()){
		return true;
	}
	    return false;

	    
	}
}
    


    
   
