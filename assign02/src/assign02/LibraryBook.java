package assign02;

import java.util.GregorianCalendar;

/**
 * It assigns a book to a library and book.
 * 
 * @author Jonathan and Pratyush
 *
 */
public class LibraryBook extends Book
{

	private String holder;
	private GregorianCalendar dueDate;
	private boolean isCheckedOut;

	/**
	 * constructor of the class.
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public LibraryBook(long isbn, String author, String title)
	{
		super(isbn, author, title);
		this.dueDate = null;
		this.isCheckedOut = false;
	}

	/**
	 * checks whether the object is checked out.
	 * 
	 * @return isCheckOut
	 */
	public boolean isCheckedOut()
	{
		return isCheckedOut;
	}

	/**
	 * This sets the object to a checked out condition.
	 * 
	 * @param calendar
	 * @param passHolder
	 * 
	 */
	public void checkOut(GregorianCalendar calendar, String passHolder)
	{
		this.dueDate = calendar;
		this.holder = passHolder;
		this.isCheckedOut = true;
	}

	/**
	 * This runs a script that resets the due date to null, holder to null, and
	 * checkedOut to false.
	 */
	public void checkIn()
	{
		this.dueDate = null;
		this.holder = null;
		this.isCheckedOut = false;
	}

	/**
	 * returns the current holder
	 * 
	 * @return String
	 */
	public String getHolder()
	{
		return this.holder;
	}

	/**
	 * gets the Gregain Calendar objects and returns it.
	 * 
	 * @return dueDate
	 */
	public GregorianCalendar getDueDate()
	{
		return this.dueDate;
	}
}
