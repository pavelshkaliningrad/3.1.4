package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(value = "graphRole")
    User findByUsername(String username);

}
