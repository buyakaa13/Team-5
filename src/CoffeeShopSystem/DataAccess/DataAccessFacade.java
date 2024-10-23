package CoffeeShopSystem.DataAccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import CoffeeShopSystem.MenuItem;
import CoffeeShopSystem.Order;

public class DataAccessFacade implements DataAccess {

	enum StorageType {
		ITEMS, EMPLOYEES, ORDERS;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/CoffeeShopSystem/DataAccess/storage";
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	//implement: other save operations
	public void saveNewOrder(Order order) {
		// Read all the orders from storage
		HashMap<String, Order> orders = readOrderMap();
		String orderId = order.getOrderId();
		orders.put(orderId, order);
		saveToStorage(StorageType.ORDERS, orders);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, MenuItem> readItemsMap() {
		//Returns a Map with name/value pairs being
		//   isbn -> Book
		return (HashMap<String, MenuItem>) readFromStorage(StorageType.ITEMS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Order> readOrderMap() {
		//Returns a Map with name/value pairs being
		//   memberId -> LibraryMember
		return (HashMap<String, Order>) readFromStorage(
				StorageType.ORDERS);
	}

	public void updateOrderInMap(String orderId, Order updatedOrder) {
		HashMap<String, Order> orderMap = readOrderMap();
		if (orderMap.containsKey(orderId)) {
			orderMap.put(orderId, updatedOrder);
			saveToStorage(StorageType.ORDERS, orderMap);
		}
		else
			System.out.println("Order with ID " + orderId + " not found.");
	}

	public void loadItemMap(MenuItem item) {
		System.out.println("Here loadItemMap");
		HashMap<String, MenuItem> items = readItemsMap();
		if(items == null || items.size() == 0)
			items = new HashMap<>();
		String itemId = item.getItemId();
		items.put(itemId, item);
		saveToStorage(StorageType.ITEMS, items);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		//Returns a Map with name/value pairs being
		//   userId -> User
		return (HashMap<String, User>)readFromStorage(StorageType.EMPLOYEES);
	}

	static void loadItemMap(List<MenuItem> itemList) {
		HashMap<String, MenuItem> items = new HashMap<String, MenuItem>();
		itemList.forEach(item -> items.put(item.getItemId(), item));
		System.out.println("Save Items: " + itemList.get(0));
		saveToStorage(StorageType.ITEMS, items);
	}

	public static void loadUserMap(List<User> userList) {
		HashMap<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getId(), user));
		saveToStorage(StorageType.EMPLOYEES, users);
	}

	public static void loadOrderMap(List<Order> orderList) {
		HashMap<String, Order> orders = new HashMap<String, Order>();
		orderList.forEach(order -> orders.put(order.getOrderId(), order));
		saveToStorage(StorageType.ORDERS, orders);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
}
