package chess.pieces.model;

import java.util.LinkedList;

import chess.items.Board;
import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.PieceType;

/** Clase Rey
**/

public class King extends Piece {

    public King(Position position, ColorEnum color) {
        super(position, color, PieceType.KING);
    }
/*
 * Calcula los movimientos legales
**/
    @Override
    public LinkedList<Position> getLegalMoves() {
        if(this.legalMoves == null){
            Board board = Board.getInstance();
            this.legalMoves = new LinkedList<>();
            int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, 0 }, { -1, 0 }, { -1, +1 }, { +1, -1 }, {-1,-1}};
            for (int i = 0; i < moves.length; i++) {
                int x = this.getPosition().getX() + moves[i][0];
                int y = this.getPosition().getY() + moves[i][1];
                Position position = new Position(x, y);
                if (position.isValid()) {
                    Piece piece = board.getPiece(position);
                    if (piece.getColor() == this.getColor())
                        continue;
                    else {
                        this.legalMoves.add(position);
                    }

                }
            }
        }
        return this.legalMoves;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof King){
            King b = (King) obj;
            if(this.getPosition().equals(b.getPosition())){
                return true;
            }
        }
        return false;
    }
}
