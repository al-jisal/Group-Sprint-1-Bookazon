import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String subscription;
    private Cart cart;
    private ArrayList<Order> orders;
    private Address billing; 
    private Address shipping; 

    public User(String name, String subscription, Address billing, Address shipping) {
        this.name = name;
        this.billing = billing;
        this.shipping = shipping;
        this.subscription = subscription;  // normal, gold, platinum, silver membership
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public Address getShipping(){
        return this.shipping;
    }

    public Address getBilling(){
        return this.billing;
    }

    public String getName() {
        return name;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String role) {
        this.subscription = role;
    }

    public void viewCart() {
        cart.viewCartDetails();
    }

    public void addToCart(CartItem cartItem, int quantity) {
        cart.addItem(new CartItem(cartItem.getName(), cartItem.getPrice(), quantity));
    }

    public void removeFromCart(CartItem cartItem) {
        ArrayList<CartItem> itemsCopy = new ArrayList<>(cart.getItems());
        for (CartItem item : itemsCopy) {
            if (item.getName().equals(cartItem.getName())) {
                cart.getItems().remove(item);
                break;
            }
        }
    }

    public void viewOrders() {
        for (Order order : orders) {
            order.printOrderDetails();
        }
    }

    public void checkout() {
        LocalDate currentDate = LocalDate.now();
        Order order = new Order(cart, this);
        order.setOrderStatus("Order Placed");
        order.setDateCreated(currentDate.toString());
        orders.add(order);
    }
}


