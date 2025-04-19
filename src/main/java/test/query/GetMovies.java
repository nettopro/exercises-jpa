package test.query;

import java.util.List;

import infra.DAO;
import model.many2many.Actor;
import model.many2many.Movie;

public class GetMovies {
    public static void main(String[] args) {
        
        DAO<Movie> dao = new DAO<>(Movie.class); 
        List<Movie> movies = dao.query(
            "Movie.findByMinRating", "rating",4);

        for(Movie movie : movies ){
            System.out.println(movie.getName() + " => " + movie.getRating());

            for(Actor actor: movie.getActors()){
                System.out.println(actor.getName());
            }
        }

        dao.close();
    }
}
