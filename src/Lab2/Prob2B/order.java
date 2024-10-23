package Lab2.Prob2B;

import java.time.LocalDate;
import java.util.ArrayList;

public class order {
    private String orderNum;
    private LocalDate orderDate;
    private ArrayList<orderLine> orderLines;

    public order(String orderNum, LocalDate orderDate){
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        orderLines = new ArrayList<>();
    }

    public orderLine addOrderLine(int orderLineNum, double price, int qty){
        orderLine orderLine = new orderLine(orderLineNum, price, qty);
        orderLines.add(orderLine);
        return orderLine;
    }

    public String getOrderNum(){return this.orderNum;}

    public LocalDate getOrderDate(){return this.orderDate;}

    public ArrayList<orderLine> getOrderLines(){ return this.orderLines; }
}
