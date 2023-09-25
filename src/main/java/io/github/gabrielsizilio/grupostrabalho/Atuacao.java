/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author gabriel
 */
@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate inicio;
   
    private LocalDate termino;
    
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JsonbTransient
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonbTransient
    private Grupo grupo;

    public Atuacao() {

    }
    
    public Atuacao(LocalDate inicio, LocalDate termino, Pessoa pessoa, Grupo grupo) {
        this.inicio = inicio;
        this.termino = termino;
        this.pessoa = pessoa;
        this.grupo = grupo;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return "io.github.gabrielsizilio.grupostrabalho.Atuacao[ id=" + id + " ]";
    }
    
}
