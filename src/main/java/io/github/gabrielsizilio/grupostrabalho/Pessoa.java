/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author gabriel
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "Pessoa.findAll",
            query = "SELECT pessoa FROM Pessoa pessoa"),
    @NamedQuery(
            name = "Pessoa.findAllNomes",
            query = "SELECT pessoa.nome FROM Pessoa pessoa"),
    @NamedQuery(
            name = "Pessoa.findAllNomesEnderecos",
            query = "SELECT pessoa.nome, pessoa.endereco FROM Pessoa pessoa"),
    @NamedQuery(
            name = "Pessoa.findAllPessoasAvenida",
            query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro = 1"),
    @NamedQuery(
            name = "Pessoa.findAllPessoasNaoPraca",
            query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro != 2"),
    @NamedQuery(
            name = "Pessoa.findAllNomesTelefones",
            query = "SELECT pessoa.nome, telefones FROM Pessoa pessoa JOIN pessoa.telefones telefones")
})


public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 65)
    private String nome;
    
    @Column(length = 250)
    private String email;
    
    private LocalDate nascimento;
    
    @Transient
    private Byte idade;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;
    
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @OneToMany(mappedBy = "lider", 
            cascade = CascadeType.ALL)
    private List<Grupo> gruposLider;
    
    @OneToMany(mappedBy = "pessoa",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Atuacao> atuacoes;
    
    public Pessoa() {
        telefones = new ArrayList<>();
        gruposLider = new ArrayList<>();
        atuacoes = new ArrayList<>();
    }

    public Pessoa(String nome, String email, LocalDate nascimento) {
        this();
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.idade = (byte) Period.between(nascimento, LocalDate.now()).getYears();
    }
            
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public Byte getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Grupo> getGruposLider() {
        return gruposLider;
    }

    public void setGruposLider(List<Grupo> gruposLider) {
        this.gruposLider = gruposLider;
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
        return "io.github.gabrielsizilio.grupostrabalho.Pessoa[ id=" + id + " ]";
    }
}
