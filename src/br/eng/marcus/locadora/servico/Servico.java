package br.eng.marcus.locadora.servico;

import java.util.List;

/**
 * Interface de métodos para serviços de operações com Repositório
 * @param <T>
 */
public interface Servico<T> {

    /**
     * Exluí um objeto do banco pelo ID
     * @param id
     * @throws Exception
     */
    void excluir(Integer id) throws Exception;

    /**
     * Atualiza os dados de um objeto no banco pelo ID
     * @param objeto
     * @throws Exception
     */
    void atualizar(T objeto) throws Exception;

    /**
     * Insere um objeto no banco retornando o objeto inserido com novo ID
     * @param objeto
     * @return
     * @throws Exception
     */
    T inserir(T objeto) throws Exception;

    /**
     * Busca um objeto no banco pelo ID. Retorna null se o ID não existir
     * @param id
     * @return
     * @throws Exception
     */
    T buscar(Integer id) throws Exception;

    /**
     * Busca um objeto no banco pelo padrão de nome informado
     * @param nome
     * @return
     * @throws Exception
     */
    List<T> buscar(String nome) throws Exception;
   
}
