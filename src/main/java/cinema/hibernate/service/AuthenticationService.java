package cinema.hibernate.service;

import cinema.hibernate.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
