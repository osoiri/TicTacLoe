package model;

/**
 * Player entity.
 */
public class Player {
    private final String userId;
    private final String symbol;
    private final PlayerType playerType;

    public Player(String userId, String symbol, PlayerType playerType) {
        this.userId = userId;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getUserId() {
        return userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userId='" + userId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", playerType=" + playerType +
                '}';
    }
}
