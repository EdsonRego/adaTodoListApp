package tech.ada.todolist.todo;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TarefaRepository repository;

    public TodoService(TarefaRepository repository) {
        this.repository = repository;
    }

//    private List<Tarefa> repository = new ArrayList<>();

    public void salvarTarefa(Tarefa tarefa){
        repository.save(tarefa);
    }

//    public List<Tarefa> getAll() {
//        return repository;
//    }
}
