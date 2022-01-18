package cinema.hibernate.dao.impl;

import cinema.hibernate.dao.AbstractDao;
import cinema.hibernate.dao.TicketDao;
import cinema.hibernate.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
