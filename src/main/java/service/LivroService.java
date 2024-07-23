package service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.LivrosDao;
import domain.Categoria;
import domain.Livro;

/**
 * Implementação do serviço para operações de Livro.
 */
@Service
@Transactional(readOnly = false)
public class LivroService implements LivrosImpl {

    @Autowired
    private LivrosDao livrosDao;

    /**
     * Salva um novo livro.
     * 
     * @param livro O livro a ser salvo.
     */
    @Override
    public void salvar(Livro livro) {
        livrosDao.save(livro);
    }

    /**
     * Exclui um livro pelo seu ID.
     * 
     * @param id O ID do livro a ser excluído.
     */
    @Override
    public void excluir(Long id) {
        livrosDao.delete(id);
    }

    /**
     * Busca um livro pelo seu ID.
     * 
     * @param id O ID do livro.
     * @return O livro encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public Livro buscarPorId(Long id) {
        return livrosDao.findById(id);
    }

    /**
     * Lista todos os livros.
     * 
     * @return A lista de todos os livros.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Livro> ListarTodosLivros() {
        return livrosDao.findAll();
    }

    /**
     * Atualiza um livro existente.
     * 
     * @param livro O livro a ser atualizado.
     */
    @Override
    public void Update(Livro livro) {
        livrosDao.update(livro);
    }

    /**
     * Busca livros por categoria.
     * 
     * @param categoria A categoria dos livros.
     * @return A lista de livros encontrados na categoria.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Livro> BuscarPorCategoria(Categoria categoria) {
        return livrosDao.findByCategoria(categoria);
    }

    /**
     * Busca livros por faixa de preço.
     * 
     * @param precoMin O preço mínimo.
     * @param precoMax O preço máximo.
     * @return A lista de livros encontrados dentro da faixa de preço.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Livro> BuscarPorPreco(BigDecimal precoMin, BigDecimal precoMax) {
        return livrosDao.findByPrecoBetween(precoMin, precoMax);
    }

    /**
     * Busca livros por autor.
     * 
     * @param autor O nome do autor.
     * @return A lista de livros encontrados pelo autor.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Livro> BuscarPorAutor(String autor) {
        return livrosDao.findByNome(autor); // Corrigido para chamar o método correto
    }

    /**
     * Busca livros com base em um termo de pesquisa.
     * 
     * @param termo O termo de pesquisa.
     * @return A lista de livros encontrados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Livro> buscarTodosLivros(String termo) {
        return livrosDao.search(termo);
    }
}
