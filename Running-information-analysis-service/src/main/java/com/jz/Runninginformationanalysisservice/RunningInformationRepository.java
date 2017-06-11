package com.jz.Runninginformationanalysisservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by vagrant on 6/10/17.
 */
@RepositoryRestResource(path = "runningInformations")
public interface RunningInformationRepository extends CrudRepository<RunningInformation,Long> {

    @RestResource(path = "result")
    List<RunningInformation> findAllByHearRateGreaterThanOrderByHearRateDesc(int hearRate);

    @RestResource(path = "delete")
    @Transactional
    void deleteRunningInformationByRunningId(@Param("runningId")String runningId);
}

