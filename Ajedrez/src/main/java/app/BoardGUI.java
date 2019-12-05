package app;

import chess.items.Board;
import chess.items.Position;
import chess.pieces.model.Empty;
import chess.pieces.model.Piece;
import chess.pieces.type.PieceType;
import processing.core.PApplet;

/**
 * Clase BoardGUI
 */
public class BoardGUI {

 
    private PApplet pApplet;
    final int weight;

    /**
     * El tablero
     */
    private Board board;

    /**
     * Donde se encuentra el mouse
     */
    private Position hoveredBox;

    /**
     * La seleccion de caja
     */
    private Position selectedBox;

    /**
     * La seleccion de piezas
     */
    private Piece selectedPiece;

    public BoardGUI(PApplet pApplet, int weight, Board board) {
        this.pApplet = pApplet;
        this.weight = weight;
        this.board = board;
        this.hoveredBox = new Position(0, 0);
        this.selectedBox = new Position(-1, -1);
        this.selectedPiece = new Empty();
    }

    /**
     * Se dibuja el cuadro de ajedrez
     */
    public void drawBoard() {
        this.drawBoxes();
        this.drawLegalMoves();
    }


    /**
     * Dibuja las casillas en el tablero
     */
    private void drawBoxes(){
        boolean black = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                // Casilla normal
                pApplet.noStroke();
                if (hoveredBox.getX() == i && hoveredBox.getY() == j && !selectedBox.equals(hoveredBox)) {
                    pApplet.fill( 255, 0, 191 );
                } else if (black == true) { // Caja negra
                    pApplet.fill( 214, 0, 0 );
                } else { // Blanca
                    pApplet.fill(255);
                }

                // Sellecion de casilla
                if (selectedBox.getX() == i && selectedBox.getY() == j) {
                    pApplet.stroke(255);
                    pApplet.fill(11, 217, 145);
                }
                pApplet.rect(i * weight, j * weight, weight, weight);

                //Hacer el cambio de color
                black = black ? false : true;
            }
            black = black ? false : true;
        }
    }

    /**
     * Draws the legal moves of a piece
     */
    private void drawLegalMoves(){
        if (selectedPiece.getType() != PieceType.EMPTY) {
            for (Position position : selectedPiece.getLegalMoves()) {
                pApplet.fill(9, 163, 109);
                pApplet.stroke(255);
                pApplet.rect(position.getX() * weight, (7 - position.getY()) * weight, weight, weight);
            }
        }
    }

    /**
     * Establece el cuadro seleccionado o realiza una acción
     * @param coordenada x
     * @param coordenada y 
     */
    public void select(int x, int y) {
    
        x = (int) Math.floor(x * (1.0) / weight);
        y = (int) Math.floor(y * (1.0) / weight);

        // Checa el estado de las casillas
        boolean changeSelected = true;

        
        Piece piece = board.getPiece(new Position(x, 7 - y));

        if (selectedPiece.getType() == PieceType.EMPTY || piece.getColor() == selectedPiece.getColor()) {
            this.selectedPiece = piece;
        } else {

            Position previous = new Position(selectedBox.getX(), 7 - selectedBox.getY());
            Position next = new Position(hoveredBox.getX(), 7 - hoveredBox.getY());
            
            // Se hace el movimiento si es posible
            if (board.move(previous, next)) {
                this.selectedBox.setX(-1);
                this.selectedBox.setY(-1);
                changeSelected = false;
            }
            selectedPiece = new Empty();
        }
        
        if (changeSelected) {
            this.selectedBox.setX(x);
            this.selectedBox.setY(y);
        }

    }

    /**
     * Establece la hoveredBox
     * @param coordenada x 
     * @param coordenada y 
     */
    public void hover(int x, int y) {
        x = (int) Math.floor(x * (1.0) / weight);
        y = (int) Math.floor(y * (1.0) / weight);
        this.hoveredBox.setX(x);
        this.hoveredBox.setY(y);
    }

}
