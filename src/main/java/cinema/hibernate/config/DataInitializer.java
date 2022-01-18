package cinema.hibernate.config;

import cinema.hibernate.model.Role;
import cinema.hibernate.model.User;
import cinema.hibernate.service.RoleService;
import cinema.hibernate.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role firstAdmin = new Role();
        firstAdmin.setRole(Role.Authority.ADMIN);
        roleService.add(firstAdmin);
        Role firstUser = new Role();
        firstUser.setRole(Role.Authority.USER);
        roleService.add(firstUser);
        User admin = new User();
        admin.setEmail("firstAdmin@gmail.com");
        admin.setPassword("123456");
        admin.setRoles(Set.of(firstAdmin));
        User user = new User();
        user.setEmail("firstUser@gmail.com");
        user.setPassword("654321");
        user.setRoles(Set.of(firstUser));
        userService.add(admin);
        userService.add(user);
    }
}
