package com.jz.Runninginformationanalysisservice.service.impl;

import com.jz.Runninginformationanalysisservice.domain.RunningInformation;
import com.jz.Runninginformationanalysisservice.domain.RunningInformationRepository;
import com.jz.Runninginformationanalysisservice.service.RunningInfoAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/20/17.
 */
@Service
public class RunningInfoAnalysisServiceImpl implements RunningInfoAnalysisService{

    @Autowired
    private RunningInformationRepository repository;


    @Override
    public List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInfo) {
        int L = 60, R = 200;
        for(RunningInformation N : runningInfo){
            double temp = Math.random()*(R - L);
            N.setHearRate((int)temp + L);
        }
        return repository.save(runningInfo);
    }

    @Override
    public List<RunningInfoDto> findRunningInfoOrderByHealthLevel(Pageable pageable) {
        return covertToRunningInfoDto(repository.findAllByOrderByHearRateDesc(pageable));
    }


    @Override
    public void deleteByRunningId(String runningId) {
        repository.deleteRunningInformationByRunningId(runningId);
    }

    public List<RunningInfoDto> covertToRunningInfoDto(Page<RunningInformation> runningInfo){
        List<RunningInformation> runningInfo2 = runningInfo.getContent();
        List<RunningInfoDto> runningInfoDto = new ArrayList<>();
        for(RunningInformation n: runningInfo2){
            runningInfoDto.add(new RunningInfoDto(n));
        }
        return  runningInfoDto;
    }
}
