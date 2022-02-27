package com.protal.portal.Responses;

import com.protal.portal.Model.ForumTopics;
import com.protal.portal.secuirtyImpl.models.User;

import java.util.List;

public class ListAllTopicsResponse {
    private List<ForumTopics> forumTopics;


    public ListAllTopicsResponse(List<ForumTopics> forumTopics) {
        this.forumTopics = forumTopics;
    }

    public List<ForumTopics> getForumTopics() {
        return forumTopics;
    }

    public void setForumTopics(List<ForumTopics> forumTopics) {
        this.forumTopics = forumTopics;
    }
}
