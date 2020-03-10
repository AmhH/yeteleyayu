package com.me.demo.sudoku;

public class TestBoard {
    private String board =
            "8 . . . . . . . . \n" +
            ". . 3 6 . . . . . \n" +
            ". 7 . . 9 . 2 . . \n" +
            ". 5 . . . 7 . . . \n" +
            ". . . . 4 5 7 . . \n" +
            ". . . 1 . . . 3 . \n" +
            ". . 1 . . . . 6 8\n" +
            ". . 8 5 . . . 1 . \n" +
            ". 9 . . . . 4 . .";

    private String solution =
            "8 1 2 7 5 3 6 4 9 \n" +
            "9 4 3 6 8 2 1 7 5 \n" +
            "6 7 5 4 9 1 2 8 3 \n" +
            "1 5 4 2 3 7 8 9 6 \n" +
            "3 6 9 8 4 5 7 2 1 \n" +
            "2 8 7 1 6 9 5 3 4 \n" +
            "5 2 1 9 7 4 3 6 8 \n" +
            "4 3 8 5 2 6 9 1 7 \n" +
            "7 9 6 3 1 8 4 5 2";



    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
