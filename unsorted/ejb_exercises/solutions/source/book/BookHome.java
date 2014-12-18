package book;

import java.util.Collection;

import javax.ejb.*;

public interface BookHome extends EJBLocalHome {
	public Book create(String title,String author,double price) throws CreateException;
	public Book findByPrimaryKey(String bookTitle) throws FinderException;
	public Collection findAllBooks() throws FinderException;
}