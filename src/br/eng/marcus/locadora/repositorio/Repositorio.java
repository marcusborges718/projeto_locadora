package br.eng.marcus.locadora.repositorio;

import java.util.List;

/**
 * Interface para implementação de banco de dados
 * @param <T>
 */
public interface Repositorio<T> {

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
     * Lista os objetos inseridos no banco
     * @return
     * @throws Exception
     */
    List<T> listar() throws Exception;

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
    
    /**
     * Retorna o objeto a partir da linha de registro no banco
     * @param linha
     * @return
     * @throws Exception
     */
    T lerObjeto(String linha) throws Exception;

}
