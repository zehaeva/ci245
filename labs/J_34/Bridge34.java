import java.util.concurrent.Semaphore;

/**
 * Created by zehaeva on 11/3/16.
 */
public class Bridge34 {
    private Troll34 _my_troll;
    private int _count;
    private static int MAX_ON_BRIDGE;

    public Bridge34(int permits) {

        this.MAX_ON_BRIDGE = permits;
        this._my_troll = new Troll34(this, permits);
    }

    public void removeWoolie() {
        this._count--;
    }

    public void addWoolie() {
        this._count++;
    }

    public Troll34 getTroll() {
        return this._my_troll;
    }

    public boolean isFull() {
        return (this._count >= this.MAX_ON_BRIDGE);
    }
}


