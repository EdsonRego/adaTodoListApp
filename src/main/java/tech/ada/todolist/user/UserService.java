package tech.ada.todolist.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    private UserService(UserRepository repository){
        this.repository = repository;
    }

    public void salvarUsuario(UserEntity user){
        repository.save(user);
    }

    public Iterable<UserDTO> getAll(){
//        repository.findAll().forEach(entidade -> {
//
//        });
        return null;
    }

    public UserDTO getFirst() {
        UserEntity entidade = repository.findById(1).get();

        return new UserDTO(entidade);
    }
}