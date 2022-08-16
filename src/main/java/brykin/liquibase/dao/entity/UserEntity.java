package brykin.liquibase.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "liquibase_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private Integer age;
}
