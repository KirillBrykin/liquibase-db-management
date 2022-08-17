package brykin.liquibase.dao.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "liquibase_user")
@Data
public class UserEntity {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer age;
    private String email;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "userId")
    @ToString.Exclude
    private List<RoleEntity> roles;
}