package nl.leon.myapp.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import nl.leon.myapp.domain.Movie;
import nl.leon.myapp.domain.*; // for static metamodels
import nl.leon.myapp.repository.MovieRepository;
import nl.leon.myapp.service.dto.MovieCriteria;
import nl.leon.myapp.service.dto.MovieDTO;
import nl.leon.myapp.service.mapper.MovieMapper;

/**
 * Service for executing complex queries for {@link Movie} entities in the database.
 * The main input is a {@link MovieCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link MovieDTO} or a {@link Page} of {@link MovieDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class MovieQueryService extends QueryService<Movie> {

    private final Logger log = LoggerFactory.getLogger(MovieQueryService.class);

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    public MovieQueryService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    /**
     * Return a {@link List} of {@link MovieDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<MovieDTO> findByCriteria(MovieCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Movie> specification = createSpecification(criteria);
        return movieMapper.toDto(movieRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link MovieDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<MovieDTO> findByCriteria(MovieCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Movie> specification = createSpecification(criteria);
        return movieRepository.findAll(specification, page)
            .map(movieMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(MovieCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Movie> specification = createSpecification(criteria);
        return movieRepository.count(specification);
    }

    /**
     * Function to convert {@link MovieCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Movie> createSpecification(MovieCriteria criteria) {
        Specification<Movie> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Movie_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Movie_.name));
            }
        }
        return specification;
    }
}
