package com.protal.portal.controllers;


import com.protal.portal.Model.Circuits;
import com.protal.portal.Model.Constructors;
import com.protal.portal.Model.Drivers;
import com.protal.portal.Model.Seasons;
import com.protal.portal.Responses.CircuitsResponse;
import com.protal.portal.Responses.ConstructorsResponse;
import com.protal.portal.Responses.DriverResponse;
import com.protal.portal.Responses.SeasonsResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Collections;

@RestController
@RequestMapping("/portal/archive")
@CrossOrigin
public class PortalArchiveController {

    private final RestTemplate restTemplate;

    public PortalArchiveController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    @GetMapping("/drivers")
    public DriverResponse getAllDrivers(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) throws JAXBException {
        DriverResponse driverResponse = new DriverResponse();
        String url = "http://ergast.com/api/f1/drivers?limit=" + limit + "&offset=" + offset;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Drivers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Drivers generatedDrivers = (Drivers) unmarshaller.unmarshal(new StringReader(response.getBody().toString()));
            driverResponse.setStatusCode(response.getStatusCodeValue());
            driverResponse.setStatus("SUCCESS");
            driverResponse.setTotalDrivers(generatedDrivers.getTotal());
            driverResponse.setDrivers(generatedDrivers.getDrivers());
        } else {
            driverResponse.setStatusCode(response.getStatusCodeValue());
            driverResponse.setStatus("Fail");
            driverResponse.setDrivers(null);
        }

        return driverResponse;
    }

    @GetMapping("/constructors")
    public ConstructorsResponse getAllConstructors(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) throws JAXBException {
        ConstructorsResponse constructorsResponse = new ConstructorsResponse();
        String url = "http://ergast.com/api/f1/constructors?limit=" + limit + "&offset=" + offset;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Constructors.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Constructors generatedConstructors = (Constructors) unmarshaller.unmarshal(new StringReader(response.getBody().toString()));
            constructorsResponse.setStatusCode(response.getStatusCodeValue());
            constructorsResponse.setStatus("SUCCESS");
            constructorsResponse.setTotalConstructors(generatedConstructors.getTotal());
            constructorsResponse.setConstructors(generatedConstructors.getConstructors());
        } else {
            constructorsResponse.setStatusCode(response.getStatusCodeValue());
            constructorsResponse.setStatus("Fail");
            constructorsResponse.setConstructors(null);
        }

        return constructorsResponse;
    }

    @GetMapping("/circuits")
    public CircuitsResponse getAllCircuits(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) throws JAXBException {
        CircuitsResponse circuitsResponse = new CircuitsResponse();
        String url = "http://ergast.com/api/f1/circuits?limit=" + limit + "&offset=" + offset;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Circuits.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Circuits generatedCircuits = (Circuits) unmarshaller.unmarshal(new StringReader(response.getBody().toString()));
            circuitsResponse.setStatusCode(response.getStatusCodeValue());
            circuitsResponse.setStatus("SUCCESS");
            circuitsResponse.setTotalCircuits(generatedCircuits.getTotal());

            circuitsResponse.setCircuits(generatedCircuits.getCircuits());
        } else {
            circuitsResponse.setStatusCode(response.getStatusCodeValue());
            circuitsResponse.setStatus("Fail");
            circuitsResponse.setCircuits(null);
        }

        return circuitsResponse;
    }

    @GetMapping("/season/{year}")
    public SeasonsResponse getSeasons(@PathVariable String year) throws JAXBException {
        SeasonsResponse seasonsResponse = new SeasonsResponse();
        String url = "http://ergast.com/api/f1/" + year + "/driverStandings";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Seasons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Seasons generatedCircuits = (Seasons) unmarshaller.unmarshal(new StringReader(response.getBody().toString()));
            seasonsResponse.setStatusCode(response.getStatusCodeValue());
            seasonsResponse.setStatus("SUCCESS");
            seasonsResponse.setSeasons(generatedCircuits.getSeasons());
        } else {
            seasonsResponse.setStatusCode(response.getStatusCodeValue());
            seasonsResponse.setStatus("Fail");
            seasonsResponse.setSeasons(null);
        }

        return seasonsResponse;
    }
}
