import java.awt.*;

/**
 * Created by zehaeva on 11/30/2016.
 */
public class UnitFactory {
    private static Dimension _grid_size;

    public static void setGridSize(Dimension gridSize) {
        _grid_size = gridSize;
    }

    public static Unit createUnit(String unitName, Point position, Color color) {
        switch (unitName.toLowerCase()) {
            case "knight":
                return new Knight(position.x, position.y, _grid_size.height, color, new Point(0, 1));
            case "pawn":
            default:
                return new Pawn(position.x, position.y, _grid_size.height, color, new Point(0, 1));
        }
    }
}
