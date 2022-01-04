package cinema.hibernate.service;

import cinema.hibernate.model.MovieSession;
import cinema.hibernate.model.ShoppingCart;
import cinema.hibernate.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
