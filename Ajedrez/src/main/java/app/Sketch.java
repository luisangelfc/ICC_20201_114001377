package app;

import chess.items.Board;
import chess.pieces.model.Piece;
import processing.core.PApplet;


/**
 * Clase Sketch
 * Que es donde se va a jugar el juego
 */
public class Sketch extends PApplet {

    private final int BOX_WEIGHT = 96;

    /**
     * Carga las imagenes
     */
    private ImageLoader imageLoader;

    /**
     * Dibuja el tablero
     */
    private BoardGUI boardGUI;

    /**
     * El tablero que contiene las piezas.
     */
    private Board board;

    public static void main(String[] args) {
        PApplet.main("app.Sketch");
    }

    @Override
    public void settings() {
        size(BOX_WEIGHT * 8, BOX_WEIGHT * 8);
        board = Board.getInstance();
        imageLoader = new ImageLoader(this, BOX_WEIGHT);
        boardGUI = new BoardGUI(this, BOX_WEIGHT, board);
    }

    @Override
    public void setup() {
        imageLoader.initalize();
    }

    @Override
    public void draw() {
        boardGUI.drawBoard();
        for (Piece piece : board.getPieces()) {
            imageLoader.drawImage(piece);
        }
    }

    @Override
    public void mouseClicked() {
        boardGUI.select(mouseX, mouseY);
    }

    @Override
    public void mouseMoved() {
        boardGUI.hover(mouseX, mouseY);
    }
    

}
