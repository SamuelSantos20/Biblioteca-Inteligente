package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UsuarioDao;
import domain.Usuario;

/**
 * Implementação dos serviços relacionados a usuários.
 */
@Service
@Transactional(readOnly = false)
public class UsuarioService implements UsuarioImpl {

    @Autowired
    private UsuarioDao usuarioDao;

    /**
     * Salva um novo usuário.
     * 
     * @param usuario O usuário a ser salvo.
     */
    @Override
    public void salvar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    /**
     * Exclui um usuário pelo seu ID.
     * 
     * @param id O ID do usuário a ser excluído.
     */
    @Override
    public void delete(Long id) {
        usuarioDao.delete(id);
    }

    /**
     * Lista um usuário pelo seu ID.
     * 
     * @param id O ID do usuário.
     * @return O usuário encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario ListarUsuarioId(Long id) {
        return usuarioDao.findById(id);
    }

    /**
     * Lista todos os usuários.
     * 
     * @return A lista de todos os usuários.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> ListarTodos() {
        return usuarioDao.findAll();
    }

    /**
     * Atualiza um usuário existente.
     * 
     * @param usuario O usuário a ser atualizado.
     */
    @Override
    public void Atualizar(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    /**
     * Realiza o login de um usuário com base em suas credenciais.
     * 
     * @param usuario O usuário com email e senha para autenticação.
     * @return Um Optional contendo o usuário autenticado, se as credenciais forem válidas.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> Login(Usuario usuario) {
        return usuarioDao.findByEmailAndSenha(usuario);
    }
}
