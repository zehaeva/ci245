import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.NoSuchElementException;

/**
 * Created by zehaeva on 11/10/16.
 */
public class AirlineReservationAdapter extends WindowAdapter implements Runnable {
    private boolean _economy_full;
    private AirlineReservationModel _old_system;
    private Thread _p;
    private PipedInputStream pis;
    private PrintStream old;
    private PrintStream ps;
    private ByteArrayOutputStream baos;
    private PipedOutputStream pos;

    private boolean _first_run;
    private boolean _first_class_full;

    public AirlineReservationAdapter() {
        this._first_run = true;
        this._first_class_full = false;
        this._economy_full = false;

    //  set up baos and it's printstream
        this.baos = new ByteArrayOutputStream();
        this.pos = new PipedOutputStream();
        this.ps = new PrintStream(this.baos);

    //  save old system.out
        this.old = System.out;

    //  set system out to the printstream
        System.setOut(this.ps);

        this.pis = new PipedInputStream();
        try {
            this.pis.connect(this.pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(this.pis);

        this._p = new Thread(this);

        this._p.start();
    }

    public String getEconomy() {
        try {
            if (!this._first_run) {
                this.pos.write("y\n".getBytes());
            }
            this._first_run = false;
            this.pos.write("2\n".getBytes());
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int last_line = this.baos.toString().lastIndexOf("\n");
        if (this.baos.toString().substring(last_line).indexOf("is First Class acceptable") > 0) {
            this._first_class_full = true;
        }

        return this.baos.toString();
    }

    public String getFirstClass() {
        try {
            if (!this._first_run) {
                this.pos.write("y\n".getBytes());
            }
            this._first_run = false;
            this.pos.write("1\n".getBytes());
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int last_line = this.baos.toString().lastIndexOf("\n");
        if (this.baos.toString().substring(last_line).indexOf("is Economy acceptable") > 0) {
            this._first_class_full = true;
        }

        return this.baos.toString();
    }

    public boolean isFirstClassFull() {
        return this._first_class_full;
    }

    public boolean isEconomyFull() {
        return this._economy_full;
    }

    @Override
    public void run() {
        this._old_system.startEngine(new String[]{});
        this.baos.toString();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void windowClosing(WindowEvent e) {
        _p.interrupt();
    }
}
