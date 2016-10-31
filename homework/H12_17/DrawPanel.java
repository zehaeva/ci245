import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by zehaeva on 10/30/16.
 */
public class DrawPanel extends JPanel {
    private ArrayList<MyShape> _myshapes;
    private int _shape_count;
    private int _shape_type;
    private MyShape _current_shape;
    private Color _current_color;
    private boolean _filled_shape;
    private JLabel _status_bar;

    public DrawPanel(JLabel statusBar) {
        this._status_bar = statusBar;
        this._shape_type = 0;
        this._current_shape = null;
        this._current_color = Color.black;
        this.setBackground(Color.white);

        this.addMouseListener(new MouseHandler());
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        for (int i = 0; i < this._shape_count; i++) {
            this._myshapes.get(i).draw(g);
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
            this._myshapes.remove(this._shape_count - 1);
            this._shape_count--;
        }

        this.repaint();
    }

    public void clearDrawing() {
        for (MyShape val :
                this._myshapes) {
            val = null;
        }
        this._shape_count = 0;

        this.repaint();
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            switch(_shape_type) {
                case 0:
                    _current_shape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), _current_color);
                    break;
                case 1:
                    _current_shape = new MyOval(e.getX(), e.getY(), e.getX(), e.getY(), _current_color, _filled_shape);
                    break;
                case 2:
                    _current_shape = new MyRectangle(e.getX(), e.getY(), e.getX(), e.getY(), _current_color, _filled_shape);
                    break;
                default:
                    _current_shape = new MyLine(e.getX(), e.getY(), e.getX(), e.getY(), _current_color);
                    break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            _myshapes.add(_current_shape);
            _shape_count = _myshapes.size();
            _current_shape = null;

            repaint();
        }

        public void updateStatus(MouseEvent e) {
            _status_bar.setText(String.format("X: %d, Y: %d", e.getX(), e.getY()));
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            updateStatus(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            _current_shape.setX2(e.getX());
            _current_shape.setY2(e.getY());

            updateStatus(e);

            repaint();
        }
    }
}
