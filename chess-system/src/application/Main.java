package application;

import java.util.Scanner;

import chess.ChessMatch;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

        sc.close();
    }
}
