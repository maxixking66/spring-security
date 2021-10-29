package ir.maktab56.springsecurity.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    public static final String TABLE_NAME = "user_table";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String IS_ACTIVE = "is_active";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = USERNAME)
    private String username;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = FIRSTNAME)
    private String firstName;

    @Column(name = LASTNAME)
    private String lastName;

    @Column(name = IS_ACTIVE)
    private Boolean isActive;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

}
