package lesson3.labs.prob3;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Address[] addresses = {
				new Address("111 Main", "Fairfield", "IA", "52556"),
				new Address("200 Forest Ave", "Fairfield", "IA", "52556"),
			    new Address("10 N. 4th St.", "Fairfield", "IA", "52556")
		};

		List<Property> properties = new ArrayList<>();
		properties.add(new House(addresses[0], 1200.0));
		properties.add(new Condo(addresses[1], 2));
		properties.add(new Trailer(addresses[2]));

		System.out.println("Total rent of properties: " + Admin.computeTotalRent(properties));
	}
}
