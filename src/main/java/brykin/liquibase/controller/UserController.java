package brykin.liquibase.controller;

import brykin.liquibase.dao.UserDAO;
import brykin.liquibase.dao.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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
    public UserEntity setUser(@RequestParam @NotNull Long id, String name, Integer age) {
        log.info("UserController.setUser");
        return userDAO.save(new UserEntity(id, name, age));
    }
}
