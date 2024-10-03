package Lab2.Prob2B;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("12356789", LocalDate.now());
        order.addOrderLine(9898, 9800.5, 2);
        order.addOrderLine(9899, 120300.9, 5);
        System.out.println("OrderNum: " + order.getOrderNum() + " OrderDate: " + order.getOrderDate());
        System.out.println("OrderLines: " + order.getOrderLines().toString());
    }
}
