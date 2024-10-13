package Lab9.Prob9;

import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        //a. Is there any Vegetarian meal available ( return type boolean)
        boolean anyVegeterian = menu.stream()
                .anyMatch(x->x.isVegetarian() == true);
        System.out.println("anyVegeterian: " + anyVegeterian);

        //b. Is there any healthy menu have calories less than 1000 ( return type boolean)
        boolean calorieLess = menu.stream()
                .anyMatch(x->x.getCalories() < 1000);
        System.out.println("calorieLess: " + calorieLess);

        //c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
        boolean calorieMore = menu.stream()
                .map(x->x.getCalories())
                .filter(x->x > 1000).findAny().isPresent();
        System.out.println("calorieLess: " + calorieMore);

        //d. find and return the first item for the type of MEAT( return type Optional<Dish>)
        Optional<Dish> first = menu.stream()
                .filter(x->x.getType() == Dish.Type.MEAT).findFirst();
        System.out.println("First: " + first);

        //e. calculateTotalCalories() in the menu using reduce. (return int)
        int totalCalories = menu.stream()
                .map(x->x.getCalories())
                .reduce((x,y)->x + y).get();
        System.out.println("calculateTotalCalories: " + totalCalories);

        //f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
        int totalCal = menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum).get();
        System.out.println("calculateTotalCaloriesMethodReference: " + totalCal);

    }
}
