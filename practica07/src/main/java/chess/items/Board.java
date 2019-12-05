package chess.items;

import java.util.LinkedList;

import chess.items.Position;
import chess.pieces.model.Bishop;
import chess.pieces.model.Empty;
import chess.pieces.model.King;
import chess.pieces.model.Knight;
import chess.pieces.model.Pawn;
import chess.pieces.model.Piece;
import chess.pieces.type.PieceType;
import chess.pieces.model.Queen;
import chess.pieces.model.Rook;

/**
 * Tablero, aquí es donde será jugado
 */
public class Board {

    /**
     * Una matriz con las piezas
     */
    private Piece[][] pieces;

    /**
     * La instancia del tablero
     */
    private static Board board;

    /**
     * Lista de las piezas negras
     */
    private LinkedList<Piece> blackPieces;

    /**
     * Lista de las piezas blancas
     */
    private LinkedList<Piece> whitePieces;

    /**
     * Tamaño del tablero
     */
    private final int SIZE = 8;

    /**
     * Inicia el tablero
     */
    private Board() {
        pieces = new Piece[SIZE][SIZE];
        blackPieces = new LinkedList<>();
        whitePieces = new LinkedList<>();
        this.generateBoard();
        this.setPieceLists();
    }

    /**
     * Obtenemos el tablero
     
     */
    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    /**
     * Obtenemos las piezas dada su posición
     * 
     * @param posicion de la pieza
     * @return la pieza
     */
    public Piece getPiece(Position position) {
        if (position.isValid()) {
            Piece piece = pieces[position.getX()][position.getY()];
            return piece;
        }
        return new Empty();
    }

    /**
     * Obtiene todas las piezas del tablero
     * 
     * @return las piezas
     */
    public LinkedList<Piece> getPieces() {
        LinkedList<Piece> pieceList = new LinkedList<>();
        pieceList.addAll(blackPieces);
        pieceList.addAll(whitePieces);
        return pieceList;
    }

    /**
     * Establece las piezas en una lista.
     */
    private void setPieceLists() {
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                Piece piece = this.pieces[i][j];
                if (piece.getType() != PieceType.EMPTY) {
                    if (piece.getColor() == ColorEnum.BLACK) {
                        blackPieces.add(piece);
                    } else {
                        whitePieces.add(piece);
                    }
                }
            }
        }
    }

    /**
     *Mueve una pieza a la siguiente posición.
     * *
     * @param previous a la posición actual de la pieza
     * @param next a la siguiente posición de la pieza
     */
    public boolean move(Position previous, Position next) {
        Piece piece = getPiece(previous);
        if (piece.getType() != PieceType.EMPTY) {
            if (piece.isLegalMove(next)) {
                Piece lastPiece = this.getPiece(next);

                pieces[next.getX()][next.getY()] = piece;
                pieces[previous.getX()][previous.getY()] = new Empty();

                // Checa si la pieza ha sido movida
                if (lastPiece.getType() != PieceType.EMPTY) {
                    if (lastPiece.getColor() == ColorEnum.BLACK) {
                        blackPieces.remove(lastPiece);
                    } else {
                        whitePieces.remove(lastPiece);
                    }
                }

                // Calcula los movimientos legales
                piece.setPosition(next);
                piece.setLegalMoves(null);
                this.getAllLegalMoves();
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula todos los movimientos legales
     */
    private void getAllLegalMoves() {
        for (Piece piece : this.getPieces()) {
            piece.setLegalMoves(null);
            piece.getLegalMoves();
        }
    }

    /**
     * Genera todas las piezas en el tablero
     */
    private void generateBoard() {
        generateEmpties();
        generatePawns();
        generateKings();
        generateQueens();
        generateBishops();
        generateKnights();
        generateRooks();
    }

    /**
     * Genera las piezas vacías
     */
    private void generateEmpties() {
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                pieces[i][j] = new Empty();
            }
        }
    }

    /**
     * Genera los peones
     */
    private void generatePawns() {
        for (int i = 0; i < pieces.length; i++) {
            Position whitePosition = new Position(i, 1);
            Position blackPosition = new Position(i, 6);
            Pawn blackPawn = new Pawn(blackPosition, ColorEnum.BLACK);
            Pawn whitePawn = new Pawn(whitePosition, ColorEnum.WHITE);
            pieces[i][1] = whitePawn;
            pieces[i][6] = blackPawn;
        }
    }

    /**
     * Genera los reyes
     */
    private void generateKings() {
        pieces[4][0] = new King(new Position(4, 0), ColorEnum.WHITE);
        pieces[4][7] = new King(new Position(4, 7), ColorEnum.BLACK);
    }

    /**
     * Genera las reinas
     */
    private void generateQueens() {
        pieces[3][0] = new Queen(new Position(3, 0), ColorEnum.WHITE);
        pieces[3][7] = new Queen(new Position(3, 7), ColorEnum.BLACK);
    }

    /**
     * Genera los caballeros
     */
    private void generateKnights() {
        pieces[1][0] = new Knight(new Position(1, 0), ColorEnum.WHITE);
        pieces[6][0] = new Knight(new Position(6, 0), ColorEnum.WHITE);
        pieces[1][7] = new Knight(new Position(1, 7), ColorEnum.BLACK);
        pieces[6][7] = new Knight(new Position(6, 7), ColorEnum.BLACK);
    }

    /**
     * Genera los alfiles
     */
    private void generateBishops() {
        pieces[2][0] = new Bishop(new Position(2, 0), ColorEnum.WHITE);
        pieces[5][0] = new Bishop(new Position(5, 0), ColorEnum.WHITE);
        pieces[2][7] = new Bishop(new Position(2, 7), ColorEnum.BLACK);
        pieces[5][7] = new Bishop(new Position(5, 7), ColorEnum.BLACK);
    }

    /**
     * Genera las torres
     */
    private void generateRooks() {
        pieces[0][0] = new Rook(new Position(0, 0), ColorEnum.WHITE);
        pieces[7][0] = new Rook(new Position(7, 0), ColorEnum.WHITE);
        pieces[0][7] = new Rook(new Position(0, 7), ColorEnum.BLACK);
        pieces[7][7] = new Rook(new Position(7, 7), ColorEnum.BLACK);

    }
}
