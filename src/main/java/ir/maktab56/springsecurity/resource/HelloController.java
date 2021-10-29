package ir.maktab56.springsecurity.resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "home page";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello " + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
