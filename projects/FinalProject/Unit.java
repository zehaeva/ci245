import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

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
    protected ArrayList<Point> _possible_moves;
    protected ArrayList<Point> _attack_patterns;

    protected int _damage_dice_sides;
    protected int _damage_dice_count;
    protected int _damage_modifier;

    protected int _defense;
    protected int _hit_points;
    private boolean _moving;

//  so facing works like this,
//  0 then there's no facing
//  1 then you're facing in the positive direction on that axis
//  -1 facing the negative direction on that axis
    protected Point _facing;

    public Unit(int x, int y, int size, Color color, Point facing) {
        this(x, y, size, 0, 0, color, facing);
    }

    public Unit(int x, int y, int size, int speedX, int speedY, Color color, Point facing) {
        this._size = size;
        this._velocity = new Point(speedX, speedY);
        this._color = color;
        this._color_base = color;
        this._color_selected = Color.cyan;
        this._selected = false;
        this._damage_dice_sides = 4;
        this._damage_dice_count = 1;
        this._damage_modifier = 0;
        this._defense = 0;
        this._possible_moves = new ArrayList<>();
        this._attack_patterns = new ArrayList<>();
        this.setPosition(new Point(x, y));
        this._facing = facing;
    }

    /**
     * returns the grids coordinates of the unit
     * @return
     */
    public Point getPosition() {
        return _position;
    }

    /**
     * sets the grids coordinates of the unit
     */
    public void setPosition(Point position) {
        this._position = position;
        this.drawShape();
    }

    /**
     * returns the pixel position of this object
     * @return
     */
    public Point getPixelPosition() {
        return new Point(this._position.x * this._size, this._position.y * this._size);
    }

    /**
     * sets the grid position of the unit based on the pixel position
     * @return
     */
    public void setPixelPosition(Point point) {
        this.setPosition(new Point(((point.x / this._size) * this._size) / this._size,
                ((point.y / this._size) * this._size) / this._size));
    }

    /**
     * returns unit's name
     * @return
     */
    public String getName() {
        return _name;
    }

    /**
     * sets unit's name
     * @param Name
     */
    public void setName(String Name) {
        this._name = Name;
    }

    /**
     * gets the unit's pixel size
     * @return
     */
    public int getUnitSize() {
        return _size;
    }

    public void drawShape() {
        this._shape = new Ellipse2D.Double(this._position.x * this._size, this._position.y * this._size,
                this._size, this._size);
    }

    public void setUnitSize(int size) {
        this._size = size;
    }

    /**
     * returns the unit vector the unit is facing
     * (1, 0) facing in the positive x axis
     * (-1, 0) facing in the negative x axis
     * (0, 1) facing in the positive y axis
     * (0, -1) facing in negative y axis
     * @return
     */
    public Point getFacing() {
        return _facing;
    }

    /**
     * returns the unit vector the unit is facing
     * (1, 0) facing in the positive x axis
     * (-1, 0) facing in the negative x axis
     * (0, 1) facing in the positive y axis
     * (0, -1) facing in negative y axis
     * @return
     */
    public void setFacing(Point facing) {
        this._facing = facing;
    }

    public boolean isAlive() {
        if (this._hit_points > 0) {
            return true;
        }
        else {
            return false;
        }
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

    /**
     * sets the selected values for this unit
     */
    public void select() {
        this._selected = true;
        this._color = this._color_selected;
    }

    /**
     * unselects this unit
     */
    public void unSelect() {
        this._selected = false;
        this._color = this._color_base;
    }

    /**
     * gets the damage that this unit dishes out!
     * @return amount of damage done
     */
    public int attack() {
        Random rand = new Random();
        int dice_sum = 0;
        for (int i = 0; i < this._damage_dice_count; i++) {
            dice_sum += rand.nextInt(this._damage_dice_sides) + 1;
        }

        return dice_sum + this._damage_modifier;
    }

    /**
     * the damage reduction of this unit
     * @return amount of damage reduction
     */
    public int defend() {
        return 0;
    }

    /**
     * subtracts the damage done from this units hp, returns current hp
     * @param damage amount of damage done to this unit
     * @return hp left
     */
    public int takeDamage(int damage) {
        this._hit_points -= damage;
        return this._hit_points;
    }

    /**
     * returns current hit points
     * @return current hitpoints
     */
    public int getHitPoints() {
        return this._hit_points;
    }

    /**
     * Returns an ArrayList of all the GridSpaces this unit can move to
     * Based on the _possible_moves pattern
     * @return
     */
    public ArrayList<GridSpace> getPossibleMoves() {
        Color c = Color.green;
        Dimension d = new Dimension(this._size, this._size);
        ArrayList<GridSpace> s = new ArrayList<>();
        Point point;
        for (Point p : this._possible_moves) {
            point = this.getFacingModifier(p);
            s.add(new GridSpace(c, new Point(this._position.x + point.x, this._position.y + point.y), d));
        }
        return s;
    }

    /**
     * Returns an ArrayList of all the Grid Spaces that this unit can attack
     * Based on the _attack_patterns defined in the constructors
     * @return
     */
    public ArrayList<GridSpace> getPossibleAttacks() {
       Color c = Color.red;
        Dimension d = new Dimension(this._size, this._size);
        ArrayList<GridSpace> s = new ArrayList<>();
        Point point;
        for (Point p : this._attack_patterns) {
            point = this.getFacingModifier(p);
            s.add(new GridSpace(c, new Point(this._position.x + point.x, this._position.y + point.y), d));
        }
        return s;
    }

    public void setMoving(boolean moving) {
        this._moving = moving;
    }

    public boolean isMoving() {
        return this._moving;
    }

    protected Point getFacingModifier(Point point) {
        Point my_return;
        if (this._facing.y == 1) {
            my_return = new Point(point.x, point.y);
        }
        else if(this._facing.y == -1) {
            my_return = new Point(point.x * -1, point.y * -1);
        }
        else if(this._facing.x == 1) {
            my_return = new Point(point.y , point.x * -1);
        }
        else {
            my_return = new Point(point.y * -1, point.x * -1);
        }
        return my_return;
    }
}
