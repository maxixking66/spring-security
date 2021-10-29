package ir.maktab56.springsecurity.init;

import ir.maktab56.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserService userService;

    @PostConstruct
    public void initData() {
        initUsers();
    }

    private void initUsers() {
        userService.initUsers();
    }

}
