import javax.swing.*;
import java.awt.*;

/**
 * Created by zehaeva on 10/30/16.
 */
public class DrawPanel extends JPanel {
    private MyShape[] _myshapes;
    private int _shape_count;
    private int _shape_type;
    private MyShape _current_shape;
    private Color _current_color;
    private boolean _filled_shape;
    private JLabel _status_bar;

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        for (int i = 0; i < this._shape_count; i++) {
            this._myshapes[i].draw(g);
        }

        if (this._current_shape != null) {
            this._current_shape.setColor(this._current_color);
            this._current_shape.draw(g);
        }
    }

    public void setShapeType(int shapeType) {
        this._shape_type = shapeType;
    }

    public void setCurrentColor(Color currentColor) {
        this._current_color = currentColor;
    }

    public void setFilledShape(boolean filledShape) {
        this._filled_shape = filledShape;
    }

    public void clearLastShape() {
        if (this._shape_count > 0) {
            this._myshapes[this._shape_count - 1] = null;
            this._shape_count--;
        }
    }

    public void clearDrawing() {
        for (MyShape val :
                this._myshapes) {
            val = null;
        }
        this._shape_count = 0;
    }
}
