package assign02;
import java.util.GregorianCalendar;
/**
 * 
 * @author Jonathan and Pratyush
 *
 */
public class LibraryBook extends Book
{
	public LibraryBook(long isbn, String author, String title)
	{
		super(isbn, author, title);
		//Needs implementation - JHON
	}
	
	public String getHolder()
	{
		return ""; //Needs implementation - JHON
	}
	
	public GregorianCalendar getDueDate()
	{
		return null; //Needs implementation - JHON
	}
}
