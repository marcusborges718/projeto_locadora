package br.eng.marcus.locadora.servico;

import br.eng.marcus.locadora.repositorio.MarcaRepositorio;
import br.eng.marcus.locadora.repositorio.Repositorio;
import br.eng.marcus.locadora.modelo.Marca;
import br.eng.marcus.locadora.repositorio.IManipulaArquivoBanco;
import br.eng.marcus.locadora.repositorio.ManipulaArquivoBanco;
import java.util.List;

/**
 * Serviço de operações com Repositório de Marcas
 */
public class MarcaServico implements Servico<Marca> {

    /**
     * Repositório de dados
     */
    private final Repositorio<Marca> repositorio;

    public MarcaServico() throws Exception{
        this.repositorio = new MarcaRepositorio();
    }
    
    /**
     * Arquivo de banco de dados
     */
    private IManipulaArquivoBanco<Marca> manipulaArquivoBanco = new ManipulaArquivoBanco<>();
    
    /**
     * Exluí um objeto do banco pelo ID
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void excluir(Integer id) throws Exception {
        this.repositorio.excluir(id);
    }

    /**
     * Atualiza os dados de um objeto no banco pelo ID
     *
     * @param objeto
     * @throws Exception
     */
    @Override
    public void atualizar(Marca marca) throws Exception {
        if(marca.getId()==null){
            throw new Exception("O ID da marca informada é inválido!");
        }
        
        if(marca.getNome()==null || marca.getNome().trim().isEmpty()){
            throw new Exception("O nome da marca informada é inválido!");
        }
        
        if(marca.getLogo()==null || marca.getLogo().trim().isEmpty()){
            throw new Exception("A logo da marca informada é inválida!");
        }
        this.repositorio.atualizar(marca);
    }

    /**
     * Insere um objeto no banco retornando o objeto inserido com novo ID
     *
     * @param objeto
     * @return
     * @throws Exception
     */
    @Override
    public Marca inserir(Marca marca) throws Exception {
        if(marca.getNome()==null || marca.getNome().trim().isEmpty()){
            throw new Exception("O nome da marca informada é inválido!");
        }
        
        if(marca.getLogo()==null || marca.getLogo().trim().isEmpty()){
            throw new Exception("A logo da marca informada é inválida!");
        }        
        return this.repositorio.inserir(marca);
    }

    /**
     * Busca um objeto no banco pelo ID. Retorna null se o ID não existir
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Marca buscar(Integer id) throws Exception {
        return this.repositorio.buscar(id);
    }

    /**
     * Busca um objeto no banco pelo padrão de nome informado
     * @param nome
     * @return
     * @throws Exception
     */
    @Override
    public List<Marca> buscar(String nome) throws Exception {
        if(nome==null || nome.trim().isEmpty()){
            return this.repositorio.listar();
        }else{
            return this.repositorio.buscar(nome.trim().toLowerCase());
        }
    }
}
