package com.protal.portal.secuirtyImpl.repository;

import com.protal.portal.secuirtyImpl.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
  long deleteByUserId(Integer userId);

}
