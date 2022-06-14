package com.protal.portal;

import com.protal.portal.Model.RacePlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlogControllerTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Value("classpath:race.json")
    private Resource raceJson;

    @Value("classpath:blogPost.json")
    private Resource blogPostJson;

    @Value("classpath:deleteRacePlan.json")
    private Resource deleteRacePlanJson;

    @Value("classpath:deleteBlogPost.json")
    private Resource deleteBlogPostJson;

    @BeforeEach
    void setUp(){
         mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
     }

    @Test
    void insertRaceTest() throws Exception {
        byte[] content = readBytesFromResource(raceJson);

        mockMvc.perform(post("/portal/insertRace")
                     .content(content)
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.message").value("Race Plan Created and pending for approval!"));
    }

//    @Test
//    void getDeleteRacePlanTest() throws Exception {
//        byte[] content = readBytesFromResource(deleteRacePlanJson);
//
//        mockMvc.perform(delete("/portal/deleteRacePlan")
//                        .content(content)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful());
//    }

    @Test
    void getAllRacePlansTest() throws Exception {
        mockMvc.perform(get("/portal/getAllRacePlans")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.racePlans", notNullValue()));
    }

    @Test
    void insertBlogPostTest() throws Exception {
        byte[] content = readBytesFromResource(blogPostJson);

        mockMvc.perform(post("/portal/insertBlogPost")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Blog Post Created and pending for approval!"));
    }

    @Test
    void getAllBlogPostsTest() throws Exception {
        mockMvc.perform(get("/portal/getAllBlogPosts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.blogPosts", notNullValue()));
    }

//    @Test
//    void getDeleteBlogPostTest() throws Exception {
//        byte[] content = readBytesFromResource(deleteBlogPostJson);
//
//        mockMvc.perform(delete("/portal/deleteBlogPost")
//                        .content(content)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful());
//    }

    private byte[] readBytesFromResource(Resource resource) throws IOException {
        return Files.readAllBytes(Paths.get(resource.getURI()));

    }

}
