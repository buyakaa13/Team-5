package Lab3.Prob2;

public class Landlord {
    private Building[] buildings;

    public Landlord(Building[] buildings) {
        this.buildings = buildings;
    }

    // Calculate the total profit from all buildings
    public double calculateMonthlyTotalProfit() {
        double totalProfit = 0;
        for (Building building : buildings) {
            totalProfit += building.calculateProfit();
        }
        return totalProfit;
    }
}