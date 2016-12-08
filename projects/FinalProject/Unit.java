import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by zehaeva on 10/23/2016.
 */
public abstract class Unit extends JComponent {
    protected Point _position;
    protected int _size;
    protected String _name;
    protected Point _velocity;
    protected Color _color;
    protected Color _color_base;
    protected Color _color_selected;
    protected Shape _shape;
    protected boolean _selected;
    protected ArrayList<GridSpace> _possible_moves;

    protected int _damage_dice_sides;
    protected int _damage_dice_count;
    protected int _damage_modifier;

    public Unit(int x, int y, int size, Color color) {
        this(x, y, size, 0, 0, color);
    }

    public Unit(int x, int y, int size, int speedX, int speedY, Color color) {
        this._size = size;
        this._velocity = new Point(speedX, speedY);
        this._color = color;
        this._color_base = color;
        this._color_selected = Color.cyan;
        this._selected = false;
        this._damage_dice_sides = 4;
        this._damage_dice_count = 1;
        this._damage_modifier = 0;
        this._possible_moves = new ArrayList<>();
        this.setPosition(new Point(x, y));
    }

    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point position) {
    //  thx position should always be a multiple of the size
        if (position.x % this._size != 0) {
            position.x = (int)(position.x / this._size) * this._size;
        }
        if (position.y % this._size != 0) {
            position.y = (int)(position.y / this._size) * this._size;
        }
        this._position = position;
        this.drawShape();
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

    public void drawShape() {
        this._shape = new Ellipse2D.Double(this._position.x, this._position.y, this._size, this._size);
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
        if (selected) {
            this.select();
        }
        else {
            this.unSelect();
        }
    }

    public void select() {
        this._selected = true;
        this._color = this._color_selected;
    }

    public void unSelect() {
        this._selected = false;
        this._color = this._color_base;
    }

    public abstract ArrayList<GridSpace> getPossibleMoves();

    public abstract ArrayList<GridSpace> getPossibleAttacks();
}
