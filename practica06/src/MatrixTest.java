/**
 *Clase MatrixTest
 *En esta clase se evaluan las funciones que se encuentran en la clase Matrix perteneciente a la practica 6.
 *@author Hernández Martínez Luis Angel

 **/

public class MatrixTest{
    
    public static void scalarProduct_test(double scalar, Matrix x){
	double [][] a={{0.0,0.0,0.0,0.0},{0.0,0.5,1.0,1.5},{0.0,1.0,2.0,2.0}} ;
	Matrix b=new Matrix(a);
	x.scalarProduct(scalar);
	if(x.equals(b)){
	    System.out.println("El metodo scalarProduct funciona");
	}
	else{
	    System.out.println("ScalarProduct failed");
	}
	    
	

    }
/**
/*Metodo add_test
/*@param Matriz x, el cual es un objeto de tipo Matrix
/* Esté metodo prueba el metodo add_test en la clase Matrix
/* Imprime si elmétodo de la clase Matrix está bien o no
**/    
    public static void add_test(Matrix x){
	double [][] array= {{0.0,0.0,0.0,0.0},{0.0,1.0,2.0,3.0},{0.0,2.0,4.0,4.0}};
	Matrix comparacion= new Matrix(array);
	x.add(x);
	if(x.equals(comparacion)){
	    System.out.println("El metodo add funciona");
	}
	else{
	    System.out.println("El metodo add no funciona");
	}
       
    }
/**
/*Metodo matrixProduct_test
/* Metodo que evalúa  el metodo matrixProduct  de la clase Matrix.
/* Imprime o no si el método en la clase Matrix funciona correctamente 
**/    
    public static void matrixProduct_test(){
	
	double arreglo[][]={{2.0,0.0,1.0},{3.0,0.0,0.0},{5.0,1.0,1.0}};
	Matrix x= new Matrix(arreglo);
	double ar[][]={{1.0,0.0,1.0},{1.0,2.0,1.0},{1.0,1.0,0.0}};
	double arr[][]={{5.0,1.0,3.0},{3.0,0.0,3.0},{12.0,4.0,6.0}};
	Matrix resp=new Matrix(arr);
	Matrix d= new Matrix(ar);
	x.matrixProduct(d);
	if(x.equals(resp)){
	    System.out.println("El metodo matrixProduct funciona");
	}
	else{
	    System.out.println("El metodo matrixProduct no funciona");
	}
    }
/**
/*Metodo setElement_test
/* En este metodo que evalua el metodo set Element que se encuentra en la clase Matrix.
/* Imprime un mensaje si el metodo de la clase Matrix funciona bien o no
**/        
    public static void setElement_test(){

	Matrix x= new Matrix (2,2);
	int a=1;
	int b=1;
	double c=10.5;
	x.setElement(a,b,c);
	double comp=x.getElement(a,b);
	
	if(comp==c){
	    System.out.println("El metodo setElement funciona");
	}
	else{
	    System.out.println("El metodo setElement no funciona");
	}
	
    }
    /**
/*Metodo getElement_test
/* Metodo el cual evalua el método que se encuentra en la clase Matrix.
/* Imprime si la funcion está bien o mal.
**/    
    public static void getElement_test(){

	double arreglo[][]={{2.0,0.0,1.0},{3.0,0.0,0.0},{5.0,1.0,10.0}};
	Matrix c= new Matrix(arreglo);

	if(c.getElement(2,2)==10){
	    System.out.println("El metodo getElement funciona");
	}
	else{
	    System.out.println("El método getElement está mal");
	}

    }
/**
/*Metodo determinant__test
/* Metodo que pone a prueba el metodo determinant de la clase Matrix.
/* Imprime un mensaje si el metodo de la clase Matrix funciona bien o no
**/    
    public static void determinant_test(){

	double[][] ar={{2.0,-3.0,1.0},{-3.0,5.0,7.0},{1.0,7.0,-1.0}};
	Matrix mDet= new Matrix(ar);
	double resp=-146;
	double respDet=mDet.determinant();
	if(resp==respDet){
	    System.out.println("El metodo determinant funciona");
	}
	else{
	    System.out.println("El metodo determinant no funciona");
	}
    }

/** 
*Método equal test
*En este método se evalua el metodo queal el cual se encuentra en la clase Matrix
*Imprime un mensaje si el método funciona correctamente o también si no funciona
 **/
 
    public static void equals_test(Matrix x, Matrix y){
	if(x.equals(y)==false && x.equals(x)==true){
	    System.out.println("El metodo equals funciona");

	}
	else{
	    System.out.println("El metodo equals no funciona");
	}
    }
/**
/*Metodo main
* En este método llama a todos los metodos test, además de que se crean varios objetos de la clase Matrix los cuales tiene valores.
**/    
    public static void main(String[] args) {
	int x=6;
	int y=6;
	Matrix a= new Matrix(x,y);
	double [][] array= {{0,0,0,0},{0,1,2,3},{0,2,4,4}};
	Matrix b= new Matrix(array);
        scalarProduct_test(.5,b);
        add_test(b);
        matrixProduct_test();
        setElement_test();
        getElement_test();
        determinant_test();
        equals_test(b,a);
    }
}



