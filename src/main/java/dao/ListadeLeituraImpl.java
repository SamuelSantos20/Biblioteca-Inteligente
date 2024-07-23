package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.ListadeLeitura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Implementação da interface ListadeLeituraDao para operações de persistência da entidade ListadeLeitura.
 */
@Repository
@Transactional(readOnly = false)
public class ListadeLeituraImpl extends AbstractDao<ListadeLeitura, Long> implements ListadeLeituraDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Busca listas de leitura pelo ID do usuário.
     * 
     * @param id O ID do usuário.
     * @return Uma lista de listas de leitura associadas ao usuário.
     */
    @Override
    public List<ListadeLeitura> findByLivro(Long id) {
        String jpql = "select l from ListadeLeitura l where l.usuario.id = :usuarioId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("usuarioId", id);
        return query.getResultList();
    }

    /**
     * Busca listas de leitura pelo título do livro.
     * 
     * @param titulo O título do livro.
     * @return Uma lista de listas de leitura que correspondem ao título do livro.
     */
    @Override
    public List<ListadeLeitura> findByTitulo(String titulo) {
        String jpql = "select l from ListadeLeitura l where l.livro.titulo like concat('%', :titulo, '%')";
        return entityManager.createQuery(jpql, ListadeLeitura.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    /**
     * Exclui uma lista de leitura pelo seu ID.
     * 
     * @param id O ID da lista de leitura a ser excluída.
     */
    @Override
    public void deletar(Long id) {
        String jpql = "delete from ListadeLeitura l where l.id = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
