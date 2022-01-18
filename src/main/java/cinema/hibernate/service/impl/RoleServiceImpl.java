package cinema.hibernate.service.impl;

import cinema.hibernate.dao.RoleDao;
import cinema.hibernate.exception.DataProcessingException;
import cinema.hibernate.model.Role;
import cinema.hibernate.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName)
                .orElseThrow(()
                        -> new DataProcessingException("Can't found role by name: " + roleName));
    }
}
