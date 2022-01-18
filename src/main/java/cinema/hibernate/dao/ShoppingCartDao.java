package cinema.hibernate.dao;

import cinema.hibernate.model.ShoppingCart;
import cinema.hibernate.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
