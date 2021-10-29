package ir.maktab56.springsecurity.service.impl;

import ir.maktab56.springsecurity.domain.User;
import ir.maktab56.springsecurity.repository.UserRepository;
import ir.maktab56.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    @Transactional
    public void initUsers() {
        if (userRepository.count() == 0) {
            userRepository.save(
                    User.builder()
                            .firstName("ali")
                            .lastName("erfagh")
                            .username("ali")
                            .password("123456")
                            .isActive(true)
                            .build()
            );

            userRepository.save(
                    User.builder()
                            .firstName("milad")
                            .lastName("abdi")
                            .username("milad")
                            .password("123456")
                            .isActive(true)
                            .build()
            );
        }
    }

    @Override
    @PreAuthorize(value = "hasRole('ADMIN')")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public <P> P getUserByUsername(String username, Class<P> clazz) {
        return userRepository.getUserByUsername(username, clazz);
    }

}
