package com.jz.Runninginformationanalysisservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by vagrant on 6/10/17.
 */
@RepositoryRestResource(path = "res")
public interface JsonRepository extends CrudRepository<JsonObject, Long> {
    @RestResource(path = "runners")
    Page<JsonObject> findAllByHearRateGreaterThanOrderByHearRateDesc(@Param("hearRate") int hearRate,Pageable pageable);
}
