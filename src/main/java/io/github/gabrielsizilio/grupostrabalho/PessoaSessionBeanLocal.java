/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabriel
 */
@Local
public interface PessoaSessionBeanLocal {

    void salvar(Pessoa pessoa);

    Pessoa buscarId(Long id);

    List<Pessoa> findAllPessoaQuery();

    List<Pessoa> findAllPessoaTyedQuery();

    List<Pessoa> findAllPessoaNamedQuery();

    List<Object[]> findAllNomesQuery();

    List<Object[]> findAllNomesTypedQuery();

    List<Object[]> findAllNomesNamedQuery();

    List<Object[]> findAllNomesEnderecosQuery();

    List<Object[]> findAllNomesEnderecosTypedQuery();

    List<Object[]> findAllNomesEnderecosNamedQuery();

    List<Pessoa> findAllPessoasAvenidaQuery();

    List<Pessoa> findAllPessoasAvenidaTypedQuery();

    List<Pessoa> findAllPessoasAvenidaNamedQuery();

    List<Pessoa> findAllPessoasNaoPracaQuery();

    List<Pessoa> findAllPessoasNaoPracaTypedQuery();

    List<Pessoa> findAllPessoasNaoPracaNamedQuery();

    List<Object[]> findAllNomesTelefonesQuery();

    List<Object[]> findAllNomesTelefonesTypedQuery();

    List<Object[]> findAllNomesTelefonesNamedQuery();

    List<Pessoa> findAllPessoasNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

    List<Pessoa> findAllPessoasPorDDD(Byte DDD);

    List<Pessoa> findAllPessoasSemTelefone();

    List<Object[]> countTelefonesPorPessoa();

    List<Grupo> findAllGruposAtivos();

    List<Object[]> findAllLideresGrupos();

    List<Object[]> findAllNomesMembrosGruopo(String nomeGrupo);

    List<Grupo> findAllGruposByLider(String nomeLider);

    List<Object[]> findAllAtuacoesGruposNomes(String nomeMembro);

    List<Grupo> findAllGruposNameLike(String Like);

    List<Object[]> findAllGruposNomesMembrosCount();

    List<Object[]> findAllGruposCountAtuacao(Integer qtdAtuacao);
    
}
