import java.util.ArrayList;
import java.util.Arrays;



/**
/*@author Hernández Martínez Luis Angel
/*Clase Control
/*Practica 05
 **/
public class Control{

/**
/* Metodo Problema 1
/*@param Resive un String y regresa un booleano si es palíndromo o no.
**/    
    public static boolean problema1(String palabra ){
 
      char[] c1 = palabra.toCharArray();
      int c2= c1.length-1;

	for(int i=0;i<c1.length;i++){
	 
	    if(c1[i]!=c1[c2]){
		return false;
	    }
	    c2--;
	}
	
        return true;
	
    }

    /**
/* Metodo Problema 2
/*@param recibe un arreglo de tipo entero y un entero llamado xd
/* En este metodo regresa true si el entero se encuentra en el arreglo
**/
    public static boolean problema2(int[] ar, int xd){
      int aux=ar.length-1;
	for(int i=0; i<ar.length;i++){
	    if(ar[aux]+ar[aux-i]==xd){
		return true;
	    }
	    for(int j=1;j<ar.length;j++){
		if(ar[aux-j]+ar[i]==xd){
		    return true;
		}
	    }
	}
	return false;
    }

    /**
/* Metodo del Problema3
/*En este metodo recibe un arreglo y lo regresa ordenado de mayor a menor 
**/    
    public static void problema3(int[] ar){
     int y;
     for(int i=0; i<ar.length-1;i++){
	 for(int j=0; j<ar.length-1-i;j++){
	     if(ar[j]>ar[j+1]){
		 y=ar[j];
		 ar[j]=ar[j+1];
		 ar[j+1]=y;
	     }
	 }
     }

     
    } 

       /**
/* Metodo del problema4
/*Para este método recibe un arreglo y un entero, y a partir de una busqueda, regresar true si el entero está dentro del arreglo, en otro caso false.
**/ 
    public static boolean problema4(int[] ar, int x){
	
	for(int i=0; i<ar.length-1;i++){
	    if(x==ar[i]){
		return true;
	    }
	}
	return false;
    }
    /**
/* Metodo del problema5
/*@param en este método se recibe un entero el cual se evalua si es un numero primo 
**/
    public static boolean problema5(int x){
	if(x>1){
	for(int i=2;i<x;i++){
	    if(x%i==0){
		return false;
	    }
	}
	}
	else{
	    return false;
	}
	return true;
    }
    
       /**
/* Metodo Problema6
/*@param Método que recibe un numero, y dado ese numero, regresa un arreglo con los numeros primos anterirores a ese número.

       **/ 
    public static int[] problema6(int n){
	int x=0;
	for(int i = 1 ; i <= n ; i++){
            if(problema5(i)){
                x ++;
            }
        }
        int [] siesprimo = new int [x];
        int y = 0; 

        for (int j=1 ; j<n ; j++){
            if (problema5 (j)){
                siesprimo [y]= j;
                y++;
            }
        } 
        return siesprimo;
    }

       /**
/*@author AYUDANTE iabin
/* Método main que comprueba el programa
/* Si funciona correctamente, regresa todos con la palabra "bien", si no es asi, regresa la palabra mal
/*
**/ 
    public static void main(String[] args) {
        String resultado = "";
        int[] desordenado = {9,8,7,6,5,4,3,2,1};
        int[] ordenado    = {1,2,3,4,5,6,7,8,9};
        int[] primos10 = {2,3,5,7};
        if(problema1("oso")==true && problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
        if(problema2(desordenado, 17)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
        problema3(desordenado);
        if(Arrays.equals(desordenado,ordenado) == true)resultado+="P3 bien\n";else resultado+="P3 mal\n";
        if(problema4(desordenado,2)== true && problema4(desordenado,18)== false)resultado+="P4 bien\n";else resultado+="P4 mal\n";
        if(problema5(7)==true && problema5(6)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
        if(Arrays.equals(problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
        System.out.println(resultado);   
    }

}
