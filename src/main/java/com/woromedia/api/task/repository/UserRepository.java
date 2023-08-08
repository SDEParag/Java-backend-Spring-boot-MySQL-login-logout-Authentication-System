package com.woromedia.api.task.repository;

import com.woromedia.api.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username); //is username present in database return true

    Boolean existsByEmail(String email);  //is email present in database return true
}