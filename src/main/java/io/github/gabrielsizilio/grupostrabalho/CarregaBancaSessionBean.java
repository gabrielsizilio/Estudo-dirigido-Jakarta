/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author gabriel
 */
@Singleton
@Startup
public class CarregaBancaSessionBean implements CarregaBancaSessionBeanLocal {
    
    @Inject PessoaSessionBeanLocal entityManager;
     
    @PostConstruct
    @Override
    public void popularBanco() {
    
        //<editor-fold defaultstate="collapsed" desc="Enderecos">

            Endereco endereco1 = new Endereco(TipoLogradouro.RUA, "1", 1111, "Humberto");
            Endereco endereco2 = new Endereco(TipoLogradouro.AVENIDA, "2", 2222, "Doisberto");
            Endereco endereco3 = new Endereco(TipoLogradouro.AVENIDA, "3", 3333, "Trêsberto");
            Endereco endereco4 = new Endereco(TipoLogradouro.PRACA, "4", 4444, "Quatroberto");

            //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Telefones">

        Telefone telefone1 = new Telefone((byte)11, 11111111);
        Telefone telefone2 = new Telefone((byte)12, 12121212);
        Telefone telefone3 = new Telefone((byte)13, 13131313);
        Telefone telefone4 = new Telefone((byte)22, 22222222);
        Telefone telefone5 = new Telefone((byte)44, 44444444);
        Telefone telefone6 = new Telefone((byte)45, 45454545);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Grupos">

        Grupo grupo1 = new Grupo("Estudo I", Boolean.FALSE);
        Grupo grupo2 = new Grupo("Estudo II", Boolean.TRUE);
        Grupo grupo3 = new Grupo("Estudo III", Boolean.FALSE);
        Grupo grupo4 = new Grupo("Estudo VI", Boolean.TRUE);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="pessoa1">

        Pessoa pessoa1 = new Pessoa("Ana Zaira", "ana@mail.com", LocalDate.of(2001, 1, 1));
        pessoa1.setEndereco(endereco1);

        pessoa1.getTelefones().add(telefone1);
        pessoa1.getTelefones().add(telefone2);
        pessoa1.getTelefones().add(telefone3);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="pessoa2">

        Pessoa pessoa2 = new Pessoa("Beatriz Yana", "beatriz@mail.com", LocalDate.of(2002   , 2, 2));
        pessoa2.setEndereco(endereco2);

        pessoa2.getTelefones().add(telefone4);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="pessoa3">

        Pessoa pessoa3 = new Pessoa("Cecília Xerxes", "cecilia@mail.com", LocalDate.of(2003, 3, 3));
        pessoa3.setEndereco(endereco3);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="pessoa4">

        Pessoa pessoa4 = new Pessoa("Débora Wendel", "debora@mail.com", LocalDate.of(2004, 4, 4 ));
        pessoa4.setEndereco(endereco4);

        pessoa4.getTelefones().add(telefone5);
        pessoa4.getTelefones().add(telefone6);

        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Atuacoes">

        Atuacao atuacao1 = new Atuacao(LocalDate.of(2011, 1, 1), LocalDate.of(2021, 11, 11), pessoa1, grupo1);
        Atuacao atuacao2 = new Atuacao(LocalDate.of(2012, 1, 1), LocalDate.of(2022, 11, 11), pessoa1, grupo1);
        Atuacao atuacao3 = new Atuacao(LocalDate.of(2012, 1, 2), LocalDate.of(2021, 1, 12), pessoa2, grupo1);
        Atuacao atuacao4 = new Atuacao(LocalDate.of(2013, 1, 3), LocalDate.of(2021, 1, 13), pessoa3, grupo1);
        Atuacao atuacao5 = new Atuacao(LocalDate.of(2014, 1, 4), LocalDate.of(2021, 1, 14), pessoa4, grupo1);
        grupo1.getAtuacoes().add(atuacao1);
        grupo1.getAtuacoes().add(atuacao2);
        grupo1.getAtuacoes().add(atuacao3);
        grupo1.getAtuacoes().add(atuacao4);
        grupo1.getAtuacoes().add(atuacao5);
        Atuacao atuacao6 = new Atuacao(LocalDate.of(2012, 1, 2), null , pessoa2, grupo2);
        Atuacao atuacao7 = new Atuacao(LocalDate.of(2012, 1, 2), null , pessoa4, grupo2);
        grupo2.getAtuacoes().add(atuacao6);
        grupo2.getAtuacoes().add(atuacao7);
        Atuacao atuacao8 = new Atuacao(LocalDate.of(2012, 1, 3), LocalDate.of(2023, 1, 13), pessoa3, grupo3);
        Atuacao atuacao9 = new Atuacao(LocalDate.of(2012, 1, 3), LocalDate.of(2023, 1, 13), pessoa4, grupo3);
        grupo2.getAtuacoes().add(atuacao8);
        grupo2.getAtuacoes().add(atuacao9);
        Atuacao atuacao10 = new Atuacao(LocalDate.of(2012, 1, 4), LocalDate.of(2024, 1, 14), pessoa2, grupo4);
        Atuacao atuacao11 = new Atuacao(LocalDate.of(2012, 1, 4), LocalDate.of(2024, 1, 14), pessoa3, grupo4);
        Atuacao atuacao12 = new Atuacao(LocalDate.of(2012, 1, 4), LocalDate.of(2024, 1, 14), pessoa4, grupo4);
        grupo2.getAtuacoes().add(atuacao10);
        grupo2.getAtuacoes().add(atuacao11);
        grupo2.getAtuacoes().add(atuacao12);

        pessoa1.getGruposLider().add(grupo1);
        grupo1.setLider(pessoa1);
        pessoa1.getAtuacoes().add(atuacao1);
        pessoa1.getAtuacoes().add(atuacao2);

        pessoa2.getGruposLider().add(grupo2);
        pessoa2.getGruposLider().add(grupo4);
        grupo2.setLider(pessoa2);
        pessoa2.getAtuacoes().add(atuacao3);
        pessoa2.getAtuacoes().add(atuacao6);
        pessoa2.getAtuacoes().add(atuacao10);

        pessoa3.getGruposLider().add(grupo3);
        grupo3.setLider(pessoa3);
        pessoa3.getGruposLider().add(grupo3);
        pessoa3.getAtuacoes().add(atuacao4);
        pessoa3.getAtuacoes().add(atuacao8);
        pessoa3.getAtuacoes().add(atuacao11);

        grupo4.setLider(pessoa2);
        pessoa4.getAtuacoes().add(atuacao7);
        pessoa4.getAtuacoes().add(atuacao9);
        pessoa4.getAtuacoes().add(atuacao5);
        pessoa4.getAtuacoes().add(atuacao12);

        //</editor-fold>

        entityManager.salvar(pessoa1);
        entityManager.salvar(pessoa2);
        entityManager.salvar(pessoa3);
        entityManager.salvar(pessoa4);
    }
}
