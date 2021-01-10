package nl.leon.myapp.service;

import nl.leon.myapp.service.dto.MovieDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link nl.leon.myapp.domain.Movie}.
 */
public interface MovieService {

    /**
     * Save a movie.
     *
     * @param movieDTO the entity to save.
     * @return the persisted entity.
     */
    MovieDTO save(MovieDTO movieDTO);

    /**
     * Get all the movies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MovieDTO> findAll(Pageable pageable);


    /**
     * Get the "id" movie.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MovieDTO> findOne(Long id);

    /**
     * Delete the "id" movie.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
