import java.util.concurrent.Semaphore;

/**
 * Created by zehaeva on 11/3/16.
 */
public class Bridge extends Semaphore {
    private Troll _my_troll;

    public Bridge(int permits) {
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

    public Troll getTroll() {
        return this._my_troll;
    }
    public void setTroll(Troll troll) {
        this._my_troll = troll;
    }
}
