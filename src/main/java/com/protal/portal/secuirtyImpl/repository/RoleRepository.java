package com.protal.portal.secuirtyImpl.repository;

import java.util.List;
import java.util.Optional;

import com.protal.portal.secuirtyImpl.models.ERole;
import com.protal.portal.secuirtyImpl.models.Role;
import com.protal.portal.secuirtyImpl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
  List<Role> findAll();

}
