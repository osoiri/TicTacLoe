package service;

import controller.GameController;
import exception.ServiceException;
import model.Cell;
import model.CellStatus;
import model.Game;
import model.GameState;

import java.util.List;

/**
 * Service class for processing one turn of game.
 */
public class GameService {
    /**
     * Check Cell available, then update Cell and MoveHistory, then check
     * player won, then mark game complete.
     *
     * @param x cell to update
     * @param game the current game
     */
    public void executeOneTurn(int x, Game game) {
        if (game.getState() == GameState.NEW) {
            game.setState(GameState.IN_PROGRESS);
        }

        final Cell cell = game.getBoard().getCellAvailable(x);
        cell.setCellStatus(CellStatus.OCCUPIED);
        cell.setPlayer(game.getPlayers().get(game.getCurrentPlayer()));

        game.getMoveHistory().add(cell);


    }

    public void undoUserGame(Game game) {
        game.getMoveHistory().pop().setCellStatus(CellStatus.EMPTY);
    }

    public void rotateCurrentPlayer(Game game) {
        game.setCurrentPlayer((game.getCurrentPlayer() + 1)%2);
    }

    public int getBotMove(Game game) {
        int counter = 0;
        for (List<Cell> rowCell: game.getBoard().getCells()) {
            for (Cell cell: rowCell) {
                counter++;
                if (cell.getCellStatus() == CellStatus.EMPTY) {
                    return counter;
                }
            }
        }
        throw new ServiceException("No cells empty and yet game is not over.");
    }
}
