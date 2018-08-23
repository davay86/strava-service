package org.murhanmik.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllRunTotals {

    @JsonProperty("count")
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
