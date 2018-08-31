package org.murhanmik.controller;

import org.murhanmik.model.ActivityDetail;
import org.murhanmik.model.StravaStats;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StravaController {

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
    public ResponseEntity<List<ActivityDetail>> getMinPerMileRuns() throws IOException {

        //TODO: Remove this to be a bean creation in config
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", stravaToken);
        headers.set("content-type", "application/json");


        HttpEntity<String> entity = new HttpEntity<String>(headers);

        List<ActivityDetail> activityDetails = Arrays.asList(restTemplate.exchange("https://www.strava.com/api/v3/athlete/activities?per_page=200", HttpMethod.GET, entity, ActivityDetail[].class).getBody());

        List<ActivityDetail> runDetails = activityDetails.stream().filter(e -> e.getType().equals("Run")).collect(Collectors.<ActivityDetail>toList());

        return new ResponseEntity<>(runDetails, HttpStatus.OK);


    }
}
