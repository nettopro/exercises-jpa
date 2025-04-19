package test.query;

import infra.DAO;
import model.query.MovieRating;

public class GetMovieAverage {
    public static void main(String[] args) {
        DAO<MovieRating> dao = new DAO<>(MovieRating.class);
        MovieRating rating = dao.queryOne("getGeneralMovieAverage");
        System.out.println(rating.getAverage());

        dao.close();

    }
}
