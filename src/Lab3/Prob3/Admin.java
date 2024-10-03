package lesson3.labs.prob3;

import java.util.List;

public class Admin {
	public static double computeTotalRent(List<Property> properties) {
		double totalRent = 0;
		for (Property property: properties)
			totalRent += property.computeRent();

		return totalRent;
	}
}
