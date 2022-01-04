package cinema.hibernate.security;

import cinema.hibernate.exception.AuthenticationException;
import cinema.hibernate.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
