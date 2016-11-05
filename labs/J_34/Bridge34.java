import java.util.concurrent.Semaphore;

/**
 * Created by zehaeva on 11/3/16.
 */
public class Bridge34 extends Semaphore {
    private Troll34 _my_troll;

    public Bridge34(int permits) {
        super(permits);
    }

    public void leave() {
        this.release();
    }

    public void enter() {
        try {
            this.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Troll34 getTroll() {
        return this._my_troll;
    }
    public void setTroll(Troll34 troll) {
        this._my_troll = troll;
    }
}
