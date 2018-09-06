package org.murhanmik.model.strava.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ActivityDetail {

    @JsonProperty("id")
    String activityId;

    @JsonProperty("type")
    String type;

    @JsonProperty("start_date")
    String startDate;

    @JsonProperty("distance")
    String distance;

    @JsonProperty("moving_time")
    String movingTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMovingTime() {
        return movingTime;
    }

    public void setMovingTime(String movingTime) {
        this.movingTime = movingTime;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
