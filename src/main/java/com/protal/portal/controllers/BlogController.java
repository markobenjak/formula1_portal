package com.protal.portal.controllers;

import com.protal.portal.Model.BlogPost;
import com.protal.portal.Model.RacePlan;
import com.protal.portal.Responses.ListAllBlogPostsResponse;
import com.protal.portal.Responses.ListAllRacePlansResponse;
import com.protal.portal.database.BlogPostRepository;
import com.protal.portal.database.BlogRacesRepository;
import com.protal.portal.secuirtyImpl.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/portal")
public class BlogController {

    private final RestTemplate restTemplate;

    public BlogController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }
    @Autowired
    BlogRacesRepository blogRacesRepository;

    @Autowired
    BlogPostRepository blogPostRepository;

    @PostMapping("/insertRace")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> insertTopic(@RequestBody Map<String, Object> payLoad) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(payLoad.get("marker"));
        JSONArray data = new JSONArray(payLoad.get("marker").toString());
        ArrayList<String> list = new ArrayList<String>();
        RacePlan racePlan = new RacePlan();
        for (int i = 0; i < data.length(); ++i) {
            JSONObject position = data.getJSONObject(i).getJSONObject("position");
            racePlan.setLatitude(position.getDouble("lat"));
            racePlan.setLongitude(position.getDouble("lng"));
            // ...
        }
        racePlan.setTitle((String) payLoad.get("title"));
        racePlan.setContent((String) payLoad.get("planDescription"));
        racePlan.setPlanOwner((String) payLoad.get("planOwner"));
        racePlan.setPrice((String) payLoad.get("price"));
        racePlan.setFrom(dateFormat.parse((String) payLoad.get("from")));
        racePlan.setTo(dateFormat.parse((String) payLoad.get("to")));
        racePlan.setContactPhone((String) payLoad.get("contactPhone"));
        racePlan.setContactEmail((String) payLoad.get("contactEmail"));
        racePlan.setApproved(0);
        blogRacesRepository.save(racePlan);


        return ResponseEntity.ok(new MessageResponse("Race Plan Created and pending for approval!"));
    }

    @GetMapping("/getAllRacePlans")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllRaces() {
        List<RacePlan> racePlans = new ArrayList<>();
        blogRacesRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(racePlans::add);

        return ResponseEntity.ok(new ListAllRacePlansResponse(
                racePlans));
    }

    @DeleteMapping("/deleteRacePlan")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRacePlan(@RequestBody Map<String, Object> payLoad) {
        blogRacesRepository.deleteById(((Integer) payLoad.get("racePlanId")).longValue());
        return ResponseEntity.ok(new MessageResponse("Race Plan deleted successfully!"));
    }

    @PostMapping("/insertBlogPost")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> insertBlogPost(@RequestBody Map<String, Object> payLoad) throws ParseException {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle((String) payLoad.get("topic"));
        blogPost.setContent((String) payLoad.get("blogContent"));
        blogPost.setPostOwner((String) payLoad.get("userName"));

        blogPostRepository.save(blogPost);


        return ResponseEntity.ok(new MessageResponse("Blog Post Created and pending for approval!"));
    }

    @GetMapping("/getAllBlogPosts")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllBlogPosts() {
        List<BlogPost> blogPosts = new ArrayList<>();
        blogPostRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(blogPosts::add);

        return ResponseEntity.ok(new ListAllBlogPostsResponse(
                blogPosts));
    }

    @DeleteMapping("/deleteBlogPost")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteBlogPost(@RequestBody Map<String, Object> payLoad) {
        blogPostRepository.deleteById(((Integer) payLoad.get("blogPostId")).longValue());
        return ResponseEntity.ok(new MessageResponse("Blog Post deleted successfully!"));
    }
}
