package strategy;

import model.Board;
import model.CellStatus;
import model.Game;

public class WinningLeftDiagonalStrategy implements WinningStrategy {
    @Override
    public void check(int row, int col, Game game) {
        Board board = game.getBoard();
        for (int i=0; i<3; i++) {
            if (board.getCells().get(i).get(i).getCellStatus() == CellStatus.EMPTY
                    || board.getCells().get(i).get(i).getPlayer() != game.getCurrentPlayer()) {
                return;
            }
        }
        game.setWinner(game.getCurrentPlayer());
    }
}
