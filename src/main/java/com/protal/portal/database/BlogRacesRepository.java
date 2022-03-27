package com.protal.portal.database;

import com.protal.portal.Model.ForumTopics;
import com.protal.portal.Model.RacePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRacesRepository extends JpaRepository<RacePlan, Long> {
    List<RacePlan> findAll();
    //void setApproved(Integer approved, Integer id);

}
