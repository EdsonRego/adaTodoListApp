package tech.ada.todolist.todo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDateTime prazo;
    private Boolean concluida;

    public Tarefa() {
    }

    public Tarefa(String nome, String descricao, LocalDateTime prazo, Boolean concluida) {
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = concluida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
