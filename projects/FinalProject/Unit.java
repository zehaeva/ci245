import java.awt.*;

/**
 * Created by zehaeva on 10/23/2016.
 */
public class Unit {
    private Point _position;
    private int _size;
    private String _name;
    private Point _velocity;

    public Unit(Point position) {
        this._position = position;
    }

    public Unit(Point position, int size) {
        this._position = position;
        this._size = size;
    }

    public Unit(int x, int y) {
        this._position = new Point(x, y);
    }

    public Unit(int x, int y, int size) {
        this._position = new Point(x, y);
        this._size = size;
        this._velocity = new Point(0, 0);
    }

    public Unit(int x, int y, int size, int speedX, int speedY) {
        this._position = new Point(x, y);
        this._size = size;
        this._velocity = new Point(speedX, speedY);
    }

    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point Position) {
        this._position = Position;
    }

    public String getName() {
        return _name;
    }

    public void setName(String Name) {
        this._name = Name;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        this._size = size;
    }

    public int width() {
        return this._size;
    }
    public int height() {
        return this._size;
    }

    public int x() {
        return this._position.x;
    }

    public int y() {
        return this._position.y;
    }

    public void move(int x, int y) {
        this._position.x += x;
        this._position.y += y;
    }

    public void draw(Graphics g) {
        g.drawOval(this._position.x, this._position.y, this._size, this._size);
    }
}
