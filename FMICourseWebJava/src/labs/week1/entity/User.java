package labs.week1.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a class User with list of orders
 */
public class User {
    private final List<Order> orders;

    public User(List<Order> orders) {
        this.orders = orders;
    }

    public User(Order... orders) {
        this.orders = new ArrayList<>(Arrays.stream(orders).toList());
    }

    public List<Order> getOrders() {
        return orders;
    }
}
