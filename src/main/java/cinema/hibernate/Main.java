package cinema.hibernate;

import cinema.hibernate.lib.Injector;
import cinema.hibernate.model.CinemaHall;
import cinema.hibernate.model.Movie;
import cinema.hibernate.model.MovieSession;
import cinema.hibernate.model.ShoppingCart;
import cinema.hibernate.model.User;
import cinema.hibernate.security.AuthenticationService;
import cinema.hibernate.service.CinemaHallService;
import cinema.hibernate.service.MovieService;
import cinema.hibernate.service.MovieSessionService;
import cinema.hibernate.service.OrderService;
import cinema.hibernate.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Injector injector = Injector.getInstance("cinema.hibernate");
    private static final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final CinemaHallService cinemaHallService
            = (CinemaHallService) injector.getInstance(CinemaHallService.class);
    private static final MovieService movieService
            = (MovieService) injector.getInstance(MovieService.class);
    private static final MovieSessionService movieSessionService
            = (MovieSessionService) injector.getInstance(MovieSessionService.class);
    private static final ShoppingCartService shoppingCartService
            = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    private static final OrderService orderService
            = (OrderService) injector.getInstance(OrderService.class);

    public static void main(String[] args) {
        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");

        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");

        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        System.out.println(cinemaHallService.getAll());
        System.out.println(cinemaHallService.get(firstCinemaHall.getId()));

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        System.out.println(movieSessionService.get(yesterdayMovieSession.getId()));
        System.out.println(movieSessionService.findAvailableSessions(
                        fastAndFurious.getId(), LocalDate.now()));

        User adam = authenticationService.register("firstEmail@gmail.com", "123456");

        shoppingCartService.addSession(tomorrowMovieSession, adam);
        shoppingCartService.addSession(yesterdayMovieSession, adam);
        ShoppingCart adamShoppingCart = shoppingCartService.getByUser(adam);
        System.out.println(adamShoppingCart);

        orderService.completeOrder(adamShoppingCart);
        orderService.getOrdersHistory(adam).forEach(System.out::println);

    }
}
