package chess.pieces;
import java.util.List;
import chess.items.Position;

/**
*Clase Piece
*Esta es una clase abstracta por lo que solo se encontraran los signos de los métodos.
*Esos métodos se definirán en las clases hijos (atributos, posición, legalmoves, tipo y color)
* Los métodos protected es para facilitar que las clases hijos puedan acceder a ellos.
**/
public abstract class Piece{
	protected Position position;
	protected List<Position>legalMoves=null;
	protected PiecesTypeEnum type;
	protected ColorEnum color;
	public abstract void moveTo(Position p);
	public abstract boolean isLegalMove(Position p);
	@Override
	public abstract boolean equals(Object obj);
}
