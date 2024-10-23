package CoffeeShopSystem.DataAccess;

import CoffeeShopSystem.MenuItem;
import CoffeeShopSystem.Order;

import java.util.HashMap;

//import business.Book;
//import business.LibraryMember;
//import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	// add Read/write operations related to storage types
	public HashMap<Long, MenuItem> readItemsMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, Order> readOrderMap();
	public void saveNewOrder(Order order);
}
