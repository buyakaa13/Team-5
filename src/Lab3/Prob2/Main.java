package Lab3.Prob2;

public class Main {
    public static void main(String[] args) {
        // create Apartments
        Apartment apartmentOne = new Apartment(1800);
        Apartment apartmentTwo = new Apartment(2000);
        Apartment apartmentThree = new Apartment(1200);

        // create buildings and assign apartments
        Apartment[] buildingOneApartments = { apartmentOne, apartmentTwo };
        Building buildingOne = new Building(300, buildingOneApartments);

        Apartment[] buildingTwoApartments = { apartmentThree };
        Building buildingTwo = new Building(150, buildingTwoApartments);

        // create landlord and assign buildings
        Building[] landlordBuildings = { buildingOne, buildingTwo };
        Landlord landlord = new Landlord(landlordBuildings);

        //total monthly profit
        System.out.println("Total Profit for the Landlord: " + landlord.calculateMonthlyTotalProfit());
    }
}
