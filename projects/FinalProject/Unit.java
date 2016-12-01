import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

/**
 * Created by zehaeva on 10/23/2016.
 */
public class Unit extends JComponent implements MouseListener {
    private Point _position;
    private int _size;
    private String _name;
    private Point _velocity;
    private Color _color;
    private Shape _shape;
    private boolean _selected;

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

    public Unit(int x, int y, int size, Color color) {
        this._position = new Point(x, y);
        this._size = size;
        this._velocity = new Point(0, 0);
        this._color = color;
    }

    public Unit(int x, int y, int size, int speedX, int speedY, Color color) {
        this._position = new Point(x, y);
        this._size = size;
        this._velocity = new Point(speedX, speedY);
        this._color = color;
        this._shape = new Ellipse2D.Double(x, y, size, size);
        this._selected = false;
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

    public int getUnitSize() {
        return _size;
    }

    public void setUnitSize(int size) {
        this._size = size;
    }

    public Color getColor() {
        return _color;
    }

    public void setColor(Color color) {
        this._color = color;
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

    public void moveUnit(int x, int y) {
        this._position.x += x;
        this._position.y += y;
    }

    public Shape getShape() {
        return this._shape;
    }

    public void setShape(Shape shape) {
        this._shape = shape;
    }

    public boolean isSelected() {
        return this._selected;
    }

    public void setSelected(boolean selected) {
        this._selected = selected;
    }

    public void select() {
        this._selected = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
