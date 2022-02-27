package com.protal.portal.database;

import com.protal.portal.Model.ForumTopics;
import com.protal.portal.secuirtyImpl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumTopicsRepository extends JpaRepository<ForumTopics, Long> {
    List<ForumTopics> findAll();
    //void setApproved(Integer approved, Integer id);

    @Modifying
    @Query("update ForumTopics a set a.approved = :approvedValue where a.id = :topicId")
    void setApprovedById(@Param("topicId") Long id, @Param("approvedValue") Integer approved);

    void deleteById(Long id);

}
