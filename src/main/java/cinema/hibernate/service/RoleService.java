package cinema.hibernate.service;

import cinema.hibernate.model.Role;

public interface RoleService {
    void add(Role role);

    Role getByName(String roleName);
}
