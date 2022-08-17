package brykin.liquibase.controller;

import brykin.liquibase.dao.UserDAO;
import brykin.liquibase.dao.entity.RoleEntity;
import brykin.liquibase.dao.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping(path = "/api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDAO userDAO;

    @GetMapping
    public List<UserEntity> getUser() {
        log.info("UserController.getUser");
        return userDAO.findAll();
    }

    @PostMapping
    public UserEntity setUser(@RequestParam @NotNull Long id, @NotNull String name, Integer age, Long roleId, String roleName) {
        log.info("UserController.setUser");
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        List<RoleEntity> roles = new ArrayList<>();
        if (roleId != null) {
            RoleEntity role = new RoleEntity(roleId, roleName);
            roles.add(role);
        }
        user.setRoles(roles);
        return userDAO.save(user);
    }
}