import java.util.Vector;

/**
 * This class represents a table at the wedding.  You are not
 * allowed to modify this class.
 * 
 * @author Jason A. Covey
 */
public class GuestTable {

	// Keeps track of what guests are at this table.
	Vector<Integer> m_guests;
	
	/**
	 * The public constructor.
	 */
	public GuestTable() {
		m_guests = new Vector<Integer>();
	}
	
	/**
	 * Adds a guest to the table.
	 * @param guest an integer object
	 */
	public void AddGuestToTable(Integer guest) {
		m_guests.add(guest);
	}
	
	/**
	 * Adds a guest to the table.
	 * @param guest an integer primitive
	 */
	public void AddGuestToTable(int guest) {
		AddGuestToTable(new Integer(guest));
	}
	
	/**
	 * Creates a string representation of the guest list.
	 * @return
	 */
	public String GetGuestList() {
		
		String retval = "";
		
		for (Integer i : m_guests) {
			retval = retval + i.toString() + ",";
		}
		
		if (retval.length() > 0) {
			retval = retval.substring(0, retval.length() - 1);
		}
		
		return retval;
	}

}
