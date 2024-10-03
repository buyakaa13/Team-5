package Lab3.Prob3;

import java.util.List;

public class Admin {
	public static double computeTotalRent(List<Property> properties) {
		double totalRent = 0;
		for (Property property: properties)
			totalRent += property.computeRent();

		return totalRent;
	}
}
