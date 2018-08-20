package br.com.vasco.WebServiceCadastroSocio.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Socio.findByName", query = "SELECT s FROM Socio s WHERE s.nome LIKE '%?%'")
@Table(name = "socio")
public class Socio implements Serializable {

    public static final String FIND_BY_NAME = "Socio.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeSocio", nullable = false)
    private String nome;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "cpf")
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}