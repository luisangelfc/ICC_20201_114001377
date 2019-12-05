package app;

enum Image{

    BLACK_PAWN("black-pawn-96.png"),
    WHITE_PAWN("blue-pawn-96.png"),
    BLACK_QUEEN("black-queen-96.png"),
    WHITE_QUEEN("blue-queen-96.png"),
    BLACK_KING("black-king-96.png"),
    WHITE_KING("blue-king-96.png"),
    BLACK_BISHOP("black-bishop-96.png"),
    WHITE_BISHOP("blue-bishop-96.png"),
    BLACK_KNIGHT("black-knight-96.png"),
    WHITE_KNIGHT("blue-knight-96.png"),
    BLACK_ROOK("black-rook-96.png"),
    WHITE_ROOK("blue-rook-96.png");
    

    private final String file;

    private Image(String file) {
        this.file = file;
    }

    public String getFile(){
        return file;
    }

}