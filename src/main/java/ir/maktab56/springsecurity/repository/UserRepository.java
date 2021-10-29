package ir.maktab56.springsecurity.repository;

import ir.maktab56.springsecurity.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"roles", "roles.operations"})
    Optional<User> getUserByUsername(String username);
}
