package dao;

import java.util.List;


import domain.ListadeLeitura;

/**
 * Interface ListadeLeituraDao para operações de persistência da entidade ListadeLeitura.
 */
public interface ListadeLeituraDao {

    /**
     * Salva uma nova lista de leitura no banco de dados.
     * @param leitura A lista de leitura a ser salva.
     */
    void save(ListadeLeitura leitura);

    /**
     * Exclui uma lista de leitura pelo seu ID.
     * @param id O ID da lista de leitura a ser excluída.
     */
    void delete(Long id);

    /**
     * Retorna todas as listas de leitura.
     * @return Uma lista de todas as listas de leitura.
     */
    List<ListadeLeitura> findAll();

    /**
     * Retorna todas as listas de leitura associadas a um determinado livro.
     * @param id O ID do livro.
     * @return Uma lista de listas de leitura associadas ao livro.
     */
    List<ListadeLeitura> findByLivro(Long id);

    /**
     * Busca uma lista de leitura pelo seu ID.
     * @param id O ID da lista de leitura.
     * @return A lista de leitura encontrada, ou null se não for encontrada.
     */
    ListadeLeitura findById(Long id);

    /**
     * Exclui uma lista de leitura pelo seu ID.
     * @param id O ID da lista de leitura a ser excluída.
     */
    void deletar(Long id);

    /**
     * Atualiza uma lista de leitura existente.
     * @param leitura A lista de leitura a ser atualizada.
     */
    void update(ListadeLeitura leitura);

    /**
     * Busca listas de leitura pelo título do livro.
     * @param titulo O título do livro.
     * @return Uma lista de listas de leitura encontradas pelo título do livro.
     */
    List<ListadeLeitura> findByTitulo(String titulo);
}
