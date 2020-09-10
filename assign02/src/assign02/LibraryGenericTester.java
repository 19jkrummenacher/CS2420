package assign02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * This class contains tests for LibraryGeneric.
 * 
 * @author Erin Parker , Jonathan, and Pratyush
 * @version September 5, 2020
 */
public class LibraryGenericTester
{

	private LibraryGeneric<String> nameLib; // library that uses names to identify patrons (holders)
	private LibraryGeneric<PhoneNumber> phoneLib; // library that uses phone numbers to identify patrons
	private LibraryGeneric<Character> charLib; // Our medium lib;
	private LibraryGeneric<String> emptyLib;

	/**
	 * Intializes libraries
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		emptyLib = new LibraryGeneric<String>();

		nameLib = new LibraryGeneric<String>();
		nameLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		nameLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		nameLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		phoneLib = new LibraryGeneric<PhoneNumber>();
		phoneLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		phoneLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		phoneLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		// char lib is used to tested a large library
		charLib = new LibraryGeneric<Character>();
		charLib.addAll("src/assign02/Mushroom_Publishing.txt");
	}

	/**
	 * this tests when the due dates are not over due, and needs to return an empty
	 * list :).
	 */
	@Test
	public void getOverDueListEmptyList()
	{
		PhoneNumber patron = new PhoneNumber("3543723432");

		phoneLib.checkout(9780330351690L, patron, 9, 9, 2008); // into the wild
		phoneLib.checkout(9780374292799L, patron, 9, 9, 2010); // The world is flat
		phoneLib.checkout(9780446580342L, patron, 6, 9, 2011); // Simple Genius
		ArrayList<LibraryBookGeneric<PhoneNumber>> tempLib = phoneLib.getOverdueList(7, 21, 2000);

		assertEquals(new ArrayList<LibraryBookGeneric<PhoneNumber>>(), tempLib);
	}

	/**
	 * testing phone library's inventoryList method
	 */
	@Test
	public void phoneLibGetInventoryList()
	{
		ArrayList<LibraryBookGeneric<PhoneNumber>> tempLib = phoneLib.getInventoryList();
		ArrayList<LibraryBookGeneric<PhoneNumber>> sortedLib = new ArrayList<LibraryBookGeneric<PhoneNumber>>();
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780330351690L, "Jon Krakauer", "Into the Wild"));
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780374292799L, "Thomas L. Friedman", "The World is Flat"));
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780446580342L, "David Baldacci", "Simple Genius"));

		assertEquals(sortedLib, tempLib);
	}

	/**
	 * testing phone library's overdueList method
	 */
	@Test
	public void phoneLibGetOverdueList()
	{
		PhoneNumber patron = new PhoneNumber("3543723432");

		phoneLib.checkout(9780330351690L, patron, 9, 9, 2008); // into the wild
		phoneLib.checkout(9780374292799L, patron, 9, 9, 2010); // The world is flat
		phoneLib.checkout(9780446580342L, patron, 6, 9, 2011); // Simple Genius
		ArrayList<LibraryBookGeneric<PhoneNumber>> tempLib = phoneLib.getOverdueList(7, 21, 2011);
		ArrayList<LibraryBookGeneric<PhoneNumber>> sortedLib = new ArrayList<LibraryBookGeneric<PhoneNumber>>();
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780330351690L, "Jon Krakauer", "Into the Wild"));
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780374292799L, "Thomas L. Friedman", "The World is Flat"));
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780446580342L, "David Baldacci", "Simple Genius"));
		sortedLib.get(0).checkOut(new GregorianCalendar(2008, 9, 9), patron);
		sortedLib.get(1).checkOut(new GregorianCalendar(2010, 9, 9), patron);
		sortedLib.get(2).checkOut(new GregorianCalendar(2011, 6, 9), patron);

		assertEquals(sortedLib, tempLib);
	}

	/**
	 * testing phone's Library's getOverDueList method
	 */
	@Test
	public void phoneLibGetOrderedByTitle()
	{
		ArrayList<LibraryBookGeneric<PhoneNumber>> tempLib = phoneLib.getOrderedByTitle();
		ArrayList<LibraryBookGeneric<PhoneNumber>> sortedLib = new ArrayList<LibraryBookGeneric<PhoneNumber>>();
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780330351690L, "Jon Krakauer", "Into the Wild"));
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780446580342L, "David Baldacci", "Simple Genius"));
		sortedLib.add(new LibraryBookGeneric<PhoneNumber>(9780374292799L, "Thomas L. Friedman", "The World is Flat"));

		assertEquals(sortedLib, tempLib);
	}

	/**
	 * testing empty library's lookup ISBN
	 */
	@Test
	public void testEmptyLookupISBN()
	{
		assertNull(emptyLib.lookup(978037429279L));
	}

	/**
	 * testing empty library's lookup holder
	 */
	@Test
	public void testEmptyLookupHolder()
	{
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = emptyLib.lookup("Jane Doe");
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}

	/**
	 * testing empty library's checkout
	 */
	@Test
	public void testEmptyCheckout()
	{
		assertFalse(emptyLib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));
	}

	/**
	 * testing empty library's Checkin ISBN
	 */
	@Test
	public void testEmptyCheckinISBN()
	{
		assertFalse(emptyLib.checkin(978037429279L));
	}

	/**
	 * testing empty library's checkin holder
	 */
	@Test
	public void testEmptyCheckinHolder()
	{
		assertFalse(emptyLib.checkin("Jane Doe"));
	}

	/**
	 * testing name's lib checkout method
	 */
	@Test
	public void testNameLibCheckout()
	{
		String patron = "Jane Doe";
		assertTrue(nameLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(nameLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	/**
	 * testing name's lib lookup method
	 */
	@Test
	public void testNameLibLookup()
	{
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = nameLib.lookup(patron);

		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}

	/**
	 * testing Name's lib check in method
	 */
	@Test
	public void testNameLibCheckin()
	{
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(nameLib.checkin(patron));
	}

	/**
	 * testing phone lib checkout method
	 */
	@Test
	public void testPhoneLibCheckout()
	{
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		assertTrue(phoneLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(phoneLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	/**
	 * testing phone lib lookup method
	 */
	@Test
	public void testPhoneLibLookup()
	{
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = phoneLib.lookup(patron);

		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}

	/**
	 * testing the Phone lib checkin method
	 */
	@Test
	public void testPhoneLibCheckin()
	{
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(phoneLib.checkin(patron));
	}

	/**
	 * testing the char lib checkout method
	 */
	@Test
	public void testCharLibCheckout()
	{
		Character patron = 'a';
		assertTrue(charLib.checkout(9781843190769L, patron, 1, 1, 2028));
		assertTrue(charLib.checkout(9781843190875L, patron, 1, 1, 2028));
	}

	/**
	 * testing the char lib using the lookup method.
	 */
	@Test
	public void testCharLibLookup()
	{
		Character patron = 'a';
		charLib.checkout(9781843190769L, patron, 1, 1, 2028);
		charLib.checkout(9781843190875L, patron, 1, 1, 2028);
		ArrayList<LibraryBookGeneric<Character>> booksCheckedOut = charLib.lookup(patron);

		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9781843190769L, "Roger Taylor", "The Call of the Sword")));
		assertTrue(booksCheckedOut.contains(new Book(9781843190875L, "Renee Angers", "Ice and a Curious Man")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}

	/**
	 * testing the char lib using the checkin method.
	 */
	@Test
	public void testCharLibCheckin()
	{
		Character patron = 'a';
		charLib.checkout(9781843190769L, patron, 1, 1, 2028);
		charLib.checkout(9781843190875L, patron, 1, 1, 2028);
		assertTrue(charLib.checkin(patron));
	}
}
