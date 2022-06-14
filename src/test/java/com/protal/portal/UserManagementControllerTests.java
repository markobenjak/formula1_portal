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
public class UserManagementControllerTests {

    @Autowired
    private WebApplicationContext context;

     private MockMvc mockMvc;

     @BeforeEach
     void setUp(){
         mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
     }

     @Test
     void listUsersTest() throws Exception {
         mockMvc.perform(get("/portal/listUsers")
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.users", notNullValue()));
     }

    @Test
    void getRolesTest() throws Exception {
        mockMvc.perform(get("/portal/getRoles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roles", notNullValue()));
    }

}
