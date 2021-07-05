import java.util.Objects;

public class Cell {
    int row;
    int column;
    int distance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return row == cell.row && column == cell.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
