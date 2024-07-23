package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.ListadeLeitura;
import domain.Livro;
import domain.StatusLivro;
import domain.Usuario;
import jakarta.servlet.http.HttpSession;
import service.ListadeLeituraService;
import service.LivroService;

@Controller
public class ListadeLeituraController {

	@Autowired
	private ListadeLeituraService leituraService;

	@Autowired
	private LivroService livroService;

	/**
	 * Adiciona um livro a uma lista de leitura.
	 * 
	 * @param id       O ID do livro a ser adicionado.
	 * @param session  A sessão HTTP para obter o usuário logado.
	 * @return ModelAndView O modelo e vista para a página do catálogo.
	 */
	@PostMapping("/add-listLeitura")
	public ModelAndView SaveLista(@RequestParam("id") Long id, HttpSession session) {
		System.out.println(id);
		ModelAndView mv = new ModelAndView("Catalogo/catalogo.html");
		ListadeLeitura l = new ListadeLeitura();
		Livro livro = new Livro();
		Usuario usuario = new Usuario();

		try {
			Optional<Livro> livros = Optional.ofNullable(livroService.buscarPorId(id));

			if (leituraService.BuscarPortitulo(livros.get().getTitulo()) == null) {
				Usuario usOptional = (Usuario) session.getAttribute("usuariologado");

				livro.setId(id);
				usuario.setId(usOptional.getId());
				l.setLivro(livro);
				l.setUsuario(usuario);
				mv.addObject("catalogo", livroService.ListarTodosLivros());
				mv.addObject("errorMessage", "Livro adicionado a lista de Leitura!");
				leituraService.salvarnaListadeLeitura(l);

				return mv;
			} else {
				mv.addObject("catalogo", livroService.ListarTodosLivros());
				mv.addObject("errorMessage", "Livro Já se encontra adicionado a lista de Leitura!");

				return mv;
			}
		} catch (Exception e) {
			mv.addObject("errorMessage", "Erro ao adicionar livro a lista de Leitura. " + e);

			return mv;
		}
	}

	/**
	 * Exibe a lista de leitura do usuário logado.
	 * 
	 * @param session A sessão HTTP para obter o usuário logado.
	 * @return ModelAndView O modelo e vista para a página da lista de leitura.
	 */
	@GetMapping("/listeLeitura")
	public ModelAndView RequesteListadeLeitura(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Usuario usuario = (Usuario) session.getAttribute("usuariologado");
		List<ListadeLeitura> listadeLeitura = leituraService.ListarPorId(usuario.getId());
		mv.addObject("Lista", listadeLeitura);
		mv.addObject("livros", new Livro());
		mv.addObject("ListadeLeitura", new ListadeLeitura());
		mv.setViewName("ListadeLeitura/listas.html");

		return mv;
	}

	/**
	 * Atualiza o status de um livro na lista de leitura.
	 * 
	 * @param livros  O livro cujo status será atualizado.
	 * @param leitura A lista de leitura.
	 * @param session A sessão HTTP para obter o usuário logado.
	 * @return ModelAndView O modelo e vista para a página da lista de leitura.
	 */
	@PostMapping("/atualizarstatus")
	public ModelAndView UpdateStatus(Livro livros, ListadeLeitura leitura, HttpSession session) {
		ModelAndView mv = new ModelAndView("ListadeLeitura/listas.html");

		System.out.println(livros.getId());
		System.out.println(livroService.buscarPorId(livros.getId()));

		Optional<Livro> optional = Optional.ofNullable(livroService.buscarPorId(livros.getId()));

		try {
			if (optional.get().getStatus() == StatusLivro.NAO_LIDO) {
				livros.setStatus(StatusLivro.LIDO);
				livroService.Update(livros);

				Usuario usuario = (Usuario) session.getAttribute("usuariologado");
				List<ListadeLeitura> listadeLeitura = leituraService.ListarPorId(usuario.getId());

				mv.addObject("Lista", listadeLeitura);
				mv.addObject("ListadeLeitura", new ListadeLeitura());
				mv.addObject("successMessage", "Status atualizado com sucesso.");
				return mv;
			} else {
				Usuario usuario = (Usuario) session.getAttribute("usuariologado");
				List<ListadeLeitura> listadeLeitura = leituraService.ListarPorId(usuario.getId());

				mv.addObject("Lista", listadeLeitura);
				mv.addObject("ListadeLeitura", new ListadeLeitura());
				mv.addObject("errorMessage", "Status do Livro já se encontra como lido.");
				return mv;
			}
		} catch (Exception e) {
			Usuario usuario = (Usuario) session.getAttribute("usuariologado");
			List<ListadeLeitura> listadeLeitura = leituraService.ListarPorId(usuario.getId());
			mv.addObject("Lista", listadeLeitura);
			mv.addObject("ListadeLeitura", new ListadeLeitura());
			mv.addObject("errorMessage", "Erro ao atualizar status. " + e);
			return mv;
		}
	}

	/**
	 * Exclui um item da lista de leitura.
	 * 
	 * @param id O ID do item a ser excluído.
	 * @param redirectAttributes Atributos para redirecionamento.
	 * @return ModelAndView O modelo e vista para a página da lista de leitura.
	 */
	@PostMapping("/excluir_lista")
	public ModelAndView excluirLista(@RequestParam("id_lista") Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("ListadeLeitura/listas.html");
		System.out.println(id);

		try {
			leituraService.deletardaListadeLeitura(id);
			mv.addObject("Lista", leituraService.ListarTodos());
			mv.addObject("successMessage", "Item excluído com sucesso!");
			return mv;
		} catch (Exception e) {
			mv.addObject("Lista", leituraService.ListarTodos());
			mv.addObject("errorMessage", "Erro ao excluir item: " + e.getMessage());
			return mv;
		}
	}
}
