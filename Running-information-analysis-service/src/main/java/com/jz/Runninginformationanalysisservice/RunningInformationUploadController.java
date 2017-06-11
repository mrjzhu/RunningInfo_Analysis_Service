package com.jz.Runninginformationanalysisservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/10/17.
 */
@RestController
public class RunningInformationUploadController {

    private RunningInformationRepository repository;

    private JsonRepository JsonRepository;

    @Autowired
    public RunningInformationUploadController(RunningInformationRepository repository,JsonRepository jsonRepository) {
        this.repository = repository;
        this.JsonRepository = jsonRepository;
    }


    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformation){
        this.repository.save(runningInformation);
    }

    @RequestMapping(value = "/runningInfo/{hearRate}", method = RequestMethod.GET)
    public Page<JsonObject> getResult(
            @PathVariable String hearRate,
            @RequestParam(name = "page") int page){
        this.JsonRepository.save(findAll());
        return this.JsonRepository.findAllByHearRateGreaterThanOrderByHearRateDesc(0,new PageRequest(page,2));
    }


    public List<JsonObject> findAll(){
//        List<JsonObject> result = new ArrayList<>();
//        Iterable<RunningInformation> list = this.repository.findAllByHearRateGreaterThan(0);
//        Iterator<RunningInformation> IT = list.iterator();
//        while(IT.hasNext()) {
//            RunningInformation tmp = IT.next();
//            JsonObject res = new JsonObject(tmp.getRunningId(),tmp.getTotalRunningTime(),tmp.getHearRate(),tmp.getUserid(),
//            tmp.getUserInfo().getUsername(),tmp.getUserInfo().getAddress(),tmp.getHealthWarningLevel());
////            res.setRunningId(tmp.getRunningId());
////            res.setTotalRunningTime(tmp.getTotalRunningTime());
////            res.setHearRate(tmp.getHearRate());
////            res.setUserid(tmp.getUserid());
////            res.setUserName(tmp.getUserInfo().getUsername());
////            res.setUserAddress(tmp.getUserInfo().getAddress());
////            res.setHealthWarningLevel(tmp.getHealthWarningLevel());
//            result.add(res);
//        }
//        return result;
        List<JsonObject> result = new ArrayList<>();
        List<RunningInformation> list = this.repository.findAllByHearRateGreaterThanOrderByHearRateDesc(0);
        for(RunningInformation tmp: list) {
            JsonObject res = new JsonObject(tmp.getRunningId(), tmp.getTotalRunningTime(), tmp.getHearRate(), tmp.getUserid(),
                    tmp.getUserInfo().getUsername(), tmp.getUserInfo().getAddress(), tmp.getHealthWarningLevel());
            result.add(res);
        }

        return result;


    }

    @RequestMapping(value = "/delete/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){

        this.repository.deleteRunningInformationByRunningId(runningId);
    }

}
