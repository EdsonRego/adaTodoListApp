package tech.ada.todolist.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public UserEntity salvarUsuario(@RequestBody UserEntity user){
        service.salvarUsuario(user);
        return user;
    }

    @GetMapping
    public Iterable<UserDTO> getAllUsers(){
        return service.getAll();
    }

    @GetMapping
    @RequestMapping("/one")
    public UserDTO getOneUser(){
        return service.getFirst();
    }

    @GetMapping
    @RequestMapping("/teste")
    public String getAllUsersDois(){
        return "Sucesso";
    }

}