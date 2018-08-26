package org.murhanmik.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AllRunTotals {

    @JsonProperty("count")
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
