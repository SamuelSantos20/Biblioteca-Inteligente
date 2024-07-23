package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import domain.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Implementação da interface UsuarioDao para operações de persistência da entidade Usuario.
 */
@Repository
public class UsuarioImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Busca um usuário pelo seu e-mail e senha.
     * 
     * @param usuario O usuário contendo o e-mail e senha.
     * @return Um Optional contendo o usuário encontrado, ou vazio se não for encontrado.
     */
    @Override
    public Optional<Usuario> findByEmailAndSenha(Usuario usuario) {
        String jpql = "select u from Usuario u where u.email = :email and u.senha = :senha";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("email", usuario.getEmail());
        query.setParameter("senha", usuario.getSenha());
        List<Usuario> result = query.getResultList();
        
        if (result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(result.get(0));
        }
    }

   
}
