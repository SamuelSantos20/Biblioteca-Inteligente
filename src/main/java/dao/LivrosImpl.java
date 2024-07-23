package dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.Categoria;
import domain.Livro;

/**
 * Implementação da interface LivrosDao para operações de persistência da entidade Livro.
 */
@Repository
public class LivrosImpl extends AbstractDao<Livro, Long> implements LivrosDao {

    /**
     * Busca livros pelo nome (título).
     * 
     * @param nome O nome do livro.
     * @return Uma lista de livros que correspondem ao nome especificado.
     */
    @Override
    public List<Livro> findByNome(String nome) {
        return createQuery("select l from Livro l where l.titulo like concat('%', ?1, '%')", nome);
    }

    /**
     * Busca livros dentro de uma faixa de preço.
     * 
     * @param precoMin O preço mínimo.
     * @param precoMax O preço máximo.
     * @return Uma lista de livros dentro da faixa de preço especificada.
     */
    @Override
    public List<Livro> findByPrecoBetween(BigDecimal precoMin, BigDecimal precoMax) {
        return createQuery("select l from Livro l where l.preco between ?1 and ?2", precoMin, precoMax);
    }

    /**
     * Busca livros por categoria.
     * 
     * @param categoria A categoria dos livros.
     * @return Uma lista de livros da categoria especificada.
     */
    @Override
    public List<Livro> findByCategoria(Categoria categoria) {
        return createQuery("select l from Livro l where l.categoria = ?1", categoria);
    }

    /**
     * Busca livros por um termo específico (nome, título, autor, etc.).
     * 
     * @param termo O termo de busca.
     * @return Uma lista de livros que correspondem ao termo de busca.
     */
    @Override
    public List<Livro> search(String termo) {
        String query = "select l from Livro l where l.titulo like concat('%', ?1, '%') " +
                       "or l.autor like concat('%', ?1, '%') " +
                       "or l.categorias like concat('%', ?1, '%')";
        return createQuery(query, termo);
    }
}
