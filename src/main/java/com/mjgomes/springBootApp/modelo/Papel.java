package com.mjgomes.springBootApp.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String papel;

    @ManyToMany(mappedBy = "papeis", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    public Papel(String papelString) {
    }

    public Papel(Long id, String papel, List<Usuario> usuarios) {
        super();
        this.id = id;
        this.papel = papel;
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
