package service;

import java.util.List;
import domain.ListadeLeitura;

/**
 * Interface para operações de serviço da entidade ListadeLeitura.
 */
public interface ListadeLeituraImpl {

    /**
     * Salva uma nova lista de leitura.
     * 
     * @param listadeLeitura A lista de leitura a ser salva.
     */
    void salvarnaListadeLeitura(ListadeLeitura listadeLeitura);

    /**
     * Deleta uma lista de leitura pelo seu ID.
     * 
     * @param id O ID da lista de leitura a ser deletada.
     */
    void deletardaListadeLeitura(Long id);

    /**
     * Lista todas as entradas de leitura para um usuário específico.
     * 
     * @param id O ID do usuário.
     * @return A lista de leitura do usuário.
     */
    List<ListadeLeitura> ListarPorId(Long id);

    /**
     * Lista todas as listas de leitura.
     * 
     * @return A lista de todas as listas de leitura.
     */
    List<ListadeLeitura> ListarTodos();

    /**
     * Atualiza uma lista de leitura existente.
     * 
     * @param leitura A lista de leitura a ser atualizada.
     */
    void Editar(ListadeLeitura leitura);

    /**
     * Busca uma lista de leitura específica por ID.
     * 
     * @param id O ID da lista de leitura.
     * @return A lista de leitura encontrada.
     */
    ListadeLeitura ListarListadeLivrosPorId(Long id);

    /**
     * Busca listas de leitura pelo título.
     * 
     * @param titulo O título do livro.
     * @return A lista de listas de leitura que correspondem ao título.
     */
    List<ListadeLeitura> BuscarPortitulo(String titulo);

}
