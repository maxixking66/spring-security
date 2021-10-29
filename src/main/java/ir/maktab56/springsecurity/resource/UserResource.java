package ir.maktab56.springsecurity.resource;

import io.swagger.annotations.ApiOperation;
import ir.maktab56.springsecurity.mapper.UserMapper;
import ir.maktab56.springsecurity.service.UserService;
import ir.maktab56.springsecurity.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping
    @ApiOperation(value = "information")
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(
                userMapper.convertListEntityToDTO(
                        userService.getAll()
                )
        );
    }

}
