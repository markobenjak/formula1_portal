package com.protal.portal.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.protal.portal.secuirtyImpl.models.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "forum_topics")
public class ForumTopics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotBlank
    @Column(name="topic_owner")
    private String topicOwner;

    @NotBlank
    @Column(name="topic")
    private String topic;

    @NotBlank
    @Column(name="post_content")
    private String content;

    @Basic(optional = false)
    @Column(name = "creation_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creation_date;

    @Column(name="last_edit_date")
    private Date last_edit_date;

    @Column(name="approved", columnDefinition = "integer default 0")
    private Integer approved;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forumTopics", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ForumComments> forumComments;

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicOwner() {
        return topicOwner;
    }

    public void setTopicOwner(String topicOwner) {
        this.topicOwner = topicOwner;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(Date last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    @JsonManagedReference
    public List<ForumComments> getForumComments() {
        return forumComments;
    }

    public void setForumComments(List<ForumComments> forumComments) {
        this.forumComments = forumComments;
    }
}
