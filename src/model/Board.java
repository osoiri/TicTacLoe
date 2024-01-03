package model;

import exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Board entity.
 */
public class Board {
    private final List<List<Cell>> cells;

    public Board() {
        List<List<Cell>> cells = new ArrayList<>();
        for (int i=0; i<3;i++) {
            List<Cell> rowCell = new ArrayList<>();
            for(int j=0;j<3;j++) {
                rowCell.add(new Cell(i, j));
            }
            cells.add(rowCell);
        }
        this.cells = cells;
    }

    public Cell getCellAvailable(int x){
        int row = (x-1)/3;
        int col = (x-1)%3;

        final Cell cell = cells.get(row).get(col);
        if (CellStatus.EMPTY == cell.getCellStatus()) {
            return cell;
        }
        throw new ServiceException("The cell is already occupied!");
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Cell> rowCell: cells) {
            for (Cell cell: rowCell) {
                if (CellStatus.EMPTY == cell.getCellStatus()) {
                    sb.append("| - |");
                } else if (CellStatus.OCCUPIED == cell.getCellStatus()) {
                    sb.append(String.format("| %s |", cell.getPlayer().getSymbol()));
                } else {
                    throw new ServiceException(
                            String.format("CellStatus: %s cannot be processed.",
                                    cell.getCellStatus()));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
