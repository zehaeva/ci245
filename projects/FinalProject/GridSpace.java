import java.awt.*;

/**
 * Created by hcanaway on 12/8/2016.
 */
public class GridSpace {
    protected Color _border;
    protected Point _position;
    protected Dimension _size;

    public GridSpace(Color border, Point position, Dimension size) {
        this._border = border;
        this._position = position;
        this._size = size;
    }

    public Color getBorderColor() {
        return _border;
    }

    public void setBorderColor(Color border) {
        this._border = _border;
    }

    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point position) {
        this._position = position;
    }

    public Point getPixelPosition() {
        return new Point(this._position.x * this._size.width, this._position.y * this._size.height);
    }

    public Dimension getSize() {
        return _size;
    }

    public void setSize(Dimension size) {
        this._size = size;
    }

    public boolean contains(Point point) {
        return this.contains(point.x, point.y);
    }

    public boolean contains(int x, int y) {
        if (this._position.x == x && this._position.y == y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsPixel(Point point) {
        return this.containsPixel(point.x, point.y);
    }

    public boolean containsPixel(int x, int y) {
        Rectangle rect = new Rectangle(this._position.x * this._size.width, this._position.y * this._size.height,
                this._size.width, this._size.height);
        if (rect.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridSpace gridSpace = (GridSpace) o;

        if (_border != null ? !_border.equals(gridSpace._border) : gridSpace._border != null) return false;
        if (_position != null ? !_position.equals(gridSpace._position) : gridSpace._position != null) return false;
        return _size != null ? _size.equals(gridSpace._size) : gridSpace._size == null;
    }

    @Override
    public int hashCode() {
        int result = _border != null ? _border.hashCode() : 0;
        result = 31 * result + (_position != null ? _position.hashCode() : 0);
        result = 31 * result + (_size != null ? _size.hashCode() : 0);
        return result;
    }
}
