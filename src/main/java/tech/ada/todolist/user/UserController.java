package tech.ada.todolist.user;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@ControllerAdvice
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserRequest> salvarUsuario(@Valid @RequestBody UserRequest usuario){
        service.salvarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @RequestMapping("/dto")
    public String salvarUsuarioDTO(@RequestBody UserDTO usuario){
        service.salvarUsuarioDTO(usuario);
        return HttpStatus.OK.toString();
    }

    @GetMapping
    public Iterable<UserDTO> getAllUsuarios(){
        return service.getAll();
    }

    @GetMapping
    @RequestMapping("/one")
    public UserDTO getOneUser(){
        return service.getFirst();
    }

    @GetMapping
    @RequestMapping("/teste")
    public String getAllUsuariosDois(){
        return "Sucesso";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", java.time.LocalDateTime.now());
        body.put("status", org.springframework.http.HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);

        return new ResponseEntity<>(body, org.springframework.http.HttpStatus.BAD_REQUEST);
    }

}