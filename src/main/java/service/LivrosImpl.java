package service;

import java.math.BigDecimal;
import java.util.List;

import domain.Categoria;
import domain.Livro;

/**
 * Interface que define os contratos para os serviços de manipulação de livros.
 */
public interface LivrosImpl {

    /**
     * Salva um novo livro.
     * 
     * @param livro O livro a ser salvo.
     */
    void salvar(Livro livro);
    
    /**
     * Exclui um livro pelo seu ID.
     * 
     * @param id O ID do livro a ser excluído.
     */
    void excluir(Long id);
    
    /**
     * Busca um livro pelo seu ID.
     * 
     * @param id O ID do livro.
     * @return O livro encontrado.
     */
    Livro buscarPorId(Long id);
    
    /**
     * Lista todos os livros.
     * 
     * @return A lista de todos os livros.
     */
    List<Livro> ListarTodosLivros();
    
    /**
     * Atualiza um livro existente.
     * 
     * @param livro O livro a ser atualizado.
     */
    void Update(Livro livro);
    
    /**
     * Busca livros por categoria.
     * 
     * @param categoria A categoria dos livros.
     * @return A lista de livros encontrados na categoria.
     */
    List<Livro> BuscarPorCategoria(Categoria categoria);
    
    /**
     * Busca livros por faixa de preço.
     * 
     * @param precoMin O preço mínimo.
     * @param precoMax O preço máximo.
     * @return A lista de livros encontrados dentro da faixa de preço.
     */
    List<Livro> BuscarPorPreco(BigDecimal precoMin, BigDecimal precoMax);
    
    /**
     * Busca livros por autor.
     * 
     * @param autor O nome do autor.
     * @return A lista de livros encontrados pelo autor.
     */
    List<Livro> BuscarPorAutor(String autor);
    
    /**
     * Busca livros com base em um termo de pesquisa.
     * 
     * @param termo O termo de pesquisa.
     * @return A lista de livros encontrados.
     */
    List<Livro> buscarTodosLivros(String termo);
}
