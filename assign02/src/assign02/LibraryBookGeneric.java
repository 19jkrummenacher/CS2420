package assign02;

import java.util.GregorianCalendar;

/**
 * It assigns a book to a library and book. The generic class also always to
 * switch types of holders.
 * 
 * @author Jonathan and Pratyush
 *
 */
public class LibraryBookGeneric<Type> extends Book
{

	private Type holder;
	private GregorianCalendar dueDate;
	private boolean isCheckedOut;

	/**
	 * this is the constructor.
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public LibraryBookGeneric(long isbn, String author, String title)
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
	 * This reports whether the libraryBookGeneric object is checked in or out.
	 * 
	 * @param calendar
	 * @param passHolder
	 * 
	 */
	public void checkOut(GregorianCalendar calendar, Type passHolder)
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
	public Type getHolder()
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
