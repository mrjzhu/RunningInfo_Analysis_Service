package com.jz.Runninginformationanalysisservice.service;

import com.jz.Runninginformationanalysisservice.domain.RunningInformation;

import com.jz.Runninginformationanalysisservice.service.impl.RunningInfoDto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vagrant on 6/20/17.
 */
public interface RunningInfoAnalysisService {
    List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInfo);

    List<RunningInfoDto> findRunningInfoOrderByHealthLevel(Pageable pageable);

    void deleteByRunningId(String runningId);
}
