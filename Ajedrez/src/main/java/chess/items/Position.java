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
   private int BOARD_SIZE = 8; // Tamaño del tablero
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
 * Establece las coordenadas x
 * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

 /**
 * Establece las cordenadas y
 */
    public void setY(int y) {
        this.y = y;
    }


/**
 * Comprueba si una posición no está fuera de los límites del tablero
 * @return
 */
    public boolean isValid(){
        if(this.x >= 0 && this.x < BOARD_SIZE && this.y >= 0 && this.y < BOARD_SIZE){
            return true;
        }
        return false;
    }

/**
 *Metodo equals
 *Este método determina di una posicion es igual a otra, y en base a ello regresa true y false.
**/
    @Override
    public boolean equals(Object obj) {
        Position aux = (Position)obj;
        if(aux.getX() == this.getX() && aux.getY() == this.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = this.getX() + " "+this.getY();
        return s;
    }
}
