package chess.pieces.model;

import chess.items.*;
import chess.pieces.type.PieceType;

import java.util.LinkedList;

/**
 * En esta clase se representan las piezas del ajedrez
 */
public abstract class Piece{

    /**
     * Posicion de la pieza
     */
    private Position position;

    /**
     * El color de la pieza
     */
    final private ColorEnum color;

    /**
     * Los posibles movimientos legales
     */
    protected LinkedList<Position> legalMoves;

    /**
     * Tipos de piezas
     */
    final private PieceType type;
    

    /**
     * Crear una pieza en base a su posicion color y tipo
     * @param position 
     * @param color 
     * @param type  
     */
    public Piece(Position position, ColorEnum color, PieceType type){
        this.position = position;
        this.color = color;
        this.type = type;
    }

    /**
     * Movimientos legales
     * @return
     */
    public LinkedList<Position> getLegalMoves(){
        return legalMoves;
    } 

    /**
     * Comprueba si una posición determinada está en los movimientos legales
     * @param p posicion
     * @return true si el movimiento es legal
     */ 
    public boolean isLegalMove(Position p){
        return (legalMoves.contains(p))?true:false;
    }


    /**
     * Obtiene la posicion de la pieza
     * @return la posicion
     */
    public Position getPosition() {
		return position;
	}

    /**
     * Sets la posicion
     */
	public void setPosition(Position position) {
		this.position = position;
	}


    /**
     * Obtiene el color de las piezas
     * @return el color
     */
	public ColorEnum getColor() {
		return color;
    }
    
    /**
     * Regresa el tipo de pieza que es
     */
    public PieceType getType() {
        return type;
    }

    /**
     * Obtiene los movimientos legales
**/
    public void setLegalMoves(LinkedList<Position> legalMoves) {
        this.legalMoves = legalMoves;
    }

    /**
     * Añade una posicion para los movimientos legales
     * @param p una posicion en el tablero
     */
    public void addLegalMove(Position p){
        if(p.isValid()){
            this.legalMoves.add(p);
        }
    }
    

}
