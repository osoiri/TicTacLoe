package model;

/**
 * Cell entity.
 */
public class Cell {
    private final int row;
    private final int col;
    private CellStatus cellStatus = CellStatus.EMPTY;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
