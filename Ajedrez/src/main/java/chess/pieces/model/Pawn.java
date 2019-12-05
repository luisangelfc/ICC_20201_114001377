package chess.pieces.model;

import java.util.LinkedList;

import chess.items.Board;
import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.PieceType;

/**
 * El peón es una pieza que solo se mueve hacia adelante
 */
public class Pawn extends Piece {

/**
 * Al crear al peon se le asigna color y posicion
**/
    public Pawn(Position position, ColorEnum color) {
        super(position, color, PieceType.PAWN);
    }

    @Override
    public LinkedList<Position> getLegalMoves() {
        if (this.legalMoves == null) {

            Board board = Board.getInstance();
            this.legalMoves = new LinkedList<>();
            int add = this.getColor() == ColorEnum.WHITE ? 1 : -1;

            // Posicion de las piezas
            int x = this.getPosition().getX();
            int y = this.getPosition().getY();

            // Posibles movimientos legales
            Position forward = new Position(x, y + add);
            Piece testPiece = board.getPiece(forward);

            if (testPiece.getType() == PieceType.EMPTY) {
                legalMoves.add(forward);
                
               
                if ((y == 1 && this.getColor() == ColorEnum.WHITE) || (y == 6 && this.getColor() == ColorEnum.BLACK)) {
                    forward = new Position(x, y + add * 2);
                    if (board.getPiece(forward).getType() == PieceType.EMPTY) {
                        legalMoves.add(forward);
                    }
                }
            }

            int[][] diagonalMoves = {{x + 1, y + add}, { x - 1, y + add}};
            // Movimientos legales
            for (int i = 0; i < diagonalMoves.length; i++) {
                Position position = new Position(diagonalMoves[i][0], diagonalMoves[i][1]);
                testPiece = board.getPiece(position);
                if (testPiece.getType() != PieceType.EMPTY && testPiece.getColor() != this.getColor()) {
                    legalMoves.add(position);
                }
            }

            this.setLegalMoves(legalMoves);
        }

        return this.legalMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pawn) {
            Pawn aux = (Pawn) obj;
            if (this.getPosition().equals(aux.getPosition())) {
                return true;
            }
        }
        return false;
    }

}
