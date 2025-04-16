package test.many2many;

import infra.DAO;
import model.many2many.Actor;
import model.many2many.Movie;

public class NewMovieActor {
    public static void main(String[] args) {
        
        Movie movieA = new Movie("Star Wars Ep 4", 4.6);
        Movie movieB = new Movie("The Fugitive",3.7);

        Actor actorA = new Actor("Harrison Ford");
        Actor actressA = new Actor("Carrie Fisher");

        movieA.addActor(actorA);
        movieA.addActor(actressA);

        movieB.addActor(actorA);

        DAO<Movie> dao = new DAO<>();
        dao.insertAtomic(movieA);
    }
}
