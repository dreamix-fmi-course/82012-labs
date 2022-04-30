package labs.week1.streams;

import labs.week1.entity.Order;
import labs.week1.entity.OrderLine;
import labs.week1.entity.User;
import labs.week1.vo.OrderStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchExerciseTest {

    private final SearchExercise service = new SearchExercise();

    @Test
    public void getActiveOrdersTest() {
        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2, order3);

        assertEquals(Arrays.asList(order1, order2), service.getActiveOrders(user));
    }

    @Test
    public void getOrderByIdTest() {
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        Order order3 = new Order(3);
        List<Order> orders = List.of(order1, order2, order3);

        assertEquals(order2, service.getOrderById(orders, 2));
    }

    @Test
    public void getOrderByIdTest_When_id_not_found_Then_return_null() {
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        Order order3 = new Order(3);
        List<Order> orders = List.of(order1, order2, order3);

        assertNull(service.getOrderById(orders, 100));
    }

    @Test
    public void hasActiveOrdersTest_true() {
        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2);

        assertTrue(service.hasActiveOrders(user));
    }

    @Test
    public void hasActiveOrdersTest_When_inactive_Then_return_false() {
        Order order1 = new Order(OrderStatus.INACTIVE);
        Order order2 = new Order(OrderStatus.INACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2, order3);

        assertFalse(service.hasActiveOrders(user));
    }

    @Test
    public void canBeReturnedTest_When_no_items_Then_return_true() {
        OrderLine orderLine1 = new OrderLine(false);
        OrderLine orderLine2 = new OrderLine(false);
        OrderLine orderLine3 = new OrderLine(false);
        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertTrue(service.canBeReturned(order));
    }

    @Test
    public void canBeReturnedTest_When_item_have_SO_Then_return_false() {
        OrderLine orderLine1 = new OrderLine(false);
        OrderLine orderLine2 = new OrderLine(true);
        OrderLine orderLine3 = new OrderLine(false);
        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertFalse(service.canBeReturned(order));
    }

    @Test
    public void getMaxPriceOrderTest() {
        Order order1 = new Order(BigDecimal.valueOf(12.5));
        Order order2 = new Order(BigDecimal.valueOf(102.5));
        Order order3 = new Order(BigDecimal.valueOf(1.5));
        User user = new User(order1, order2, order3);

        assertEquals(order2, service.getMaxPriceOrder(user).get());
    }

    @Test
    public void getMaxPriceOrderTest_When_no_orders_Then_return_nothing() {
        User user = new User();
        assertTrue(service.getMaxPriceOrder(user).isEmpty());
    }

}