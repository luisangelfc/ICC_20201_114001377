package chess.pieces.model;

import java.util.LinkedList;

import chess.items.Board;
import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.MoveType;
import chess.pieces.type.PieceType;

/**
 * El alfil es una pieza que se mueve en diagonal
 */
public class Bishop extends Piece {

    /**
     * Crea un alfildada su posición y color.
     * @param posiciona la posición del alfil
     * @param colorea el color del alfil
     */
    public Bishop(Position position, ColorEnum color) {
        super(position, color, PieceType.BISHOP);
    }

    @Override
    public LinkedList<Position> getLegalMoves() {
        if(this.legalMoves == null){
            this.legalMoves = new LinkedList<>();
            setDiagonalMoves(MoveType.RIGHT, MoveType.FOWARD);
            setDiagonalMoves(MoveType.RIGHT, MoveType.BACKWARD);
            setDiagonalMoves(MoveType.LEFT, MoveType.FOWARD);
            setDiagonalMoves(MoveType.LEFT, MoveType.BACKWARD);
        }
        return super.getLegalMoves();
    }

    /**
     * Agregue los posibles movimientos legales diagonales
     * @param moveX el movimiento en el eje x
     * @param moveY el movimiento en el eje y
     */
    public void setDiagonalMoves(MoveType moveX, MoveType moveY){

        // Validacion de las entradas
        if(moveX == MoveType.FOWARD || moveX == MoveType.BACKWARD){
            return;
        }
        if(moveY == MoveType.RIGHT || moveY == MoveType.LEFT){
            return;
        }

        Board board = Board.getInstance();
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        // DSe define cuantos espacios se movera diagonalmemte
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
        if(obj instanceof Bishop){
            Bishop b = (Bishop)obj;
            if(this.getPosition().equals(b.getPosition())){
                return true;
            }
        }
        return false;
    }
    
}
