package ir.maktab56.springsecurity.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = Operation.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation implements Serializable {

    public static final String TABLE_NAME = "operation_table";
    public static final String NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = NAME)
    private String name;

}
