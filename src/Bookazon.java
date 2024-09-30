
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Bookazon {

    private ArrayList<CartItem> items; 
    private ArrayList<User> users;

    public Bookazon() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addCartItem(CartItem item) {
        items.add(item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void viewCartItems() {
        for (CartItem item : items) {
            item.printCartItemDetails();
        }
    }

    public void viewUsers() {
        for (User user : users) {
            System.out.println(user.getName() + " - Role: " + user.getSubscription());
        }
    }

    public void removeCartItem(CartItem item) {
        items.remove(item);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateRole(User user, String role) {
        user.setSubscription(role);
    }

    
    public static void main(String[] args) {
        
        Bookazon bookazon = new Bookazon();
        
        // create books
        bookazon.addCartItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 9.99, true, 1));
        bookazon.addCartItem(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, false, 1));
        bookazon.addCartItem(new Book("1984", "George Orwell", 1949, 8.99, true, 1));

        // create users
        ArrayList<String> A1 = new ArrayList<String>(Arrays.asList("9201 Hill", "9034 Hill", "Waterville", "ME", "04901", "USA"));
        ArrayList<String> A2 = new ArrayList<String>(Arrays.asList("9233 Hill", "9037 Hill", "Waterville", "ME", "04901", "USA"));
    

        Address address1 = new Address(A1);
        Address address2 = new Address(A2);
        bookazon.addUser(new User("Alice", "normal", address1, address2));
        bookazon.addUser(new User("Bob", "gold", address1, address2));

        // add books to cart
        bookazon.users.get(0).addToCart(bookazon.items.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.items.get(1), 2);

        // view cart
        bookazon.users.get(0).viewCart();

        // set shipping address and billing address
        // bookazon.users.get(0).setAddress("123 Main St", "", "Springfield", "IL", "62701", "USA");
        // bookazon.users.get(0).setBillingAddress("456 Elm St", "", "Springfield", "IL", "62702", "USA");

        // checkout
        bookazon.users.get(0).checkout();

        // view order details
        bookazon.users.get(0).viewOrders();
        
    }
}
