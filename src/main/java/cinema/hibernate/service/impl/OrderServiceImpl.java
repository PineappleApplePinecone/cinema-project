package cinema.hibernate.service.impl;

import cinema.hibernate.dao.OrderDao;
import cinema.hibernate.lib.Inject;
import cinema.hibernate.lib.Service;
import cinema.hibernate.model.Order;
import cinema.hibernate.model.ShoppingCart;
import cinema.hibernate.model.User;
import cinema.hibernate.service.OrderService;
import cinema.hibernate.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        order.setTickets(List.copyOf(shoppingCart.getTickets()));
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getByUser(user);
    }
}
