package cinema.hibernate.dao;

import cinema.hibernate.model.Order;
import cinema.hibernate.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
