package database;

import java.util.ArrayList;

public interface SearchBookDAOInterface<T> {
	public ArrayList<T> searchBookByNameOrAuthor(String userSearchContent);
	public ArrayList<T> searchBookByCategory(String valueSelect);
}
