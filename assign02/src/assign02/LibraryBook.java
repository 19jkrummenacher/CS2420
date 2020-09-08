package assign02;

import java.util.GregorianCalendar;

/**
 * 
 * @author Jonathan and Pratyush
 *
 */
public class LibraryBook extends Book {
	private String holder;
	private GregorianCalendar dueDate;

	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
		this.dueDate = null;
	}

	/**
	 * This reports whether the librarybook object is checked in or out.
	 * 
	 * @param g
	 * @param passHolder
	 * 
	 */
	public void checkOut(GregorainCalendar g, String passHolder) {
		this.checkedOut = g;
		this.holder = passHolder;
	}

	/**
	 * This runs a script that resets the due date to null, holder to null, and
	 * checkedOut to false.
	 */
	public void checkIn() {
		this.checkedOut = false;
		this.dueDate = null;
		this.holder = null;
	}

	/**
	 * returns the current holder
	 * 
	 * @return String
	 */
	public String getHolder() {
		return holder;
	}
}
