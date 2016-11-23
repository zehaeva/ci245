import java.io.*;
import java.util.NoSuchElementException;

/**
 * Created by zehaeva on 11/10/16.
 */
public class AirlineReservationAdapter implements Runnable {
    private AirlineReservationModel _old_system;
    private Thread _p;
    private PipedInputStream pis;
    private PrintStream old;
    private PrintStream ps;
    private ByteArrayOutputStream baos;
    private PipedOutputStream pos;

    private boolean _first_run;

    public AirlineReservationAdapter() {
        this._first_run = true;

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
            this.pos.write("2\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "This is what I got\n" + this.baos.toString();
    }
//
//    private void continueInput() throws InterruptedException, IOException {
//        if (this._first_run) {
//            this._first_run = false;
//        }
//        else {
//            bais.read("y\n".getBytes());
//            Thread.sleep(50);
//            System.out.flush();
//        }
//    }

    public String getFirstClass() {
        try {
            this.ps.flush();
            this.pos.write("1\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "This is what I got\n" + this.baos.toString();
    }

    @Override
    public void run() {
        this._old_system.startEngine(new String[]{});
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
