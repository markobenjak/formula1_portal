package com.protal.portal.controllers;

import com.protal.portal.Model.ForumComments;
import com.protal.portal.Model.ForumTopics;
import com.protal.portal.Responses.ListAllTopicsResponse;
import com.protal.portal.Responses.ListUsersResponse;
import com.protal.portal.database.ForumCommentsRepository;
import com.protal.portal.database.ForumTopicsRepository;
import com.protal.portal.secuirtyImpl.models.User;
import com.protal.portal.secuirtyImpl.models.UserRole;
import com.protal.portal.secuirtyImpl.payload.response.MessageResponse;
import com.protal.portal.secuirtyImpl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/portal")
public class ForumController {

    private final RestTemplate restTemplate;

    public ForumController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    @Autowired
    ForumTopicsRepository forumTopicsRepository;

    @Autowired
    ForumCommentsRepository forumCommentsRepository;

    @PostMapping("/insertTopic")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> insertTopic(@RequestBody Map<String, Object> payLoad) {

        ForumTopics forumTopic = new ForumTopics();
        forumTopic.setTopic((String) payLoad.get("topic"));
        forumTopic.setContent((String) payLoad.get("content"));
        forumTopic.setTopicOwner((String) payLoad.get("topicOwner"));
        forumTopic.setLast_edit_date(null);
        forumTopic.setApproved(0);
        forumTopicsRepository.save(forumTopic);


        return ResponseEntity.ok(new MessageResponse("Topic Created and pending for approval!"));
    }

    @GetMapping("/getAllTopics")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllTopics() {
        List<ForumTopics> forumTopics = new ArrayList<>();
        forumTopicsRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(forumTopics::add);

        return ResponseEntity.ok(new ListAllTopicsResponse(
                forumTopics));
    }

    @Transactional
    @PostMapping("/approveTopic")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveOrDeleteTopic(@RequestBody Map<String, Object> payLoad) {
        if((boolean) payLoad.get("approveValue")){
            System.out.println((Long) payLoad.get("topic"));
            forumTopicsRepository.setApprovedById(((Integer) payLoad.get("topicID")).longValue(), 1);
            return ResponseEntity.ok(new MessageResponse("Topic Approved!"));
        }else{
            forumTopicsRepository.deleteById(((Integer) payLoad.get("topicID")).longValue());
            return ResponseEntity.ok(new MessageResponse("Topic Deleted"));

        }
    }

    @PostMapping("/insertComment")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> insertComment(@RequestBody Map<String, Object> payLoad) {
        Date date = new Date(); // This object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        ForumComments forumComments = new ForumComments();
        forumComments.setComment((String) payLoad.get("comment"));
        forumComments.setComment_owner((String) payLoad.get("commentOwner"));
        forumComments.setTopicId(((Integer) payLoad.get("topicId")).longValue());
        forumCommentsRepository.save(forumComments);


        return ResponseEntity.ok(new MessageResponse("Comment Created"));
    }

    @DeleteMapping("/deleteComment")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteComment(@RequestBody Map<String, Object> payLoad) {
        forumCommentsRepository.deleteById(((Integer) payLoad.get("commentId")).longValue());
        return ResponseEntity.ok(new MessageResponse("Comment deleted successfully!"));
    }
}
