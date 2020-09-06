package assign02;
import java.util.GregorianCalendar;
/**
 * 
 * @author Jonathan and Pratyush
 *
 */
public class LibraryBook extends Book
{
	private String holder;
	private boolean checkedOut;
	private GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title)
	{
		super(isbn, author, title);
		
	}
	
	/**
	 * This reports whether the librarybook object is checked in or out.
	 * @return checkedOut
	 */
	private boolean getCheckedOut()
	{
		GregorianCalendar checkout = new GregorianCalendar();
	int y = checkout.getWeekYear()
		return checkedOut;
	}
	
	/**
	 * This runs a script that resets the due date to null, holder to null, and checkedOut to false.
	 */
	public void checkIn()
	{
		this.checkedOut = false;
		this.dueDate = null;
		this.holder = null;		
	}
	
	/**
	 * returns the current holder
	 * @return String
	 */
	public String getHolder()
	{
		return holder; 
	}
	
	/**
	 * its a get method... 
	 * @return the current duedate as a GregorianCalender
	 */
	public GregorianCalendar getDueDate()
	{
		return dueDate; 
	}
	
}
