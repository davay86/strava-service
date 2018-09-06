package org.murhanmik.controller;

import org.murhanmik.model.AveragePaceForRun;
import org.murhanmik.model.StravaStats;
import org.murhanmik.model.strava.responses.ActivityDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StravaController {

    public static final int SECONDS_PER_MINUTE = 60;
    public static final double METRES_PER_MILE = 1609.344;
    @Value("${strava.token}")
    private String stravaToken;

    @Value("${strava.athlete.id}")
    private String stravaAthleteId;

    @GetMapping(value = "/getStats", produces = "application/json")
    public ResponseEntity<StravaStats> getStats() throws IOException {

        //TODO: Remove this to be a bean creation in config
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", stravaToken);
        headers.set("content-type", "application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("https://www.strava.com/api/v3/athletes/" + stravaAthleteId + "/stats?page=1&per_page=30", HttpMethod.GET, entity, StravaStats.class);

    }

    @GetMapping(value = "/getMinPerMileRuns", produces = "application/json")
    public ResponseEntity<List<AveragePaceForRun>> getMinPerMileRuns() throws IOException {

        //TODO: Remove this to be a bean creation in config
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", stravaToken);
        headers.set("content-type", "application/json");


        HttpEntity<String> entity = new HttpEntity<String>(headers);

        List<ActivityDetail> activityDetails = Arrays.asList(restTemplate.exchange("https://www.strava.com/api/v3/athlete/activities?per_page=200",
                HttpMethod.GET,
                entity,
                ActivityDetail[].class).getBody());

        List<AveragePaceForRun> averagePaceForRuns = new ArrayList<>();

        activityDetails.stream().filter(e -> e.getType().equals("Run")).forEach(e -> averagePaceForRuns.add(
                new AveragePaceForRun(e.getActivityId(),
                        e.getStartDate(),
                        calculateAveragePace(e.getDistance(), e.getMovingTime()))));

        return new ResponseEntity<>(averagePaceForRuns, HttpStatus.OK);

    }

    private double calculateAveragePace(String distance, String movingTime) {
        return (Double.parseDouble(movingTime) / SECONDS_PER_MINUTE) / (Double.parseDouble(distance) / METRES_PER_MILE);
    }
}
