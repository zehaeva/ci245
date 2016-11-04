import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by zehaeva on 11/3/16.
 */
public class SlidingFrame extends JFrame implements Runnable {
    private Thread _thread;
    private SlidingPanel _p;

    public SlidingFrame() throws HeadlessException {
        this.setPreferredSize(new Dimension(500, 100));
        this.setTitle("Sliding Rectangles!");

        this._p = new SlidingPanel();
        this.add(this._p);

        this._thread = new Thread(this);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        this.setSize(500, 100);

        addWindowListener(new WindowListener());

        this._thread.start();
    }

    @Override
    public void run() {
        while(true) {
            this.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("End thread");
                return; // stop loop
            }
        }
    }

    private class WindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            _thread.interrupt();
        }
    }
}
