package cinema.hibernate.dao.impl;

import cinema.hibernate.dao.TicketDao;
import cinema.hibernate.exception.DataProcessingException;
import cinema.hibernate.lib.Dao;
import cinema.hibernate.model.Ticket;
import cinema.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't create ticket: " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
