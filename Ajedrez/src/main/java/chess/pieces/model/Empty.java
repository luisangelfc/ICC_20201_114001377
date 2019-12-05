package chess.pieces.model;

import chess.items.ColorEnum;
import chess.items.Position;
import chess.pieces.type.PieceType;

/**
 * Las piezas vacías resuelven la excepción de puntero nulo
 */
public class Empty extends Piece {

    /**
     * Crea las piezas vacías
     */
    public Empty() {
        super(new Position(0,0), ColorEnum.NONE, PieceType.EMPTY);
    }

}
