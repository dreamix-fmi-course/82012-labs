package labs.week1.entity;

import java.util.List;

/**
 * Create a class User with list of orders
 */
public class User {
    private final List<Order> orders;

    public User(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
