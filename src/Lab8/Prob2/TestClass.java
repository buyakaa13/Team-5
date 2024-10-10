package Lab8.Prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TestClass {
    public static void main(String[] args) {
        Product p1 = new Product("Imac", 999.78, 2);
        Product p2 = new Product("Samsung Galaxy", 799.78, 2);
        Product p3 = new Product("Lenova Tab", 199.78, 5);
        Product p4 = new Product("Chromebook", 569.78, 4);
        Product p5 = new Product("Samsung Galaxy", 570.78, 4);
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        // lambda implementation
        //Collections.sort(list, (s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice()));
        //System.out.println(com1.compare(p1, p2));

        System.out.println("Original product list:");
        System.out.println(list);

        //Task 1. call the compare method from the ProductPriceComparator object to compare by price
        Collections.sort(list, new ProductPriceComparator());
        System.out.println("\nSorted by price comparator:");
        System.out.println(list);

        //Task 2. call the compare method from the ProductTitleComparator object to compare by title
        Collections.sort(list, new ProductTitleComparator());
        System.out.println("\nSorted by title comparator:");
        System.out.println(list);

        //Task 3. using one comparator to sort by price or title using Lambdas
        ProductInfo pi = new ProductInfo();
        //sort by title
        pi.mysort(list, ProductInfo.SortMethod.BYTITLE);
        System.out.println("\nSorted by title lambda:");
        System.out.println(list);
        //sort my price
        pi.mysort(list, ProductInfo.SortMethod.BYPRICE);
        System.out.println("\nSorted by price lambda:");
        System.out.println(list);

        //Task 4. using model attribute of products to sort when two product has the same title using lambdas
        pi.myModelSort(list, ProductInfo.SortMethod.BYTITLE);
        System.out.println("\nSorted by product with the same name model:");
        System.out.println(list);
    }
}
