package br.eng.marcus.locadora.repositorio;

import br.eng.marcus.locadora.servico.MarcaServico;
import br.eng.marcus.locadora.servico.Servico;
import br.eng.marcus.locadora.modelo.Marca;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repositorio de banco de dados da Marca
 */
public class MarcaRepositorio extends ManipulaArquivoBanco<Marca> implements Repositorio<Marca> {

    private final String CAMINHO_BANCO = System.getProperty("user.dir") + "/repositorio/BD_MARCAS.txt";
    
    public MarcaRepositorio() throws Exception{
        super.setArquivoBanco(CAMINHO_BANCO);
        super.criarArquivoBanco();
    }

    /**
     * Exluí um objeto do banco pelo ID
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void excluir(Integer id) throws Exception {
        List<Marca> marcas = listar();
        
        List<Marca> marcasNovas = new ArrayList<>();
        
        for(int i =0; i<marcas.size();i++){
            if(!marcas.get(i).getId().equals(id)) marcasNovas.add(marcas.get(i));
        }
        
        List<String> linhas = marcasNovas.stream().map(marca -> marca.toString()).collect(Collectors.toList());
        
        String conteudo = String.join("\n", linhas);
        
        escreverArquivoBanco(conteudo);
    }

    /**
     * Atualiza os dados de um objeto no banco pelo ID
     *
     * @param objeto
     * @throws Exception
     */
    @Override
    public void atualizar(Marca objeto) throws Exception {
        List<Marca> marcas = listar();
        
        for(int i =0; i<marcas.size();i++){
            if(marcas.get(i).getId().equals(objeto.getId())){
                marcas.set(i, objeto);
            }
        }
        
        List<String> linhas = marcas.stream().map(marca -> marca.toString()).collect(Collectors.toList());
        
        String conteudo = String.join("\n", linhas);
        
        escreverArquivoBanco(conteudo);
    }

    /**
     * Insere um objeto no banco retornando o objeto inserido com novo ID
     *
     * @param objeto
     * @return
     * @throws Exception
     */
    @Override
    public Marca inserir(Marca objeto) throws Exception {
        objeto.setId(getProximoID());

        inserirArquivoBanco(objeto.toString());

        return objeto;
    }

    /**
     * Lista os objetos inseridos no banco
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Marca> listar() throws Exception {
        List<Marca> marcas = new ArrayList<>();

        ArrayList<String> conteudoBanco = lerArquivoBanco();
        for(String linha : conteudoBanco){
            Marca marca = this.lerObjeto(linha);
            marcas.add(marca);
        }

        return marcas;
    }

    /**
     * Busca um objeto no banco pelo ID. Retorna null se o ID não existir
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Marca buscar(Integer id) throws Exception {
        List<Marca> marcas = listar();
        
        for(int i =0; i<marcas.size();i++){
            if(marcas.get(i).getId().equals(id)){
                return marcas.get(i);
            }
        }
        
        return null;
    }

    /**
     * Busca um objeto no banco pelo padrão de nome informado
     *
     * @param nome
     * @return
     * @throws Exception
     */
    @Override
    public List<Marca> buscar(String nome) throws Exception {
        List<Marca> marcas = listar();
        
        List<Marca> marcasSelecionadas = new ArrayList<>();
        
        for(int i =0; i<marcas.size();i++){
            if(marcas.get(i).getNome().toLowerCase().contains(nome.toLowerCase())){
                marcasSelecionadas.add(marcas.get(i));
            }
        }
        
        return marcasSelecionadas;
    }
    
    /**
     * Retorna o objeto a partir da linha de registro no banco
     * @param linha
     * @return
     * @throws Exception
     */
    @Override
    public Marca lerObjeto(String linha) throws Exception {
        //Pega a linha que quebra os dados por ";"
        String[] dados = linha.split(";");

        //Valida os campos do objeto
        //////////////////////////////////////////////////////////////////////////////////////////////////

        if(dados.length < 3){
            throw new Exception("Registro corrompido, o ID informado é inválido: '" + dados[0] + "'.");
        }
        
        //Se não conseguir ler o ID do registro lança exceção
        try{
            Integer.parseInt(dados[0]);
        }catch (Exception e){
            //Se não conseguir fazer o parse do ID para Integer, lança exceção de ID inválido
            throw new Exception("Registro corrompido, o ID informado é inválido: '" + dados[0] + "'.");
        }

        //Valida o nome da marca
        if(dados[1]==null || dados[1].trim().isEmpty()) {
            throw new Exception("Registro corrompido, o nome da marca informado é inválido: '" + dados[1] + "'.");
        }

        //Valida a logo da marca
        if(dados[2]==null || dados[2].trim().isEmpty()) {
            throw new Exception("Registro corrompido, a logo da marca informado é inválida: '" + dados[2] + "'.");
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////

        //Validações OK, lê os dados carregando em objeto
        Marca marca = new Marca();
        marca.setId(Integer.valueOf(dados[0]));
        marca.setNome(dados[1]);
        marca.setLogo(dados[2]);

        return marca;
    }
}
