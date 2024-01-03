import controller.GameController;
import exception.ServiceException;
import model.Game;
import model.GameState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final GameController controller;
        System.out.println("Welcome to Tic-Tac-Toe ---------------------------");
        System.out.println("Enter Game Mode - 1 'OR' 2\n1. vs Bot 2. vs Player");
        int choice = 0;
        while (choice == 0) {
            choice = sc.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Please choose from 1 'OR' 2");
            }
        }
        if (choice == 1) {
            System.out.println("Enter userId:");
            String userId = sc.next();
            System.out.println("Enter symbol");
            String symbol = sc.next();
            controller = new GameController(userId, symbol);
        } else {
            System.out.println("Player 1 --------------------");
            System.out.println("Enter userId:");
            String userId = sc.next();
            System.out.println("Enter symbol");
            String symbol = sc.next();
            System.out.println("Player 2 --------------------");
            System.out.println("Enter userId:");
            String userIdTwo = sc.next();
            System.out.println("Enter symbol");
            String symbolTwo = sc.next();
            controller = new GameController(userId, symbol, userIdTwo, symbolTwo);
        }

        while (true) {
            Game game = controller.getGame();
            System.out.println("Player " +
                    game.getCurrentPlayer().getUserId() +
                    " Enter Cell between 1 to 9");
            int x = sc.nextInt();
            try {
                game = controller.continueUserGame(x);
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println(game.getBoard());
            if (controller.getGame().getState() == GameState.COMPLETE
                    || controller.getGame().getState() == GameState.DRAW) {
                break;
            }
            System.out.println("Do you want to undo last move? Enter \"y\" to confirm.");
            String changeLastMove = sc.next();
            if ("y".equalsIgnoreCase(changeLastMove)) {
                game = controller.undoUserGame();
                System.out.println(game.getBoard());
            } else {
                String statement = controller.rotateCurrentPlayer();
                if (statement != null) {
                    System.out.println(statement);
                }
            }
        }

        if (controller.getGame().getState() == GameState.COMPLETE) {
            System.out.println(controller.getGame().getWinner().getUserId() + " WINS >(^<>^)<");
        } else {
            System.out.println("DRAW ----------> ,(-+-),");
        }

        sc.close();
    }
}
