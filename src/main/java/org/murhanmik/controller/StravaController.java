package org.murhanmik.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class StravaController {

    @Value("${strava.token}")
    private String stravaToken;

    @Value("${strava.athlete.id}")
    private String stravaAthleteId;

    @GetMapping(value = "/getStats")
    public ResponseEntity<String> getStats() throws IOException {

        //TODO: Remove this to be a bean creation in config
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", stravaToken);
        headers.set("content-type", "application/json");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String response = restTemplate.exchange("https://www.strava.com/api/v3/athletes/" + stravaAthleteId + "/stats?page=1&per_page=30", HttpMethod.GET, entity, String.class).getBody();

        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
}
