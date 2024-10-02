package Prob2B;

public class OrderLine {
    private int orderLineNumber;
    private double price;
    private int qty;

    public OrderLine(int orderLineNumber, double price, int qty){
        this.orderLineNumber = orderLineNumber;
        this.price = price;
        this.qty = qty;
    }

    public int getOrderLineNumber(){
        return this.orderLineNumber;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQty(){
        return this.qty;
    }

    @Override
    public String toString() {
        return "\n" + "OrderLineNumber: " + orderLineNumber + "\n" +
                "Price: " + price + "\n" +
                "Qty: " + qty;
    }
}
