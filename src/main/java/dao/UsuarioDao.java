package dao;

import java.util.List;
import java.util.Optional;

import domain.Usuario;

/**
 * Interface UsuarioDao para operações de persistência da entidade Usuario.
 */
public interface UsuarioDao {

    /**
     * Salva um novo usuário no banco de dados.
     * @param usuario O usuário a ser salvo.
     */
    void save(Usuario usuario);

    /**
     * Exclui um usuário pelo seu ID.
     * @param id O ID do usuário a ser excluído.
     */
    void delete(Long id);

    /**
     * Busca um usuário pelo seu ID.
     * @param id O ID do usuário.
     * @return O usuário encontrado, ou null se não for encontrado.
     */
    Usuario findById(Long id);

    /**
     * Retorna todos os usuários.
     * @return Uma lista de todos os usuários.
     */
    List<Usuario> findAll();

    /**
     * Atualiza um usuário existente.
     * @param usuario O usuário a ser atualizado.
     */
    void update(Usuario usuario);

    /**
     * Busca um usuário pelo seu e-mail e senha.
     * @param usuario O usuário contendo o e-mail e senha.
     * @return Um Optional contendo o usuário encontrado, ou vazio se não for encontrado.
     */
    Optional<Usuario> findByEmailAndSenha(Usuario usuario);
}
