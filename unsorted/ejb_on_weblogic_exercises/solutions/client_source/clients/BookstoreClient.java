package clients;
import java.util.*;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import bookstore.BookstoreAdmin;
import bookstore.BookstoreAdminHome;

import dtos.BookDTO;
import dtos.CustomerDTO;


/**
 * A test client for our bookstore's admin bean. <br>
 * 
 * This simple test obtains a BookStoreAdmin stub and invokes
 * methods such as: <ul>
 * <li> Adding a book to inventory
 * <li> Adding a customer
 * <li> Viewing all books / all customers
 * 
 */
public class BookstoreClient {

	public static void main(String[] args) throws Exception {
		// Lookup:
		InitialContext ictx = new InitialContext();
		Object obj = ictx.lookup("ejb/admin/BookstoreAdminHome");
		BookstoreAdminHome adminHome = (BookstoreAdminHome) PortableRemoteObject.narrow(obj,BookstoreAdminHome.class);
		BookstoreAdmin admin = adminHome.create();

		// Add books:
		BookDTO book;
		
		try {
			admin.addNewBook(new BookDTO("Lord of the Rings", "Tolkin", 100));
			admin.addNewBook(new BookDTO("The Truth", "Pratchett", 10));
		} catch (Exception e) {
			System.err.println("Cannot add books. " + e);
		}
		
		// view all books:
		System.out.println("Books currently in inventory:");
		List books = admin.showBooks();
		for (Iterator it = books.iterator(); it.hasNext();) {
			book = (BookDTO) it.next();
			System.out.println(book);
		}

		// Add customers:
		CustomerDTO customer;
		try {
			admin.addNewCustomer(
				new CustomerDTO(
					"1111",
					"John Williams",
					"john@yahoo.com",
					"5th avenu, NYC"));
			admin.addNewCustomer(
				new CustomerDTO(
					"222",
					"Paul Smith",
					"paul@yahoo.com",
					"5th avenu, NYC"));
		} catch (Exception e) {
			System.err.println("Failed to enter customers. " + e);
		}

		// view all customers:
		System.out.println("All registered customers:");
		List customers = admin.showCustomers();
		for (Iterator it = customers.iterator(); it.hasNext();) {
			customer = (CustomerDTO) it.next();
			System.out.println(customer);
		}

		// release resources:
		admin.remove();

	}
}