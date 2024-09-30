import java.util.ArrayList;

public class Order {
    private String dateCreated;
    private String dateShipped;
    private User user;
    private String orderStatus;
    private ArrayList<CartItem> items;
    private double orderPrice;
    private int GOLD_DISCOUNT = 0.15;
    private int PLATINUM_DISCOUNT = 0.10;
    private int SILVER_DISCOUNT = 0.05; 

    public Order(Cart cart, User user) {
        this.items = cart.getItems();
        this.user = user;
        this.orderPrice = calculatePrice(user.subscription);
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
        System.out.println("User Name: " + user.name);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Shipping Address: " + user.shipping.line1 + ", " + user.shipping.line2 + ", " + user.shipping.city + ", " + user.shipping.state + ", " + user.shipping.zip + ", " + user.shipping.country);
        System.out.println("Billing Address: " + user.billing.line1 + ", " + user.billing.line2 + ", " + user.billing.city + ", " + user.billing.state + ", " + user.billing.zip + ", " + user.billing.country);
        System.out.println("Discount: " + getDiscount());
        System.out.println("Order Price: $" + orderPrice);
    }

    public int getDiscount() {
        if (user.subscription.equals("gold")) {
            return GOLD_DISCOUNT;
        } else if (user.subscription.equals("platinum")) {
            return PLATINUM_DISCOUNT;
        } else if (user.subscription.equals("silver")) {
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

        if (user.subscription.equals("gold")) {
            totalPrice *= (1 - GOLD_DISCOUNT); // 15% discount for prime members
        } else if (user.subscription.equals("platinum")) {
            totalPrice *= (1 - PLATINUM_DISCOUNT); // 10% discount for platinum members
        } else if (user.subscription.equals("silver")) {
            totalPrice *= (1 - SILVER_DISCOUNT); // 5% discount for silver members
        } 

        return totalPrice;
    }
}
