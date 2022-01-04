package cinema.hibernate.service.impl;

import cinema.hibernate.dao.UserDao;
import cinema.hibernate.lib.Inject;
import cinema.hibernate.lib.Service;
import cinema.hibernate.model.User;
import cinema.hibernate.service.UserService;
import cinema.hibernate.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
