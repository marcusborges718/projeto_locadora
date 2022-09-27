package br.eng.marcus.locadora.repositorio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManipulaArquivoBanco<T> implements IManipulaArquivoBanco<T> {

    private File arquivoRepositorio;

    /**
     * Seta o caminho/nome do arquivo de banco a ser manipulado
     *
     * @param caminho
     */
    @Override
    public void setArquivoBanco(String caminho) throws Exception {
        this.arquivoRepositorio = new File(caminho);
    }

    /**
     * Retorna o arquivo de banco a ser manipulado
     */
    @Override
    public File getArquivoBanco() throws Exception {
        if(this.arquivoRepositorio==null) throw new Exception("Arquivo de banco não definido!");
        return this.arquivoRepositorio;
    }

    /**
     * Se o arquivo não existir, cria. Se ja existir não faz nada.
     *
     * @return
     */
    @Override
    public void criarArquivoBanco() throws Exception {
        if(!verificaArquivoBancoExiste()){
            Files.createDirectories(Path.of(getArquivoBanco().getParent()));
            getArquivoBanco().createNewFile();
        }
    }

    /**
     * Verifica se o arquivo existe
     *
     * @return
     */
    @Override
    public boolean verificaArquivoBancoExiste() throws Exception {
        return this.arquivoRepositorio != null && this.arquivoRepositorio.exists();
    }

    /**
     * Limpa o conteúdo do arquivo
     */
    @Override
    public void limparArquivoBanco() throws Exception {
        //Abre o arquivo e escreve conteúdo vazio nele
        FileWriter fileWriter = new FileWriter(getArquivoBanco());
        fileWriter.write("");
        fileWriter.close();
    }

    /**
     * Lê o conteúdo do arquivo linha a linha
     *
     * @return
     */
    @Override
    public ArrayList<String> lerArquivoBanco() throws Exception {
        //Lê todas linhas do arquivo
        List<String> linhas = Files.readAllLines(Paths.get(getArquivoBanco().getAbsolutePath()));
        //Filtra linhas vazias
        linhas = linhas.stream().filter(linha -> !linha.trim().isEmpty()).collect(Collectors.toList());
        return new ArrayList<>(linhas);
    }

    /**
     * Escreve no arquivo o conteúdo informado limpando o conteúdo anterior
     *
     * @param conteudo
     */
    @Override
    public void escreverArquivoBanco(String conteudo) throws Exception {
        FileWriter fileWriter = new FileWriter(getArquivoBanco());
        fileWriter.write(conteudo);
        fileWriter.close();
    }

    /**
     * Insere no final do arquivo o conteúdo informado, concatenando com o conteúdo anterior
     *
     * @param conteudo
     */
    @Override
    public void inserirArquivoBanco(String conteudo) throws Exception {
        ArrayList<String> linhas = lerArquivoBanco();
        linhas.add(conteudo);

        String novoConteudo = String.join("\n", linhas);

        escreverArquivoBanco(novoConteudo);
    }

    /**
     * Retorna o próximo ID de registro disponível para ser inserido no banco
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer getProximoID() throws Exception {
        //Carrega todas linhas do arquivo de banco
        ArrayList<String> linhas = lerArquivoBanco();

        //Variável para armazenar o maior ID já registrado no arquivo
        Integer maiorID = 0;

        //Pega linha por linha
        for(int i = 0; i < linhas.size(); i++){

            //Pega a linha que quebra os dados por ";"
            String[] linha = linhas.get(i).split(";");

            //Declara o ID do registro
            Integer id = null;
            try{
                //Tenta ler o ID informado
                id = Integer.parseInt(linha[0]);
            }catch (Exception e){
                //Se não conseguir fazer o parse do ID para Integer, lança exceção de ID inválido
                throw new Exception("Registro corrompido na linha " + (i+1) + ", o ID informado é inválido: '" + linha[0] + "'.");
            }

            //Verifica se o ID lido for maior que o 'maiorID' armazena ele
            if(id > maiorID) maiorID = id;
        }

        //Retorna o maior ID lido + 1, para ser o ID do próximo registro
        return maiorID + 1;
    }
}
