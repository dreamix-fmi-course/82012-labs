package labs.week1.streams;

import labs.week1.entity.Order;
import labs.week1.entity.OrderLine;
import labs.week1.entity.User;
import labs.week1.vo.OrderStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SearchExercise {

    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return user.getOrders()
                .stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.ACTIVE)
                .toList();
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        List<Order> activeOrders = new ArrayList<>();
        for (Order order : user.getOrders()) {
            if (order.getOrderStatus() == OrderStatus.ACTIVE) {
                activeOrders.add(order);
            }
        }

        return activeOrders;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        if (orders == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        if (orders == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }

        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        if (user == null || description == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return user.getOrders()
                .stream()
                .filter(order -> order.getOrderLines().stream()
                        .anyMatch(orderLine -> orderLine.getItem().getDescription().equals(description)))
                .toList();
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return user.getOrders()
                .stream()
                .anyMatch(order -> order.getOrderStatus() == OrderStatus.ACTIVE);
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return order.getOrderLines()
                .stream()
                .noneMatch(OrderLine::isSpecialOffer);
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return user.getOrders()
                .stream()
                .max(Comparator.comparing(Order::getTotalPrice));
    }

}