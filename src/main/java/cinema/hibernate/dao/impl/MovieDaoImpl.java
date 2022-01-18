package cinema.hibernate.dao.impl;

import cinema.hibernate.dao.AbstractDao;
import cinema.hibernate.dao.MovieDao;
import cinema.hibernate.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
