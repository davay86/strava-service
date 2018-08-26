package org.murhanmik.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class StravaStats {

    @JsonProperty("all_run_totals")
    private AllRunTotals allRunTotals;

    public AllRunTotals getAllRunTotals() {
        return allRunTotals;
    }

    public void setAllRunTotals(AllRunTotals allRunTotals) {
        this.allRunTotals = allRunTotals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
