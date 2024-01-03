package strategy;

import model.Game;

public interface WinningStrategy {
    void check(int row, int col, Game game);
}
