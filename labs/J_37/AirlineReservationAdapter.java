import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by zehaeva on 11/10/16.
 */
public class AirlineReservationAdapter {
    private AirlineReservationModel _old_system;

    public AirlineReservationAdapter() {

    //  set up baos and it's printstream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
    //  save old system.out
        PrintStream old = System.out;
    //  set system out to the bytestream
        System.setOut(ps);

    //  set up bais and it's inputstream
        //ByteArrayInputStream bais = new ByteArrayInputStream("1\n".getBytes());
        //System.setIn(bais);

        this._old_system = new AirlineReservationModel();
        this._old_system.startEngine(new String[] {});

        System.out.flush();
        System.setOut(old);

        System.out.println("This is what I got\n" + baos.toString());
    }

    public String getEconomy() {
        return "";
    }
}
