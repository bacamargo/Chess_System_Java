package application;

import java.util.Scanner;

import boardgame.Board;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Board board = new Board(2, 3);
        System.out.println(board);

        sc.close();
    }
}
