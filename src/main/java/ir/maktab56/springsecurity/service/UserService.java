package ir.maktab56.springsecurity.service;

import ir.maktab56.springsecurity.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> getUserByUsername(String username);

    void initUsers();

    List<User> getAll();
}
