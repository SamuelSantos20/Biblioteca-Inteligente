package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Usuario;
import jakarta.servlet.http.HttpSession;
import service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Exibe a página de login.
     * @return ModelAndView para a página de login.
     */
    @GetMapping("/request_login")
    public ModelAndView requestLogin() {
        ModelAndView mv = new ModelAndView("Login/login.html");
        mv.addObject("Usuarios", new Usuario());
        return mv;
    }

    /**
     * Exibe a página de registro de novo usuário.
     * @return ModelAndView para a página de registro.
     */
    @GetMapping("/register")
    public ModelAndView requestRegistro() {
        ModelAndView mv = new ModelAndView("Cadastro/cadastro.html");
        mv.addObject("Usuario", new Usuario());
        return mv;
    }

    /**
     * Registra um novo usuário no sistema.
     * @param usuario O objeto Usuario contendo os dados do novo usuário.
     * @return ModelAndView para a página de registro com uma mensagem de sucesso ou erro.
     */
    @PostMapping("/registrar")
    public ModelAndView registrar(Usuario usuario) {
        ModelAndView mv = new ModelAndView("Cadastro/cadastro.html");
        try {
            usuarioService.salvar(usuario);
            mv.addObject("message", "Usuário registrado com sucesso");
        } catch (Exception e) {
            mv.addObject("errorMessage", "Erro ao registrar usuário: " + e.getMessage());
        }
        mv.addObject("Usuario", new Usuario());
        return mv;
    }

    /**
     * Realiza o login do usuário.
     * @param usuario O objeto Usuario contendo as credenciais do usuário.
     * @param session A sessão HTTP para armazenar o usuário logado.
     * @return ModelAndView redirecionando para o painel se o login for bem-sucedido ou para a página de login com uma mensagem de erro.
     */
    @PostMapping("/logar")
    public ModelAndView login(Usuario usuario, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Optional<Usuario> usuarioOptional = usuarioService.Login(usuario);

        if (usuarioOptional.isPresent()) {
            session.setAttribute("usuariologado", usuarioOptional.get());
            mv.setViewName("redirect:/painel");
        } else {
            mv.addObject("errorMessage", "Credenciais inválidas");
            mv.addObject("Usuarios", new Usuario());
            mv.setViewName("Login/login.html");
        }
        return mv;
    }

    /**
     * Realiza o logout do usuário.
     * @param session A sessão HTTP a ser encerrada.
     * @return ModelAndView para a página de logout.
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("Login/logout.html");
    }
}
