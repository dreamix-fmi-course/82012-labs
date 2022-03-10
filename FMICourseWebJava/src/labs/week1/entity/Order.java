package labs.week1.entity;

import labs.week1.vo.OrderStatus;
import labs.week1.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Create class Order that implements
 * id, status:OrderStatus, List<OrderLine> orderLines, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 *
 * Implements constructors: default, by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */
public class Order {
    private static int counter = 0;

    private final int id;
    private final LocalDate timestamp;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;
    private LocalDate deliveryDueDate;
    private BigDecimal totalPrice;
    private List<OrderLine> orderLines;
    private User user;

    public Order() {
        this.id = counter++;
        this.timestamp = LocalDate.now();
    }

    public Order(int id, OrderStatus orderStatus, OrderLine... orderLines) {
        if (orderStatus == null || orderLines == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        this.id = id;
        this.orderStatus = orderStatus;
        this.orderLines = new ArrayList<>(Arrays.stream(orderLines).toList());
        this.timestamp = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDeliveryDueDate() {
        return deliveryDueDate;
    }

    public void setDeliveryDueDate(LocalDate deliveryDueDate) {
        this.deliveryDueDate = deliveryDueDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", paymentMethod=" + paymentMethod +
                ", orderStatus=" + orderStatus +
                ", deliveryDueDate=" + deliveryDueDate +
                ", totalPrice=" + totalPrice +
                ", orderLines=" + orderLines +
                ", user=" + user +
                '}';
    }
}
