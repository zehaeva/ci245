import java.util.concurrent.Semaphore;

/**
 * Created by zehaeva on 11/3/16.
 */
public class Bridge34 extends Semaphore {
    private Troll34 _my_troll;
    private int _count;
    private static int MAX_ON_BRIDGE;

    public Bridge34(int permits) {
        super(permits);
        this.MAX_ON_BRIDGE = permits;
        this._my_troll = new Troll34(this);
    }

    public void leave() {
        this.release();
        this._count--;
    }

    public void enter() {
        try {
            this.acquire();
            this._count++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Troll34 getTroll() {
        return this._my_troll;
    }

    public boolean isFull() {
        return (this._count >= this.MAX_ON_BRIDGE);
    }
}


