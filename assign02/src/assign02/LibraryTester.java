package assign02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * This class contains tests for Library.
 * 
 * @author Erin Parker, Pratyush, and Jonathan
 * @version September 2, 2020
 */
public class LibraryTester
{

	private Library emptyLib, smallLib, mediumLib;

	/**
	 * Initials the libraries
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		emptyLib = new Library();

		smallLib = new Library();
		smallLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		smallLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		smallLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		mediumLib = new Library();
		mediumLib.addAll("src/assign02/Mushroom_Publishing.txt");
		// FILL IN -- extend this tester to consider a medium-size library
	}

	/**
	 * tests an Empty library against the LookUp method with ISBN
	 */
	@Test
	public void testEmptyLookupISBN()
	{
		assertNull(emptyLib.lookup(978037429279L));
	}

	/**
	 * tests an Empty library against the look Up Method with the Holder
	 */
	@Test
	public void testEmptyLookupHolder()
	{
		ArrayList<LibraryBook> booksCheckedOut = emptyLib.lookup("Jane Doe");
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}

	/**
	 * tests an Empty library against Checkout method
	 */
	@Test
	public void testEmptyCheckout()
	{
		assertFalse(emptyLib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));
	}

	/**
	 * tests an Empty library against Checkin method IBSN
	 */
	@Test
	public void testEmptyCheckinISBN()
	{
		assertFalse(emptyLib.checkin(978037429279L));
	}

	/**
	 * tests an Empty library against Checkin method Holder
	 */
	@Test
	public void testEmptyCheckinHolder()
	{
		assertFalse(emptyLib.checkin("Jane Doe"));
	}

	/**
	 * tests an Small library against Look Up ISBN
	 */
	@Test
	public void testSmallLibraryLookupISBN()
	{
		assertNull(smallLib.lookup(9780330351690L));
	}

	/**
	 * tests an Small library against Look Up Holder method
	 */
	@Test
	public void testSmallLibraryLookupHolder()
	{
		smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		ArrayList<LibraryBook> booksCheckedOut = smallLib.lookup("Jane Doe");

		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals("Jane Doe", booksCheckedOut.get(0).getHolder());
	}

	/**
	 * tests an Small library against Checkout method
	 */
	@Test
	public void testSmallLibraryCheckout()
	{
		assertTrue(smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008));
	}

	/**
	 * tests an Small library against Checkin ISBN Method
	 */
	@Test
	public void testSmallLibraryCheckinISBN()
	{
		smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		assertTrue(smallLib.checkin(9780330351690L));
	}

	/**
	 * tests an Small library against Checkin Holder Method
	 */
	@Test
	public void testSmallLibraryCheckinHolder()
	{
		assertFalse(smallLib.checkin("Jane Doe"));
	}

	/**
	 * tests an Medium library against Lookup Method ISBN
	 */
	@Test
	public void testMediumLibraryLookupISBN()
	{
		assertNull(mediumLib.lookup(9780330351690L));
	}

	/**
	 * tests an Medium library against LookUp Holder Method
	 */
	@Test
	public void testMediumLibraryLookupHolder()
	{
		mediumLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		ArrayList<LibraryBook> booksCheckedOut = mediumLib.lookup("Jane Doe");

		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals("Jane Doe", booksCheckedOut.get(0).getHolder());
	}

	/**
	 * tests an Medium library against CheckOut Method
	 */
	@Test
	public void testMediumLibraryCheckout()
	{
		assertTrue(mediumLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008));
	}

	/**
	 * tests an Medium library against Checkin Isbn
	 */
	@Test
	public void testMediumLibraryCheckinISBN()
	{
		mediumLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		assertTrue(mediumLib.checkin(9780330351690L));
	}

	/**
	 * tests an Medium library against checkin holder
	 */
	@Test
	public void testMediumLibraryCheckinHolder()
	{
		assertFalse(mediumLib.checkin("Jane Doe"));
	}
}