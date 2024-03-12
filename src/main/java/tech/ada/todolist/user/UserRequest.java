package tech.ada.todolist.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

    @NotNull(message = "nome não pode estar nulo")
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotNull
    @NotBlank
    private String email;
    @NotNull(message = "senha não pode estar nula")
    @NotBlank(message = "senha não pode estar em branco")
    @Pattern(regexp = "[\\w.]{5,20}")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
