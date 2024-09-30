import java.util.ArrayList;

public class Order {
    private String dateCreated;
    private String dateShipped;
    private User user;
    private String orderStatus;
    private ArrayList<CartItem> items;
    private double orderPrice;
    private double GOLD_DISCOUNT = 0.15;
    private double PLATINUM_DISCOUNT = 0.10;
    private double SILVER_DISCOUNT = 0.05; 

    public Order(Cart cart, User user) {
        this.items = cart.getItems();
        this.user = user;
        this.orderPrice = calculatePrice();
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public void setDateCreated(String date) {
        this.dateCreated = date;
    }

    public void setDateShipped(String date) {
        this.dateShipped = date;
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Date Created: " + dateCreated);
        System.out.println("Date Shipped: " + dateShipped);
        System.out.println("User Name: " + user.getName());
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Shipping Address: " + user.getShipping().getLine1() + ", " + user.getShipping().getLine2() + ", " + user.getShipping().getCity() + ", " + user.getShipping().getState() + ", " + user.getShipping().getZip() + ", " + user.getShipping().getCountry());
        System.out.println("Billing Address: " + user.getBilling().getLine1() + ", " + user.getBilling().getLine2() + ", " + user.getBilling().getCity() + ", " + user.getBilling().getState() + ", " + user.getBilling().getZip() + ", " + user.getBilling().getCountry());
        System.out.println("Discount: " + getDiscount());
        System.out.println("Order Price: $" + orderPrice);
    }

    public double getDiscount() {
        if (user.getSubscription().equals("gold")) {
            return GOLD_DISCOUNT;
        } else if (user.getSubscription().equals("platinum")) {
            return PLATINUM_DISCOUNT;
        } else if (user.getSubscription().equals("silver")) {
            return SILVER_DISCOUNT;
        } else {
            return 0;
        }
    }

    public double calculatePrice() {
        double totalPrice = 0.0;

        for (CartItem item : items) {
            totalPrice += item.getTotalPrice();
        }

        if (user.getSubscription().equals("gold")) {
            totalPrice *= (1 - GOLD_DISCOUNT); // 15% discount for prime members
        } else if (user.getSubscription().equals("platinum")) {
            totalPrice *= (1 - PLATINUM_DISCOUNT); // 10% discount for platinum members
        } else if (user.getSubscription().equals("silver")) {
            totalPrice *= (1 - SILVER_DISCOUNT); // 5% discount for silver members
        } 

        return totalPrice;
    }
}
