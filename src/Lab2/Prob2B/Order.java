package Lab2.Prob2B;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private String orderNum;
    private LocalDate orderDate;
    private ArrayList<OrderLine> orderLines;

    public Order(String orderNum, LocalDate orderDate){
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        orderLines = new ArrayList<>();
    }

    public OrderLine addOrderLine(int orderLineNum, double price, int qty){
        OrderLine orderLine = new OrderLine(orderLineNum, price, qty);
        orderLines.add(orderLine);
        return orderLine;
    }

    public String getOrderNum(){return this.orderNum;}

    public LocalDate getOrderDate(){return this.orderDate;}

    public ArrayList<OrderLine> getOrderLines(){ return this.orderLines; }
}
