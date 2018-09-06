package org.murhanmik.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.murhanmik.model.strava.responses.AllTotals;

public class StravaStats {

    @JsonProperty("all_run_totals")
    private AllTotals allRunTotals;

    @JsonProperty("all_ride_totals")
    private AllTotals allRideTotals;

    public AllTotals getAllRunTotals() {
        return allRunTotals;
    }

    public void setAllRunTotals(AllTotals allRunTotals) {
        this.allRunTotals = allRunTotals;
    }

    public AllTotals getAllRideTotals() {
        return allRideTotals;
    }

    public void setAllRideTotals(AllTotals allRideTotals) {
        this.allRideTotals = allRideTotals;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
