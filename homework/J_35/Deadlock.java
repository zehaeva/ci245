/**
 * Created by hcanaway on 12/6/2016.
 */
public class Deadlock extends Thread implements Runnable {
    private String _name;
    private Deadlock _deadlock;

    public Deadlock(String name) {
        this._name = name;
    }

    @Override
    public void run() {
        synchronized (this.name()) {
            System.out.printf("the name of my thread is %s\n", this.name());

            try { Thread.sleep(100); }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this._deadlock.name()) {
                System.out.printf("the name of the other thread is %s\n", this._deadlock.name());
            }
        }
    }

    public synchronized String name() {
        return this._name;
    }

    public void setDeadlock(Deadlock deadlock) {
        this._deadlock = deadlock;
    }
}
