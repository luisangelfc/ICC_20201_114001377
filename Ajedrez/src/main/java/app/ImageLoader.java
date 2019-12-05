package app;

import chess.items.ColorEnum;
import chess.pieces.model.Piece;
import chess.pieces.type.PieceType;
import processing.core.PImage;
import processing.core.PApplet;;

/**
 * ImageLoader carga las imágenes de cada pieza en el tablero
 */
public class ImageLoader {

    /**
     * Una instancia de PApplet
     */
    private PApplet pApplet;

    /**
     * Tamaño de la tabla
     */
    private final int BOX;

    private PImage BLACK_PAWN;
    private PImage WHITE_PAWN;
    private PImage BLACK_QUEEN;
    private PImage WHITE_QUEEN;
    private PImage BLACK_KING;
    private PImage WHITE_KING;
    private PImage BLACK_BISHOP;
    private PImage WHITE_BISHOP;
    private PImage BLACK_KNIGHT;
    private PImage WHITE_KNIGHT;
    private PImage BLACK_ROOK;
    private PImage WHITE_ROOK;

    /**
     * Se creaImageLoader
     * @param pApplet  PApplet
     * @param casilla el tamaño del tablero
     */
    public ImageLoader(PApplet pApplet, int box) {
        this.pApplet = pApplet;
        this.BOX = box;
    }


    /**
     * Inicializa las imagenes
     */
    public void initalize() {
        this.BLACK_BISHOP = pApplet.loadImage(Image.BLACK_BISHOP.getFile());
        this.WHITE_BISHOP = pApplet.loadImage(Image.WHITE_BISHOP.getFile());
        this.BLACK_KING = pApplet.loadImage(Image.BLACK_KING.getFile());
        this.WHITE_KING = pApplet.loadImage(Image.WHITE_KING.getFile());
        this.BLACK_QUEEN = pApplet.loadImage(Image.BLACK_QUEEN.getFile());
        this.WHITE_QUEEN = pApplet.loadImage(Image.WHITE_QUEEN.getFile());
        this.BLACK_KNIGHT = pApplet.loadImage(Image.BLACK_KNIGHT.getFile());
        this.WHITE_KNIGHT = pApplet.loadImage(Image.WHITE_KNIGHT.getFile());
        this.BLACK_PAWN = pApplet.loadImage(Image.BLACK_PAWN.getFile());
        this.WHITE_PAWN = pApplet.loadImage(Image.WHITE_PAWN.getFile());
        this.BLACK_ROOK = pApplet.loadImage(Image.BLACK_ROOK.getFile());
        this.WHITE_ROOK = pApplet.loadImage(Image.WHITE_ROOK.getFile());
    }

    /**
     * Dibuja en la tabla una imagen
     * @param piece the Piece cuya imagen se dibujará
     */
    public void drawImage(Piece piece) {
        // La posición del tablero
        int x = piece.getPosition().getX() * BOX;
        int y = (7 - piece.getPosition().getY()) * BOX;

        if(piece.getType() != PieceType.EMPTY){
            pApplet.image(getImage(piece), x, y);
        }
    }

    /**
     *  Obtiene la imagen dada una pieza, en base a su color y tipo
     * @param pieza un pedazo del tablero
     * @ devolver una imagen
     */
    private PImage getImage(Piece piece) {
        switch (piece.getType()) {
        case PAWN:
            return (piece.getColor() == ColorEnum.BLACK) ? BLACK_PAWN : WHITE_PAWN;
        case KING:
            return (piece.getColor() == ColorEnum.BLACK) ? BLACK_KING : WHITE_KING;
        case QUEEN:
            return (piece.getColor() == ColorEnum.BLACK) ? BLACK_QUEEN : WHITE_QUEEN;
        case BISHOP:
            return (piece.getColor() == ColorEnum.BLACK) ? BLACK_BISHOP : WHITE_BISHOP;
        case KNIGHT:
            return (piece.getColor() == ColorEnum.BLACK) ? BLACK_KNIGHT : WHITE_KNIGHT;
        case ROOK:
            return (piece.getColor() == ColorEnum.BLACK) ? BLACK_ROOK: WHITE_ROOK;
        default:
            return null;
        }
    }

}
