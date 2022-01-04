package cinema.hibernate.service;

import cinema.hibernate.model.Order;
import cinema.hibernate.model.ShoppingCart;
import cinema.hibernate.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
