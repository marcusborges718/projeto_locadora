package br.eng.marcus.locadora.repositorio;

import java.io.File;
import java.util.ArrayList;

/**
 * Interface para implementar métodos de manipular arquivo de banco de dados
 */
public interface IManipulaArquivoBanco<T> {

    /**
     * Seta o caminho/nome do arquivo de banco a ser manipulado
     * @param caminho
     */
    void setArquivoBanco(String caminho) throws Exception;

    /**
     * Retorna o arquivo de banco a ser manipulado
     */
    File getArquivoBanco() throws Exception;

    /**
     * Se o arquivo não existir, cria. Se ja existir não faz nada.
     * @return
     */
    void criarArquivoBanco() throws Exception;

    /**
     * Verifica se o arquivo existe
     * @return
     */
    boolean verificaArquivoBancoExiste() throws Exception;

    /**
     * Limpa o conteúdo do arquivo
     */
    void limparArquivoBanco() throws Exception;

    /**
     * Lê o conteúdo do arquivo linha a linha
     * @return
     */
    ArrayList<String> lerArquivoBanco() throws Exception;

    /**
     * Escreve no arquivo o conteúdo informado limpando o conteúdo anterior
     * @param conteudo
     */
    void escreverArquivoBanco(String conteudo) throws Exception;

    /**
     * Insere no final do arquivo o conteúdo informado, concatenando com o conteúdo anterior
     * @param conteudo
     */
    void inserirArquivoBanco(String conteudo) throws Exception;

    /**
     * Retorna o próximo ID de registro disponível para ser inserido no banco
     * @return
     * @throws Exception
     */
    Integer getProximoID() throws Exception;

}