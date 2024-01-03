package factory;

import strategy.*;

import java.util.ArrayList;
import java.util.List;

public class WinningFactory {
    private final WinningStrategy winningColumnStrategy;
    private final WinningStrategy winningRowStrategy;
    private final WinningStrategy winningLeftDiagonalStrategy;
    private final WinningStrategy winningRightDiagonalStrategy;

    public WinningFactory() {
        this.winningColumnStrategy = new WinningColumnStrategy();
        this.winningRowStrategy = new WinningRowStrategy();
        this.winningLeftDiagonalStrategy = new WinningLeftDiagonalStrategy();
        this.winningRightDiagonalStrategy = new WinningRightDiagonalStrategy();
    }

    public List<WinningStrategy> getWinningStrategies(int x, int y) {
        List<WinningStrategy> strategyList = new ArrayList<>();
        strategyList.add(winningRowStrategy);
        strategyList.add(winningColumnStrategy);
        if (x == y) {
            strategyList.add(winningLeftDiagonalStrategy);
        }
        if ((x + y) == 2) {
            strategyList.add(winningRightDiagonalStrategy);
        }
        return strategyList;
    }
}
