package tech.ada.todolist.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUser() {
        return (List<User>) repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Integer id, User user) {
        if (repository.existsById(id)) {
            user.setId(id);
            return repository.save(user);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

}
