package cinema.hibernate.dao.impl;

import cinema.hibernate.dao.AbstractDao;
import cinema.hibernate.dao.RoleDao;
import cinema.hibernate.exception.DataProcessingException;
import cinema.hibernate.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> query = session.createQuery("FROM Role WHERE role =:role", Role.class);
            query.setParameter("role", Role.Authority.getEnumByName(roleName));
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + roleName + " not found", e);
        }
    }
}
