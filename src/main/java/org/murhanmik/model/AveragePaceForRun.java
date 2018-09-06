package org.murhanmik.model;

public class AveragePaceForRun {

    String runId;
    String dateOfRun;
    double averagePace;

    public AveragePaceForRun() {
    }

    public AveragePaceForRun(String runId, String dateOfRun, double averagePace) {
        this.runId = runId;
        this.dateOfRun = dateOfRun;
        this.averagePace = averagePace;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getDateOfRun() {
        return dateOfRun;
    }

    public void setDateOfRun(String dateOfRun) {
        this.dateOfRun = dateOfRun;
    }

    public double getAveragePace() {
        return averagePace;
    }

    public void setAveragePace(double averagePace) {
        this.averagePace = averagePace;
    }
}
