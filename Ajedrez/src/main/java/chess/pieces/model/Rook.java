package chess.pieces.model;

import java.util.LinkedList;

import chess.items.Board;
import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.MoveType;
import chess.pieces.type.PieceType;

/**
 * La torre es una pieza con moviemintos horizontales y verticales
 */
public class Rook extends Piece {

    /**
     * Al crear la torre se le asigna posicion y color
     * @param position 
     * @param color 
     */
    public Rook(Position position, ColorEnum color) {
        super(position, color, PieceType.ROOK);
    }

    /**
     * Construye una torre en base a su color, posición y tipo
     * @param position La posicion de la torre
     * @param color El color de la torre
     * @param type El tipo de torre
     */
    public Rook(Position position, ColorEnum color, PieceType type){
        super(position, color, type);
    }

    @Override
    public LinkedList<Position> getLegalMoves() {
        if (super.getLegalMoves() == null) {
            this.legalMoves = new LinkedList<>();
            setMoves(MoveType.FOWARD);
            setMoves(MoveType.BACKWARD);
            setMoves(MoveType.LEFT);
            setMoves(MoveType.RIGHT);
        }
        return super.getLegalMoves();
    }

    private void setMoves(MoveType movement) {
        
        Board board = Board.getInstance();

        // Las coordenadas de la torre
        int y = this.getPosition().getY();
        int x = this.getPosition().getX();

        
        int i = 0;
        
        // Define si se mueve horizontal o verticalmente
        i += (movement == MoveType.FOWARD || movement == MoveType.BACKWARD) ? y : x;
        Position position = null;
        do  {
            // Operaciones con base a la posicion
            i += (movement == MoveType.FOWARD || movement == MoveType.RIGHT) ? +1 : -1;
            position = (movement == MoveType.FOWARD || movement == MoveType.BACKWARD) ? new Position(x,i) : new Position(i,y); 
            
            Piece piece = board.getPiece(position);
            if (piece.getColor() == this.getColor()) {
                break;
            } else {
                this.addLegalMove(position);
                if(piece.getType() != PieceType.EMPTY){
                    break;
                }
            }

        } while(position.isValid());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rook) {
            Rook aux = (Rook) obj;
            if (this.getPosition().equals(aux.getPosition())) {
                return true;
            }
        }
        return false;
    }

}
