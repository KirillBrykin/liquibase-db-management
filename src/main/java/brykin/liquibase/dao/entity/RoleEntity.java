package brykin.liquibase.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "liquibase_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    private Long id;
    private String name;
}