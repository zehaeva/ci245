import java.awt.*;

/**
 * Created by zehaeva on 10/30/16.
 */
public abstract class MyBoundedShape extends MyShape {
    private boolean _filled;

    public MyBoundedShape() {
        super();
        this._filled = false;
    }

    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color);
        this._filled = filled;
    }

    @Override
    public int getX1() {
        if (super.getX2() < super.getX1()) {
            return super.getX2();
        } else {
            return super.getX1();
        }
    }

    @Override
    public int getY1() {
        if (super.getY2() < super.getY1()) {
            return super.getY2();
        } else {
            return super.getY1();
        }
    }

    @Override
    public int getX2() {
        if (super.getX2() > super.getX1()) {
            return super.getX2();
        } else {
            return super.getX1();
        }
    }

    @Override
    public int getY2() {
        if (super.getY2() > super.getY1()) {
            return super.getY2();
        } else {
            return super.getY1();
        }
    }

    public boolean isFilled() {
        return _filled;
    }

    public void setFilled(boolean filled) {
        this._filled = filled;
    }

    public int getHeight() {
        return getY2() - getY1();
    }

    public int getWidth() {
        return getX2() - getX1();
    }
}
