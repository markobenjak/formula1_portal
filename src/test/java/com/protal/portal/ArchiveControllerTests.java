package com.protal.portal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArchiveControllerTests {

    @Autowired
    private WebApplicationContext context;

     private MockMvc mockMvc;

     @BeforeEach
     void setUp(){
         mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
     }

     @Test
     void driversTest() throws Exception {
         mockMvc.perform(get("/portal/archive/drivers")
                         .param("offset", "0")
                         .param("limit", "10")
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.drivers", notNullValue()));
     }

    @Test
    void constructorsTest() throws Exception {
        mockMvc.perform(get("/portal/archive/constructors")
                        .param("offset", "0")
                        .param("limit", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.constructors", notNullValue()));
    }

    @Test
    void circuitsTest() throws Exception {
        mockMvc.perform(get("/portal/archive/circuits")
                        .param("offset", "0")
                        .param("limit", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.circuits", notNullValue()));
    }

    @Test
    void seasonsTest() throws Exception {
        mockMvc.perform(get("/portal/archive/season/2020")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seasons", notNullValue()));
    }
}
