package com.jz.Runninginformationanalysisservice.controller;

import com.jz.Runninginformationanalysisservice.domain.RunningInformation;
import com.jz.Runninginformationanalysisservice.domain.RunningInformationRepository;
import com.jz.Runninginformationanalysisservice.service.RunningInfoAnalysisService;
import com.jz.Runninginformationanalysisservice.service.impl.RunningInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@RestController
public class RunningInformationUploadController {

    private RunningInfoAnalysisService analysisService;


    @Autowired
    public RunningInformationUploadController(RunningInfoAnalysisService analysisService) {
        this.analysisService = analysisService;
    }


    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformation){
        analysisService.saveRunningInfo(runningInformation);
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.GET)
    public List<RunningInfoDto> getResult(
            @RequestParam(name = "page", required =false, defaultValue = "0") int page){
        return this.analysisService.findRunningInfoOrderByHealthLevel(new PageRequest(page,2));
    }


    @RequestMapping(value = "/runningInfo/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){

        this.analysisService.deleteByRunningId(runningId);
    }

}
