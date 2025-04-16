package model.many2many;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Double rating;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "actors_movies",
        joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id",referencedColumnName = "id")
    )
    private List<Actor> actors;

    public Movie(){

    }

    public Movie(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        if(actors == null){
            actors = new ArrayList<>();
        }
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor){
        if(actor != null && !getActors().contains(actor)){
            getActors().add(actor);
            if(!actor.getMovies().contains(this)){
                actor.getMovies().add(this);
            }
        }
    }
    
}
