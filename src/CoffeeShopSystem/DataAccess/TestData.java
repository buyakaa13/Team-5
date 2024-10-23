package CoffeeShopSystem.DataAccess;

import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;
import CoffeeShopSystem.MenuItem;
import CoffeeShopSystem.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * This class loads data into the data repository and also
 * sets up the storage units that are used in the application.
 * The main method in this class must be run once (and only
 * once) before the rest of the application can work properly.
 * It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {
	public static void main(String[] args) {
		TestData td = new TestData();
		td.itemData();
		td.orderData();
		td.userData();
		DataAccess da = new DataAccessFacade();
		System.out.println(da.readItemsMap());
		System.out.println(da.readUserMap());
	}

	///create items
	public void itemData() {
		allItems.get(0);
		allItems.get(1);
		allItems.get(2);
		allItems.get(3);
		DataAccessFacade.loadItemMap(allItems);
	}

	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}

	//create library members
	public void orderData() {
		Order order = new Order();
		order.addItem(allItems.get(0));
		orders.add(order);

		order = new Order();
		order.addItem(allItems.get(1));
		orders.add(order);

		order = new Order();
		order.addItem(allItems.get(2));
		orders.add(order);

		order = new Order();
		order.addItem(allItems.get(3));
		orders.add(order);

		DataAccessFacade.loadOrderMap(orders);
	}

	///////////// DATA //////////////
	List<Order> orders = new ArrayList<Order>();

//	@SuppressWarnings("serial")
//	List<Address> addresses = new ArrayList<Address>() {
//		{
//			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
//			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
//			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
//			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
//			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
//			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
//			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
//			add(new Address("501 Central", "Mountain View", "CA", "94707"));
//		}
//	};
//	@SuppressWarnings("serial")
//	public List<Author> allAuthors = new ArrayList<Author>() {
//		{
//			add(new Author("Joe", "Thomas", "641-445-2123", addresses.get(0), "A happy man is he."));
//			add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
//			add(new Author("Nirmal", "Pugh", "641-919-3223", addresses.get(1), "Thinker of thoughts."));
//			add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
//			add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
//		}
//	};

	@SuppressWarnings("serial")
	List<MenuItem> allItems = new ArrayList<MenuItem>() {
		{
			add(new MenuItem("Americano", 12, 0, MenuCategory.COFFEE, "src/CoffeeShopSystem/Images/americano.jpg"));
			add(new MenuItem("Latte", 10, 90, MenuCategory.COFFEE, "src/CoffeeShopSystem/Images/Latte.jpg"));
			add(new MenuItem("Red velvet cake", 20, 80, MenuCategory.DESSERT, "src/CoffeeShopSystem/Images/redVelvet.jpg"));
			add(new MenuItem("Cheese cake", 22,66, MenuCategory.DESSERT, "src/CoffeeShopSystem/Images/cheeseCake.jpeg"));
			add(new MenuItem("Orange tea", 12, 100, MenuCategory.BEVERAGE, "src/CoffeeShopSystem/Images/orangeTea.jpg"));
			add(new MenuItem("Latte", 10, 90, MenuCategory.COFFEE, "src/CoffeeShopSystem/Images/Latte.jpg"));
			add(new MenuItem("Red velvet cake", 20, 80, MenuCategory.DESSERT, "src/CoffeeShopSystem/Images/redVelvet.jpg"));
			add(new MenuItem("Cheese cake", 22,66, MenuCategory.DESSERT, ""));
		}
	};

	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("101", "xyz", Auth.CASHIER));
			add(new User("102", "abc", Auth.MANAGER));
			add(new User("103", "111", Auth.BOTH));
		}
	};
}
