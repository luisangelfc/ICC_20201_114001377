package chess.pieces.model;

import java.util.LinkedList;

import chess.items.Board;
import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.MoveType;
import chess.pieces.type.PieceType;

/**
 * Clase reina
 * La reina tiene dos tipos de movimientos
 **/
public class Queen extends Rook {

    /**
     * Crea una reina con posicion y color
     * @param posicion
     * @param color
     */
    public Queen(Position position, ColorEnum color) {
        super(position, color, PieceType.QUEEN);
    }
    
    @Override
    public LinkedList<Position> getLegalMoves() {
        if(this.legalMoves == null){
            super.getLegalMoves();
            legalMoves.addAll(super.getLegalMoves());
            setDiagonalMoves(MoveType.RIGHT, MoveType.FOWARD);
            setDiagonalMoves(MoveType.RIGHT, MoveType.BACKWARD);
            setDiagonalMoves(MoveType.LEFT, MoveType.FOWARD);
            setDiagonalMoves(MoveType.LEFT, MoveType.BACKWARD);
        }

        return this.legalMoves;
    }


 /**
  * Añade los posibles movimientos legales
  * @param moveX 
  * @param moveY 
   */
    public void setDiagonalMoves(MoveType moveX, MoveType moveY){

        // Validación de las entradas
        if(moveX == MoveType.FOWARD || moveX == MoveType.BACKWARD){
            return;
        }
        if(moveY == MoveType.RIGHT || moveY == MoveType.LEFT){
            return;
        }

        Board board = Board.getInstance();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        // Define como las piezas deberían moverse diagonalmente
        int addY = (moveY == MoveType.FOWARD) ? 1 : -1;
        int addX = (moveX == MoveType.RIGHT) ? 1 : -1;
        Position position = new Position(0,0);

        
        for(int i = x + addX, j = y + addY; position.isValid(); i+=addX, j+= addY){
            position = new Position(i,j);
            if(position.isValid()){
                Piece piece = board.getPiece(position);
                if(piece.getColor() == this.getColor()){
                    break;
                } else {
                    this.legalMoves.add(position);
                    if(piece.getType() != PieceType.EMPTY){
                        break;
                    }
                }
            }
        }
    }
    

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Queen){
            Queen aux = (Queen) obj;
            if(this.getPosition().equals(aux.getPosition())){
                return true;
            }
        }
        return false;
    }

}
