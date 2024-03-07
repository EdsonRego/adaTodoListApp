package tech.ada.todolist.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }
}
