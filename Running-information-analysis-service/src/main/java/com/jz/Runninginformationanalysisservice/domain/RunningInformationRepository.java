package com.jz.Runninginformationanalysisservice.domain;

import com.jz.Runninginformationanalysisservice.domain.RunningInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vagrant on 6/10/17.
 */
@RepositoryRestResource(path = "runningInformations")
public interface RunningInformationRepository extends JpaRepository<RunningInformation,Long> {

    @RestResource(path = "result")
    Page<RunningInformation> findAllByOrderByHearRateDesc(Pageable pageable);

    @RestResource(path = "delete")
    @Transactional
    void deleteRunningInformationByRunningId(@Param("runningId")String runningId);
}

