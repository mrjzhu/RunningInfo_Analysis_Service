package com.jz.Runninginformationanalysisservice.domain;

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

    @Embedded
    @AttributeOverride(name = "user", column = @Column(name = "user_info"))
    private UserInfo userInfo;

    public RunningInformation() {this.userInfo = null;}

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    @JsonCreator
    public RunningInformation(@JsonProperty("runningId") String runningId,
                              @JsonProperty("latitude") double latitude,
                              @JsonProperty("longitude") double longitude,
                              @JsonProperty("runningDistance") String runningDistance,
                              @JsonProperty("totalRunningTime") String totalRunningTime,
                              @JsonProperty("hearRate") int hearRate,
                              @JsonProperty("timeStamp") Date timeStamp,
                              @JsonProperty("userInfo") UserInfo userInfo){
        this.runningId = runningId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.runningDistance = runningDistance;
        this.totalRunningTime = totalRunningTime;
        this.hearRate = hearRate;
        this.timeStamp = timeStamp;
        this.userInfo = userInfo;


    }





}
