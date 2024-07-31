package cz._pf.vopalensky.assignment.backend.repository;

import cz._pf.vopalensky.assignment.backend.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface RateRepository extends JpaRepository<Rate, Long> {
    public final static String GET_RATE_BY_SHORT = "Select r FROM Rate r WHERE r.shortName = :shortName";

    @Query(GET_RATE_BY_SHORT)
    Optional<Rate> findFirstByShort(@Param("shortName") String shortName);
}
