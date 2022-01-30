package com.protal.portal.secuirtyImpl.repository;

import java.util.List;
import java.util.Optional;

import com.protal.portal.secuirtyImpl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  List<User> findAll();

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  void deleteByUsername(String username);
}
