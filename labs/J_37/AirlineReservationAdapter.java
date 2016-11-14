import java.io.*;
import java.util.NoSuchElementException;

/**
 * Created by zehaeva on 11/10/16.
 */
public class AirlineReservationAdapter implements Runnable {
    private AirlineReservationModel _old_system;
    private Thread _p;
    private ByteArrayInputStream bais;
    private PrintStream old;
    private PrintStream ps;
    private ByteArrayOutputStream baos;

    private boolean _first_run;

    public AirlineReservationAdapter() {
        this._first_run = true;

    //  set up baos and it's printstream
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);

    //  save old system.out
        old = System.out;

    //  set system out to the bytestream
        System.setOut(ps);

        this.bais = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(bais);

        this._p = new Thread(this);

        this._p.start();
    }

    public String getEconomy() {
        try {
            continueInput();

            baos.reset();
            //this.bais.reset();
            //bais.read("\n1".getBytes());
            this.bais = new ByteArrayInputStream("1".getBytes());
            Thread.sleep(50);
        } catch (InterruptedException ex) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "This is what I got\n" + baos.toString();
    }

    private void continueInput() throws InterruptedException, IOException {
        if (this._first_run) {
            this._first_run = false;
        }
        else {
            bais.read("y\n".getBytes());
            Thread.sleep(50);
            System.out.flush();
        }
    }

    public String getFirstClass() {
        try {
            continueInput();
            bais.read("2\n".getBytes());
            Thread.sleep(50);
            System.out.flush();
        } catch (InterruptedException ex) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "This is what I got\n" + baos.toString();
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
