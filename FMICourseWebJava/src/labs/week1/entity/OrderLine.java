package labs.week1.entity;

import labs.week1.vo.OrderStatus;

/**
 * Create OrderLine which holds information for:
 * Item, enum for status, boolean specialOffer and count
 * Implement setters/getters/constructor
 */
public class OrderLine {
    private Item item;
    private OrderStatus orderStatus;
    private boolean specialOffer;
    private int count;

    public OrderLine(Item item, OrderStatus orderStatus, boolean specialOffer, int count) {
        this.item = item;
        this.orderStatus = orderStatus;
        this.specialOffer = specialOffer;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
