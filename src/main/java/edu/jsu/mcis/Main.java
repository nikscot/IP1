package edu.jsu.mcis;

import java.awt.*;
import java.util.*;

public class Main {
    private static final Scanner key = new Scanner(System.in);

    private static Point getPlayerMove() {
        System.out.print("Enter a location: ");
        int row = key.nextInt();
        int col = key.nextInt();
        return new Point(row, col);
    }
    
    private static void controlModel(TicTacToe model) {
        boolean success = false;
        while(!success) {
            Point move = getPlayerMove();
            success = model.setMark(move.x, move.y);
            if(!success) {
                System.out.println("The location (" + move.x + ", " + move.y + ") is not valid. Choose again.");
            }
        }
    }
    
    private static void viewModel(TicTacToe model) {
        System.out.println("\n" + model + "\n");
    }

	public static void main(String[] args) {
        TicTacToe model = new TicTacToe();
        TicTacToe.Result result = TicTacToe.Result.NONE;
        while(result == TicTacToe.Result.NONE) {
            String turn = (model.changeToX())? "X" : "O";
            viewModel(model);
            System.out.println("It is " + turn + "'s turn.");
            controlModel(model);
            result = model.getResult();
        }
        String outcome = "The game is a tie.";
        if(result == TicTacToe.Result.XWINS) outcome = "X wins!";
        else if(result == TicTacToe.Result.OWINS) outcome = "O wins!";
        System.out.println(outcome);
	}
}














