package nl.leon.myapp.service.mapper;


import nl.leon.myapp.domain.*;
import nl.leon.myapp.service.dto.MovieDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Movie} and its DTO {@link MovieDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MovieMapper extends EntityMapper<MovieDTO, Movie> {



    default Movie fromId(Long id) {
        if (id == null) {
            return null;
        }
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }
}
