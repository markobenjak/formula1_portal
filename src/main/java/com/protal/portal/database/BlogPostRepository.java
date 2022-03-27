package com.protal.portal.database;

import com.protal.portal.Model.BlogPost;
import com.protal.portal.Model.RacePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findAll();
    //void setApproved(Integer approved, Integer id);

}
