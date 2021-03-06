package cinema.hibernate.dao;

import cinema.hibernate.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
