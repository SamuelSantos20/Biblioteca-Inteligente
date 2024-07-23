package service;

import java.util.List;
import java.util.Optional;

import domain.Usuario;

/**
 * Interface que define os contratos para os serviços relacionados aos usuários.
 */
public interface UsuarioImpl {

    /**
     * Salva um novo usuário.
     * 
     * @param usuario O usuário a ser salvo.
     */
    void salvar(Usuario usuario);

    /**
     * Exclui um usuário pelo seu ID.
     * 
     * @param id O ID do usuário a ser excluído.
     */
    void delete(Long id);

    /**
     * Lista um usuário pelo seu ID.
     * 
     * @param id O ID do usuário.
     * @return O usuário encontrado.
     */
    Usuario ListarUsuarioId(Long id);

    /**
     * Lista todos os usuários.
     * 
     * @return A lista de todos os usuários.
     */
    List<Usuario> ListarTodos();

    /**
     * Atualiza um usuário existente.
     * 
     * @param usuario O usuário a ser atualizado.
     */
    void Atualizar(Usuario usuario);
    
    /**
     * Realiza o login de um usuário com base em suas credenciais.
     * 
     * @param usuario O usuário com email e senha para autenticação.
     * @return Um Optional contendo o usuário autenticado, se as credenciais forem válidas.
     */
    Optional<Usuario> Login(Usuario usuario);
}
