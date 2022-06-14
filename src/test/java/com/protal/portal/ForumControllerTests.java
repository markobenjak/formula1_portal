package com.protal.portal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForumControllerTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Value("classpath:topic.json")
    private Resource forumTopicJson;

    @Value("classpath:approveTopic.json")
    private Resource approveTopicJson;

    @Value("classpath:deleteTopic.json")
    private Resource deleteTopicJson;

    @Value("classpath:comment.json")
    private Resource commentJson;

    @BeforeEach
    void setUp(){
         mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
     }

    @Test
    void insertTopicTest() throws Exception {
        byte[] content = readBytesFromResource(forumTopicJson);

        mockMvc.perform(post("/portal/insertTopic")
                     .content(content)
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.message").value("Topic Created and pending for approval!"));
    }

    @Test
    void getAllTopicsTest() throws Exception {
        mockMvc.perform(get("/portal/getAllTopics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.forumTopics", notNullValue()));
    }

    @Test
    void approveTopicTest() throws Exception {
        byte[] content = readBytesFromResource(approveTopicJson);

        mockMvc.perform(post("/portal/approveTopic")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Topic Approved!"));
    }

    @Test
    void insertCommentTest() throws Exception {
        byte[] content = readBytesFromResource(commentJson);

        mockMvc.perform(post("/portal/insertComment")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Comment Created"));
    }

    private byte[] readBytesFromResource(Resource resource) throws IOException {
        return Files.readAllBytes(Paths.get(resource.getURI()));

    }

}
