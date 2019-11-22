package chess.items;
/**
*@author iabin
*Clase position
*En esta clase de crean objetos que determinan la posicion de las piezas en el tablero.
*@param Dos enteros llamados x, y  
**/
public class Position{
    private int x;
    private int y;
/**
*Constructor de la clase Position
*@param Recibe dos enteros llamados x, y 
**/
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

/**
*Metodo getX
*Este método regresa la coordenada X
**/
    public int getX() {
        return x;
    }

/**
*Metodo getY
*Este metodo regresa la coordenada Y
**/
    public int getY() {
        return y;
    }
/**
*Metodo equals
*Este método determina di una posicion es igual a otra, y en base a ello regresa true y false.
**/
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position))return false;
        Position p = (Position)obj;
        return (p.getX()==this.getX() && p.getY()== this.getY())? true: false;
    }
/**
*Metodo toString
*Este método regresa un String con todos los movimientos posibles que puede hacer una pieza
* Por ejemplo: ||x:5 y:3||
**/
    @Override
    public String toString() {
        return "  ||x:"+this.getX()+" y:"+this.getY()+"||";
    }

/**
*Método isOutOfBoard
*Estemétodo evalua si un movimiento es válido, y en base a ello regresa un true o false.
**/    
    public boolean isOutOfBoard(int board_size){
        if(this.y >= board_size)return false; 
        if(this.x >= board_size)return false;
        if(this.y < 0)return false;
        if(this.x < 0)return false;
        return true;
    }
}
