package nmit03.nmit03e05.service;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

import lombok.Data;
import nmit03.nmit03e05.domain.Movie;

@Data

@Service
public class MovieService {
    
    private Set<Movie> movies= new LinkedHashSet<>(); 
    
    public boolean addMovie(String name){
        return movies.add(new Movie(name));
    }

    public static Movie findMovieByName(LinkedHashSet<Movie> movies, String name){
        for (Movie movie : movies) {
            if (movie.getName().equals(name)){
                return movie; 
            }
        }
        return null; 
    }
    
    public void vote(String name){
        Movie movie = findMovieByName((LinkedHashSet<Movie>) movies, name); 
        movie.setVotes((byte) (movie.getVotes() + 1));
    }


}
