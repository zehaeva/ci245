/*
 * Troll.java
 *
 * $Id: Troll.java,v 2.0 2004/01/20 22:06:14 icss235 Exp $
 *
 * Revisions:
 *	$Log: Troll.java,v $
 *	Revision 2.0  2004/01/20 22:06:14  icss235
 *	*** empty log message ***
 *
 */

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

/*
 * A troll to guard a bridge. The troll simply passes requests from
 * woolies to his bridge. It is a placeholder for a later exercise.
 * <p>
 * Note
 * <ul>
 * <li>The troll gets entry permission; the woolie itself tells
 *     the bridge it is off.</li>
 * <li>The troll runs an independent thread to pull things off
 *     its queue. This thread runs forever, so the Troll34 objects
 *     must be a daemon thread.</li>
 * <ul>
 */
public class Troll34 extends Semaphore {

	/**
	 * Create a troll. (Called by its Bridge34 object.)
	 *
	 * @param b the Bridge34 object associated with this Troll34 object
	 */
	public Troll34(Bridge34 b, int permits) {
		super(permits);
		myBridge = b;
		this.myQueue = new WoolieQueue();
	}

	/**
	 * Request permission to go on the bridge. This method is
	 * called by a Woolie34 object. It just calls Bridge34.enter().
	 *
	 * Postcondition:<ul>
	 * <li>The woolie got permission and has entered the bridge.
	 * </ul>
	 */
	public void enterBridgePlease() {
		this.myQueue.insert((Woolie34)Thread.currentThread());

        while (this.myBridge.isFull() || this.myQueue.peek() != Thread.currentThread()) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {}
        }

		try {
			this.acquire();
			myBridge.removeWoolie();
			myBridge.addWoolie();
		} catch (InterruptedException e) {}
	}

	/**
	 * Inform the troll that the caller (the woolie) is getting
	 * off the bridge.
	 */
	public void leave() {
		this.myQueue.remove();
		this.release();
	}

	/**
	 * The bridge that this troll guards. The Bridge34 object
	 * creates the troll object.
	 */
	private Bridge34 myBridge;

	/**
	 * Queue that the Troll uses to keep track of who should get onto the bridge next
	 */
	private WoolieQueue myQueue;

}
