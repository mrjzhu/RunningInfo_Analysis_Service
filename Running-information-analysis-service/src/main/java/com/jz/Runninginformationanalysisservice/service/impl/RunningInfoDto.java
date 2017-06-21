package com.jz.Runninginformationanalysisservice.service.impl;
import com.jz.Runninginformationanalysisservice.domain.RunningInformation;
import lombok.Data;

import javax.persistence.Id;

/**
 * Created by vagrant on 6/20/17.
 */
@Data
public class RunningInfoDto {

    public enum HealthWarningLevel {
        NA, LOW, NORMAL, HIGH
    }

    private String runningId;
    private String totalRunningTime;
    private int hearRate;
    @Id
    private Long userid;
    private String userName;
    private String userAddress;
    private HealthWarningLevel healthWarningLevel;

    public RunningInfoDto() {
    }

    public RunningInfoDto(RunningInformation runningInfo){
        this.setRunningId(runningInfo.getRunningId());
        this.setTotalRunningTime(runningInfo.getTotalRunningTime());
        this.setHearRate(runningInfo.getHearRate());
        this.setUserid(runningInfo.getUserid());
        this.setUserName(runningInfo.getUserInfo().getUsername());
        this.setUserAddress(runningInfo.getUserInfo().getAddress());
        this.setHealthWarningLevel(covert(runningInfo.getHearRate()));
    }

    public HealthWarningLevel covert(int hearRate){
        if(hearRate >= 60 && hearRate <= 75){
            return HealthWarningLevel.LOW;
        }
        else if(hearRate > 75 && hearRate <= 120){
            return HealthWarningLevel.NORMAL;
        }
        else if (hearRate > 120){
            return HealthWarningLevel.HIGH;
        }
        else{
            return HealthWarningLevel.NA;
        }

    }
}
