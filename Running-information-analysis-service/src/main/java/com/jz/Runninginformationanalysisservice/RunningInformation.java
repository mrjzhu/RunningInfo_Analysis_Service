package com.jz.Runninginformationanalysisservice;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 6/10/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    @Id
    @GeneratedValue
    private Long userid;
    private String runningId;
    private double latitude;
    private double longitude;

    private String runningDistance;
    private String totalRunningTime;
    private int hearRate;
    private Date timeStamp = new Date();

    private String healthWarningLevel;
    @Embedded
    @AttributeOverride(name = "user", column = @Column(name = "user_info"))
    private UserInfo userInfo;

    public RunningInformation() {this.userInfo = null;}

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("healthWarningLevel") int hearRate){
        int L = 60, R = 200;
        double temp = Math.random()*(R - L);
        this.hearRate = (int)temp + L;

        if(this.hearRate >= 60 && this.hearRate <= 75){
            this.healthWarningLevel = "LOW";
        }
        else if(this.hearRate > 75 && this.hearRate <= 120){
            this.healthWarningLevel = "NORMAL";
        }
        else{
            this.healthWarningLevel = "HIGH";
        }


    }



}
