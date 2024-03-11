package tech.ada.todolist.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TarefaRepository repository;

    public TodoService(TarefaRepository repository){
        this.repository = repository;
    }

    public void salvarTarefa(Tarefa tarefa){
        repository.save(tarefa);
    }

    public List<Tarefa> getAll() {
        return (List<Tarefa>) repository.findAll();
    }
}