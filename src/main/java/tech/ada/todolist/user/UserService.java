package tech.ada.todolist.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    private UserService(UserRepository repository){
        this.repository = repository;
    }

    public void salvarUsuario(UserRequest usuario){
        repository.save(new UserEntity(usuario));
    }

    public void salvarUsuarioDTO(UserDTO usuario){
        repository.save(new UserEntity(usuario));
    }

    public Iterable<UserDTO> getAll(){
//        Iterable<UsuarioDTO> retorno = metodoQueConverteEntidadeParaDTO();
        return metodoQueConverteEntidadeParaDTO();
    }

    private List<UserDTO> metodoQueConverteEntidadeParaDTO() {

        List<UserDTO> listaDeDTOs = new ArrayList<>();

        repository.findAll().forEach(item -> {
            listaDeDTOs.add(new UserDTO(item));
        });

        return listaDeDTOs;
    }

    public UserDTO getFirst() {
        UserEntity entidade = repository.findById(1).get();

        return new UserDTO(entidade);
    }
}