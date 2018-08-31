package org.murhanmik.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

public class ActivityDetails {

    List<ActivityDetail> activityDetailList;

    public ActivityDetails(List<ActivityDetail> activityDetailList) {
        this.activityDetailList = activityDetailList;
    }

    public List<ActivityDetail> getActivityDetailList() {
        return activityDetailList;
    }

    public void setActivityDetailList(List<ActivityDetail> activityDetailList) {
        this.activityDetailList = activityDetailList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
