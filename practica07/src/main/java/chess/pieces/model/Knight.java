package chess.pieces.model;

import java.util.LinkedList;

import chess.items.Board;
import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.PieceType;

/**
 * El caballo es capaz de saltar a otras piezas
 */
public class Knight extends Piece {

    /**
     * Al crear al cabello se le asigna el color y la posicion
     */
    public Knight(Position position, ColorEnum color) {
        super(position, color, PieceType.KNIGHT);
    }
/**
 * Calcula los movimientos legales
**/

    @Override
    public LinkedList<Position> getLegalMoves() {
        if (this.legalMoves == null) {
            Board board = Board.getInstance();
            this.legalMoves = new LinkedList<>();

            // Posibles movimientos
            int[][] moves = { { -2, -1 }, { -2, +1 }, { +2, -1 }, { +2, +1 }, { -1, -2 }, { -1, +2 }, { +1, -2 },
                    { +1, +2 } };

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
        return super.getLegalMoves();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Knight){
            Knight b = (Knight) obj;
            if(this.getPosition().equals(b.getPosition())){
                return true;
            }
        }
        return false;
    }

}
