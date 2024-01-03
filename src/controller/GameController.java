package controller;

import model.Game;
import model.Player;
import model.PlayerType;
import service.GameService;

import java.util.Arrays;

/**
 * Expose API to client.
 */
public class GameController {
    public Game game;
    public GameService service;
    private static final String BOT_ID = "TICTACBOT";
    private static final String BOT_SYMBOL = "+";

    public GameController(String userId, String symbol) {
        final Player playerOne = new Player(userId, symbol, PlayerType.HUMAN);
        final Player playerTwo = new Player(BOT_ID, BOT_SYMBOL, PlayerType.BOT);
        this. game = Game.getBuilder()
                .setPlayers(
                        Arrays.asList(playerOne, playerTwo)
                )
                .build();
        this.service = new GameService();
    }

    public GameController(String userId, String symbol, String userIdTwo, String symbolTwo) {
        final Player playerOne = new Player(userId, symbol, PlayerType.HUMAN);
        final Player playerTwo = new Player(userIdTwo, symbolTwo, PlayerType.HUMAN);
        this. game = Game.getBuilder()
                .setPlayers(
                        Arrays.asList(playerOne, playerTwo)
                )
                .build();
        this.service = new GameService();
    }

    public Game continueUserGame(int x) {
        service.executeOneTurn(x, game);
        return game;
    }

    public Game undoUserGame() {
        service.undoUserGame(game);
        return game;
    }

    public String rotateCurrentPlayer() {
        String botStatement = null;
        service.rotateCurrentPlayer(game);
        if (game.getPlayers().get(game.getCurrentPlayer()).getPlayerType() == PlayerType.BOT) {
            int x = service.getBotMove(game);
            service.executeOneTurn(x, game);
            botStatement = "Player"
                    + game.getPlayers().get(game.getCurrentPlayer()).getUserId()
                    + " Enter Cell between 1 to 9\n"
                    + x
                    +"\n"
                    + game.getBoard().toString();
            service.rotateCurrentPlayer(game);
        }

        return botStatement;
    }

    public Game getGame() {
        return game;
    }
}
