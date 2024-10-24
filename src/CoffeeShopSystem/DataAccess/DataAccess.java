package CoffeeShopSystem.DataAccess;

import CoffeeShopSystem.MenuItem;
import CoffeeShopSystem.Order;
import java.util.HashMap;

public interface DataAccess { 
	// add Read/write operations related to storage types
	public HashMap<String, MenuItem> readItemsMap();
	public HashMap<String, User> readUserMap();
	public HashMap<String, Order> readOrderMap();
	public void saveNewOrder(Order order);
	public void saveNewUser(User user);
	public void updateOrderInMap(String orderId, Order updatedOrder);
	public void loadItemMap(MenuItem item);
}
