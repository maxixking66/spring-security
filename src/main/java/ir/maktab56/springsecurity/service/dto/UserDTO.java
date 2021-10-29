package ir.maktab56.springsecurity.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Boolean isActive;

//    private Set<RoleDTO> roles;

}
