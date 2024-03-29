/**
 * Clase llamada Matrix
 * @author Hernández Martínez Luis Angel
 *@version 1.0
 **/

public class Matrix {

    double [][] matriz;
    // Construye una matriz vacía x por y


    /** Método que construye una Matriz vacía llamada Matriz
    *@param x, que es el número de filas
    * @param y, que es el número de columnas
    
    **/

    public Matrix (int n, int m){
	this.matriz= new double [n][m];
	
    }

    /** Construye una matriz 
     **/

    public Matrix (double [][] array){
	this.matriz=array;
    }

    /** Método scalarProduct 
     * El cual calcula el producto escalar de la matriz
     * @param scalar, el cual es el numero por el cual se va a multiplicar la matriz
     **/

    public void scalarProduct (double scalar){
	
	for (int i=0;i<this.matriz.length;i++){
			for (int j=0;j<this.matriz[0].length;j++){
				this.matriz[i][j]=this.matriz[i][j]*scalar;
			}
	}
    }

    /** Método que calcula la suma de matrices
     *@param m, va a ser un objeto de clase matrix
     * Compara las matrices y hace la suma de cada casilla 
     **/

    public void add (Matrix m){
	if(this.matriz.length==m.matriz.length && this.matriz[0].length==m.matriz[0].length){
	    for(int i=0; i<this.matriz.length;i++){
		for(int j=0; j<this.matriz[0].length;j++){
		    this.matriz[i][j]=this.matriz[i][j]+m.matriz[i][j];

		    
		}
	    }
	}
    }


    /** Método llamado matrixProduct que calcula  el producto de matrices 
     *@param m, recibe un objeto de la clase Matrix
     **/

    public void matrixProduct (Matrix m){

	double[][] resp= new double[this.matriz.length][m.matriz[0].length];
	double suma=0;
	int x=0;
	int y=0;
	if(this.matriz[0].length==m.matriz.length){
	    for(int i=0;i<this.matriz.length;i++){
		for(int j=0; j<this.matriz[i].length;j++){
		    resp[i][j]+=this.matriz[i][j]*m.matriz[j][i];
		    for(int z=0;z<this.matriz[0].length;z++){
			resp[i][j]+=this.matriz[i][z]*m.matriz[z][j];
		    }
		}
	    }
	    this.matriz=resp; 	
	}		
	else{
	    System.out.println("No se pueden multiplicar estas matrices");
	}
	
    }
    /** Método que que obtiene el elemento i j
     *@param numero de fila del elemento
     *@param numero de columna de nuestro elemento
     **/
    
    public double getElement (int i, int j){
       return this.matriz[i] [j];
	    
    }


    /** Método set Element 
     *@param i, de tipo entero que es la fila del elemento
     *@param j, de tipo entero, que es la columna del elemento.
     *@param e, de tipo double, el cual es el valor por el cual se va a reemplazar la casilla
     **/

    public void setElement(int i, int j,double e){
	this.matriz[i][j]=e;

    }

    /** Método que calcula el determinante si es nxn y regresa la determinante de la matriz


     **/
	
    public int determinant(){
	for(int k=0; k<this.matriz.length-1; k++){
            for(int i=k+1; i<this.matriz.length; i++){
                for(int j=k+1; j<this.matriz.length; j++){
                    this.matriz[i][j]-=this.matriz[i][k]*this.matriz[k][j]/this.matriz[k][k];
                }
            }
        }
        int deter=1;
        for(int i=0; i<this.matriz.length; i++){
            deter*=this.matriz[i][i];
        }
        return deter;
    }


    /** Te dice si dos matrices son iguales
    *@param recibe un objeto de la clase MAtrix 

    **/
    public boolean equals (Matrix e){
	if(this.matriz.length==e.matriz.length && this.matriz[0].length==e.matriz[0].length){
	    for(int i=0; i<this.matriz.length;i++){
		for(int j=0; j<this.matriz[0].length;j++){
		    if(this.matriz[i][j]!=e.matriz[i][j]){
			return false;
		    }
		}
	    }
	    return true;
	}
	else{
	    return false;
	}
	

    }
}
