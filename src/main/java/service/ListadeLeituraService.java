package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ListadeLeituraDao;
import domain.ListadeLeitura;

/**
 * Implementação do serviço para operações de ListadeLeitura.
 */
@Service
@Transactional(readOnly = false)
public class ListadeLeituraService implements ListadeLeituraImpl {

    @Autowired
    private ListadeLeituraDao listadeLeituraDao;

    /**
     * Salva uma nova lista de leitura.
     * 
     * @param listadeLeitura A lista de leitura a ser salva.
     */
    @Override
    public void salvarnaListadeLeitura(ListadeLeitura listadeLeitura) {
        listadeLeituraDao.save(listadeLeitura);
    }

    /**
     * Deleta uma lista de leitura pelo seu ID.
     * 
     * @param id O ID da lista de leitura a ser deletada.
     */
    @Override
    public void deletardaListadeLeitura(Long id) {
        listadeLeituraDao.deletar(id);
    }

    /**
     * Lista todas as entradas de leitura para um usuário específico.
     * 
     * @param id O ID do usuário.
     * @return A lista de leitura do usuário.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ListadeLeitura> ListarPorId(Long id) {
        return listadeLeituraDao.findByLivro(id);
    }

    /**
     * Lista todas as listas de leitura.
     * 
     * @return A lista de todas as listas de leitura.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ListadeLeitura> ListarTodos() {
        return listadeLeituraDao.findAll();
    }

    /**
     * Atualiza uma lista de leitura existente.
     * 
     * @param leitura A lista de leitura a ser atualizada.
     */
    @Override
    public void Editar(ListadeLeitura leitura) {
        listadeLeituraDao.update(leitura);
    }

    /**
     * Busca uma lista de leitura específica por ID.
     * 
     * @param id O ID da lista de leitura.
     * @return A lista de leitura encontrada.
     */
    @Override
    @Transactional(readOnly = true)
    public ListadeLeitura ListarListadeLivrosPorId(Long id) {
        return listadeLeituraDao.findById(id);
    }

    /**
     * Busca listas de leitura pelo título.
     * 
     * @param titulo O título do livro.
     * @return A lista de listas de leitura que correspondem ao título.
     */
    @Override
    public List<ListadeLeitura> BuscarPortitulo(String titulo) {
        return listadeLeituraDao.findByTitulo(titulo);
    }

}
