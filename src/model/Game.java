package model;

import java.util.List;
import java.util.Stack;

/**
 * Game entity.
 */
public class Game {
    private final List<Player> players;
    private final Board board;
    private final Stack<Cell> moveHistory;
    private GameState state;
    private int currentPlayer;
    private Player winner;
    private int turnCount;

    private Game(Builder builder) {
        this.players = builder.players;
        this.board = new Board();
        this.moveHistory = new Stack<>();
        this.state = GameState.NEW;
        this.currentPlayer = 0;
        this.turnCount = 0;
    }

    public int incrementTurnCount() {
        return ++this.turnCount;
    }

    public int decrementTurnCount() {
        return --this.turnCount;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Stack<Cell> getMoveHistory() {
        return moveHistory;
    }

    public GameState getState() {
        return state;
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayer);
    }

    public int getCurrentPlayerPosition() {
        return this.currentPlayer;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private List<Player> players;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
