package chess;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.chessPieces.Rook;
import chess.pieces.chessPieces.Queen;
/**
*@author iabin 
*clase Game
*En esta clase se pone a prueba las Rook y Queen
**/
public class Game{

    public static void main(String[] args) {
	System.out.println("Movimientos validos para Rook");
        Rook t = new Rook(new Position(4, 4),ColorEnum.BLACK); //Se crea un objeto de la clase Rook
        System.out.println(t.getLegalMoves());//Se imprime el legalmove
	
	System.out.println("Movimientos válidos para Queen");
	Queen r = new Queen(new Position(4, 4),ColorEnum.BLACK);//Se crea un objeto de la clase Queen
	 System.out.println(r.getLegalMoves());//Se imprime el legal move
    }
}
