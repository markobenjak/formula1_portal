package com.protal.portal;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainPageControllerTests {

    @Autowired
    private WebApplicationContext context;

     private MockMvc mockMvc;

     @BeforeEach
     void setUp(){
         mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
     }

     @Test
     void currentSeasonTest() throws Exception {
         mockMvc.perform(get("/portal/currentSeason")
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.currentSeason", notNullValue()));
     }

    @Test
    void newsTest() throws Exception {
        mockMvc.perform(get("/portal/news")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.secondaryNews", notNullValue()));
    }

    @Test
    void socialMediaTest() throws Exception {
        mockMvc.perform(get("/portal/socialMedia")
                        .param("hashtag", "formula1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.urls", notNullValue()));
    }

    @Test
    void socialMediaNoParamTest() throws Exception {
        mockMvc.perform(get("/portal/socialMedia")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
