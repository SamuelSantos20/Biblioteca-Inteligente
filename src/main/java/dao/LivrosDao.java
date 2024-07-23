package dao;

import java.math.BigDecimal;
import java.util.List;

import domain.Categoria;
import domain.Livro;

/**
 * Interface LivrosDao para operações de persistência da entidade Livro.
 */
public interface LivrosDao {

    /**
     * Salva um novo livro no banco de dados.
     * @param livro O livro a ser salvo.
     */
    void save(Livro livro);

    /**
     * Exclui um livro pelo seu ID.
     * @param id O ID do livro a ser excluído.
     */
    void delete(Long id);

    /**
     * Retorna todos os livros.
     * @return Uma lista de todos os livros.
     */
    List<Livro> findAll();

    /**
     * Busca um livro pelo seu ID.
     * @param id O ID do livro.
     * @return O livro encontrado, ou null se não for encontrado.
     */
    Livro findById(Long id);

    /**
     * Atualiza um livro existente.
     * @param livro O livro a ser atualizado.
     */
    void update(Livro livro);

    /**
     * Busca livros por um termo específico (nome, título, autor, etc.).
     * @param termo O termo de busca.
     * @return Uma lista de livros que correspondem ao termo de busca.
     */
    List<Livro> search(String termo);

    /**
     * Busca livros por categoria.
     * @param categoria A categoria dos livros.
     * @return Uma lista de livros da categoria especificada.
     */
    List<Livro> findByCategoria(Categoria categoria);

    /**
     * Busca livros dentro de uma faixa de preço.
     * @param precoMin O preço mínimo.
     * @param precoMax O preço máximo.
     * @return Uma lista de livros dentro da faixa de preço especificada.
     */
    List<Livro> findByPrecoBetween(BigDecimal precoMin, BigDecimal precoMax);

    /**
     * Busca livros pelo nome.
     * @param nome O nome do livro.
     * @return Uma lista de livros que correspondem ao nome especificado.
     */
    List<Livro> findByNome(String nome);
}
