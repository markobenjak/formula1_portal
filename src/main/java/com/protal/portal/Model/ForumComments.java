package com.protal.portal.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "forum_comments")
public class ForumComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotBlank
    @Column(name="comment_owner")
    private String comment_owner;

    @NotBlank
    @Column(name="topicId")
    private Long topicId;

    @NotBlank
    @Column(name="comment")
    private String comment;

    @Basic(optional = false)
    @Column(name = "comment_creation_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creation_date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicId",  insertable=false, updatable=false)
    private ForumTopics forumTopics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment_owner() {
        return comment_owner;
    }

    public void setComment_owner(String comment_owner) {
        this.comment_owner = comment_owner;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    @JsonBackReference
    public ForumTopics getForumTopics() {
        return forumTopics;
    }

    public void setForumTopics(ForumTopics forumTopics) {
        this.forumTopics = forumTopics;
    }
}
