/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author gabriel
 */
@Entity
public class Grupo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 65)
    private String nome;
    
    private Boolean ativo;
    
    @ManyToOne
    @JsonbTransient
    private Pessoa lider;
    
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
            )
    private List<Atuacao> atuacoes;

    public Grupo() {
        this.atuacoes = new ArrayList<>();
    }
    
    public Grupo(String nome, Boolean ativo) {
        this();
        this.nome = nome;
        this.ativo = ativo;
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters/settters">
    
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }
        
    //</editor-fold>

    @Override
    public String toString() {
        return "io.github.gabrielsizilio.grupostrabalho.Grupo[ id=" + id + " ]";
    }
}
