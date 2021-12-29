package com.protal.portal.controllers;


import com.protal.portal.Model.Driver;
import com.protal.portal.Model.Drivers;
import com.protal.portal.Responses.DriverResponse;
import org.apache.catalina.connector.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Collections;

@RestController
@RequestMapping("/portal")
@CrossOrigin
public class PortalController {

    private final RestTemplate restTemplate;

    public PortalController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    @GetMapping("/drivers")
    public DriverResponse getAllDrivers() throws JAXBException {
        DriverResponse driverResponse = new DriverResponse();
        String url = "http://ergast.com/api/f1/drivers?limit=30&offset=20";

        // create headers
        HttpHeaders headers = new HttpHeaders();

// set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

// build the request
        HttpEntity request = new HttpEntity(headers);

// make an HTTP GET request with headers
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );

// check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
            JAXBContext jaxbContext = JAXBContext.newInstance(Drivers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Drivers generatedDrivers = (Drivers) unmarshaller.unmarshal(new StringReader(response.getBody().toString()));
            System.out.println(generatedDrivers);

            for(Driver emp : generatedDrivers.getDrivers())
            {
                System.out.println(emp.getDateOfBirth());
            }

            driverResponse.setStatusCode(response.getStatusCodeValue());
            driverResponse.setStatus("SUCCESS");
            driverResponse.setDrivers(generatedDrivers.getDrivers());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());

            driverResponse.setStatusCode(response.getStatusCodeValue());
            driverResponse.setStatus("Fail");
            driverResponse.setDrivers(null);
        }

        return driverResponse;
    }
}
