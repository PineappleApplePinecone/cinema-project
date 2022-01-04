package cinema.hibernate.service.impl;

import cinema.hibernate.dao.MovieDao;
import cinema.hibernate.lib.Inject;
import cinema.hibernate.lib.Service;
import cinema.hibernate.model.Movie;
import cinema.hibernate.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
