
package shapesSVG;

/**
   /*@author Luis Angel Hernández Martínez 
   /* Clase Vector que crea objetos puntos o Vectores
   /* @param double x es la coordenada x del vector
   /* @param double y es la coordenada y del vector
   /* @param double magnitud que da la magnitud del vector 

**/
public class Vector2 {
    private Double x;
    private Double y ;
    private Double magnitud;


    /** 
	/*Primer constructor de la clase
	/*Recibe un double x que es la coordenada x 
	/*Recibe un double y que es la coordenada y
	/*Asigna un objeto y una magnitud de 5

    **/

    public Vector2 (Double x, Double y){

	this.x=x;
	this.y=y;
	this.magnitud=5.00;	
    }
    /**
       /* Segundo constructor de la clase Vector 2
       /* Asigna a las coordenadas (0,0) y a la magnitud 5

    **/


    public Vector2 (){
	this.x=0.0;
	this.y=0.0;
	this.magnitud=5.00;

	    }


    /**
       /*Metodo distancia
       /* Recibe un objeto de la clase 
       /* Calcular por Pitágoras la distancia entre un vector y otro
       /*Regresa la distancia

    **/
    


    public Double distancia (Vector2 vector)   {
	double distancia = Math.sqrt ( Math.pow(vector.x - this.x,2) + Math.pow (vector.y - this.y,2));
	return distancia;

}

    /** 
	/* Método toSVG
	/* Hace una cadena con los elementos de los ob jetos creados anteriormente
	/* Y regresa una cadena SVG

    **/
    public String toSVG (){
	String svg = "<circle cx= '"+ this.x + "' cy='"+ this.y+ "' r='40' stroke='green' stroke-width='4' fill='yellow' />";
	return svg;
    }

    /** 
	/* Método get
	/* No recibe parametros
	/* Regresa x del objeto
    **/
	public Double getX (){
	return this.x;

    }

    /**
       /* Metodo set 
       /* Recibe un double el cual se le asigna x del objeto
    **/
    public void setX (Double x){
	this.x=x;
}

        /** 
	/* Método get
	/* No recibe parametros
	/* Regresa y del objeto
    **/

    
    public Double getY (){
	return this.y;

    }
        /**
       /* Metodo set 
       /* Recibe un double el cual se le asigna y del objeto
    **/

    public void setY (Double y){
	this.y=y;
    }

    /**
    /* Metodo toString
    /* No recibe parámetros
    /* Con base a los objetos crea y regresa una cadena

    **/

   
    public String toString(){

	String vector2= "("+  this.x +" + "+this.y+ ")";
	    return vector2;
}

    /**
       /*Método equals 
       /* Recibe un obejeto de la clase
       /* Si los valores son los mismos, entonces true, si no es así, false

    **/
    
    public boolean equals (Vector2 vector){
	if (this.x==vector.x && this.y==vector.y) {
	    return true;
	}
	else{
	    return false;
	}
    }
}
