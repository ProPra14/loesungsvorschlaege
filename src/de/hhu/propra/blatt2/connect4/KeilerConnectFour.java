package de.hhu.propra.blatt2.connect4;

import de.hhu.propra.blatt3.connect4.GuiBoardPrinter;

public class KeilerConnectFour {
    private static final int WIDTH = 7;
    private static final int HEIGHT = 6;

    private final Board board;
    private final BoardPrinter boardPrinter;

    public KeilerConnectFour(BoardPrinter boardPrinter, Board board) {
        this.boardPrinter = boardPrinter;
        this.board = board;
    }

    public static void main(String[] args) {
        Board board = new Board(WIDTH, HEIGHT);
        BoardPrinter boardPrinter = args.length == 0 ? new ConsoleBoardPrinter(board) : new GuiBoardPrinter(board);
        KeilerConnectFour keilerConnectFour = new KeilerConnectFour(boardPrinter, board);

        boardPrinter.greetPlayer();
        keilerConnectFour.play();
    }

    private void play() {
        do {
            boardPrinter.askPlayer();
            boardPrinter.drawBoard();
            if (board.hasWon()) {
                boardPrinter.showWinMessage("Player " + board.getCurrentPlayer() + " winzzz");
            }
        } while (!board.hasWon());
    }
}