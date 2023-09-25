/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package io.github.gabrielsizilio.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author gabriel
 */
@Stateless
public class PessoaSessionBean implements PessoaSessionBeanLocal {
    @PersistenceContext(unitName = "GruposTrabalhoPU")
    
    private EntityManager entityManager;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void salvar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Override
    public Pessoa buscarId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findAllPessoaQuery() {
        Query query = entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa");
         return (List<Pessoa>) query.getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaTyedQuery() {
        TypedQuery query = entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa", Pessoa.class);
        return query.getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesQuery() {
        return (List<Object[]>) entityManager.createQuery("SELECT pessoa.nome FROM Pessoa pessoa").getResultList();
    }

    @Override
    public List<Object[]> findAllNomesTypedQuery() {
        return entityManager.createQuery("SELECT pessoa.nome FROM Pessoa pessoa", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAllNomes", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesEnderecosQuery() {
        return entityManager.createQuery("SELECT pessoa.nome, pessoa.endereco FROM Pessoa pessoa").getResultList();   
    }

    @Override
    public List<Object[]> findAllNomesEnderecosTypedQuery() {
        return entityManager.createQuery("SELECT pessoa.nome, pessoa.endereco FROM Pessoa pessoa", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesEnderecosNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAllNomesEnderecos", Object[].class).getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasAvenidaQuery() {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro = :tipoLogradouro")
                .setParameter("tipoLogradouro", TipoLogradouro.AVENIDA)
                .getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasAvenidaTypedQuery() {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro = :tipoLogradouro", Pessoa.class)
                .setParameter("tipoLogradouro", TipoLogradouro.AVENIDA)
                .getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasAvenidaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAllPessoasAvenida", Pessoa.class).getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasNaoPracaQuery() {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro != :tipoLogradouro")
                .setParameter("tipoLogradouro", TipoLogradouro.PRACA)
                .getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasNaoPracaTypedQuery() {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro != :tipoLogradouro", Pessoa.class)
                .setParameter("tipoLogradouro", TipoLogradouro.PRACA)
                .getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasNaoPracaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAllPessoasNaoPraca", Pessoa.class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesTelefonesQuery() {
        return entityManager.createQuery("SELECT pessoa.nome, telefones FROM Pessoa pessoa JOIN pessoa.telefones telefones").getResultList();
    }

    @Override
    public List<Object[]> findAllNomesTelefonesTypedQuery() {
        return entityManager.createQuery("SELECT pessoa.nome, telefones FROM Pessoa pessoa JOIN pessoa.telefones telefones", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesTelefonesNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAllNomesTelefones", Object[].class).getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasNascimentoBetween(LocalDate dataInicio, LocalDate dataFim) {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE nascimento BETWEEN :dataInicio AND :dataFim", Pessoa.class)
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim)
                .getResultList();

    }

    @Override
    public List<Pessoa> findAllPessoasPorDDD(Byte DDD) {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa JOIN pessoa.telefones telefone WHERE telefone.ddd IS :DDD", Pessoa.class)
                .setParameter("DDD", DDD)
                .getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoasSemTelefone() {
        return entityManager.createQuery("SELECT pessoa FROM Pessoa pessoa WHERE pessoa.telefones IS EMPTY", Pessoa.class).getResultList();
    }

    @Override
    public List<Object[]> countTelefonesPorPessoa() {
        return entityManager.createQuery("SELECT pessoa.nome, COUNT(telefone) FROM Pessoa pessoa JOIN pessoa.telefones telefone GROUP BY pessoa.nome", Object[].class).getResultList();
    }

    @Override
    public List<Grupo> findAllGruposAtivos() {
        return entityManager.createQuery("SELECT grupo FROM Grupo grupo WHERE grupo.ativo IS false", Grupo.class).getResultList();
    }

    @Override
    public List<Object[]> findAllLideresGrupos() {
        return entityManager.createQuery("SELECT grupo.nome, grupo.lider.nome FROM Grupo grupo", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findAllNomesMembrosGruopo(String nomeGrupo) {
        return entityManager.createQuery("SELECT atuacao.pessoa.nome FROM Grupo grupo JOIN grupo.atuacoes atuacao WHERE grupo.nome IS :nomeGrupo ORDER BY atuacao.pessoa.nome DESC", Object[].class)
                .setParameter("nomeGrupo", nomeGrupo)
                .getResultList();
    }

    @Override
    public List<Grupo> findAllGruposByLider(String nomeLider) {
        return entityManager.createQuery("SELECT grupo FROM Grupo grupo WHERE grupo.lider.nome IS :nomeLider", Grupo.class)
                .setParameter("nomeLider", nomeLider)
                .getResultList();
    }

    @Override
    public List<Object[]> findAllAtuacoesGruposNomes(String nomeMembro) {
        return entityManager.createQuery("SELECT atuacao.inicio, atuacao.termino, grupo.nome "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "WHERE atuacao.pessoa.nome IS :nomeMembro", Object[].class)
                .setParameter("nomeMembro", nomeMembro)
                .getResultList();
        
    }

    @Override
    public List<Grupo> findAllGruposNameLike(String Like) {
        return entityManager.createQuery("SELECT grupo "
                + "FROM Grupo grupo "
                + "WHERE grupo.nome LIKE :like", Grupo.class)
                .setParameter("like", "%"+Like+"%")
                .getResultList();
    }

    @Override
    public List<Object[]> findAllGruposNomesMembrosCount() {
        return entityManager.createQuery("SELECT grupo.nome, COUNT(DISTINCT pessoa) "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "JOIN atuacao.pessoa pessoa "
                + "GROUP BY grupo.nome", Object[].class)
                .getResultList();
        
    }

    @Override
    public List<Object[]> findAllGruposCountAtuacao(Integer qtdAtuacao) {
        return entityManager.createQuery("SELECT grupo.nome, COUNT(atuacao) "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "GROUP BY grupo.nome "
                + "HAVING COUNT(atuacao) >= :qtdAtuacao", Object[].class)
                .setParameter("qtdAtuacao", (long)qtdAtuacao)
                .getResultList();
                
    }
    
    
    
    
}
