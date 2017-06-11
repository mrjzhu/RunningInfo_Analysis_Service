package com.jz.Runninginformationanalysisservice;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vagrant on 6/10/17.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "JsonTable")
public class JsonObject {
    private String runningId;

    private String totalRunningTime;
    private int hearRate;
    @Id
    private Long userid;
    private String userName;
    private String userAddress;
    private String healthWarningLevel;

    public JsonObject(){

    }
    @JsonCreator
    public JsonObject(@JsonProperty("runningId") String runningId,
                      @JsonProperty("totalRunningTime") String totalRunningTime,
                      @JsonProperty("hearRate") int hearRate,
                      @JsonProperty("userid") Long userid,
                      @JsonProperty("userName") String userName,
                      @JsonProperty("userAddress") String userAddress,
                      @JsonProperty("healthWarningLevel") String healthWarningLevel)

    {
        this.runningId = runningId;
        this.totalRunningTime = totalRunningTime;
        this.hearRate = hearRate;
        this.userid = userid;
        this.userName = userName;
        this.userAddress = userAddress;
        this.healthWarningLevel = healthWarningLevel;
    }
}
