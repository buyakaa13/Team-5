package Lab3.Prob2;

public class Building {
    private double maintenanceCost;
    private Apartment[] apartments;

    public Building(double maintenanceCost, Apartment[] apartments) {
        this.maintenanceCost = maintenanceCost;
        this.apartments = apartments;
    }

    // Calculate profit (sum of apartment rents minus maintenance cost)
    public double calculateProfit() {
        double totalRent = 0;
        for (Apartment apartment : apartments) {
            totalRent += apartment.getRent();
        }
        return totalRent - maintenanceCost;
    }
}