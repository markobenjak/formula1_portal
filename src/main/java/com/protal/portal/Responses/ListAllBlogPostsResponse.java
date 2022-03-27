package com.protal.portal.Responses;

import com.protal.portal.Model.BlogPost;
import com.protal.portal.Model.RacePlan;

import java.util.List;

public class ListAllBlogPostsResponse {
    private List<BlogPost> blogPosts;

    public ListAllBlogPostsResponse(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
}
