package com.protal.portal.database;

import com.protal.portal.Model.ForumComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumCommentsRepository extends JpaRepository<ForumComments, Long> {


}
