import java.awt.*;

/**
 * Created by zehaeva on 10/30/16.
 */
public abstract class MyShape {
    private int _x1;
    private int _y1;
    private int _x2;
    private int _y2;
    private Color _color;

    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this._x1 = x1;
        this._y1 = y1;
        this._x2 = x2;
        this._y2 = y2;
        this._color = color;
    }

    public MyShape() {
        this._x1 = 0;
        this._y1 = 0;
        this._x2 = 0;
        this._y2 = 0;
        this._color = Color.BLACK;
    }

    public int getX1() {
        return _x1;
    }

    public void setX1(int x1) {
        this._x1 = x1;
    }

    public int getY1() {
        return _y1;
    }

    public void setY1(int y1) {
        this._y1 = y1;
    }

    public int getX2() {
        return _x2;
    }

    public void setX2(int x2) {
        this._x2 = x2;
    }

    public int getY2() {
        return _y2;
    }

    public void setY2(int y2) {
        this._y2 = y2;
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color color) {
        this._color = color;
    }

    public abstract void draw(Graphics g);

}
