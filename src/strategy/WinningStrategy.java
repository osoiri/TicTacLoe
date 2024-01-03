package strategy;

import model.Board;

public interface WinningStrategy {
    void check(int x, Board board);
}
