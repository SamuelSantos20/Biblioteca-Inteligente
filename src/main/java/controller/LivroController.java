package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.Categoria;
import domain.ListadeLeitura;
import domain.Livro;
import domain.StatusLivro;
import service.ListadeLeituraService;
import service.LivroService;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private ListadeLeituraService leituraService;

    /**
     * Exibe o painel de administração.
     * @return ModelAndView para a página do painel.
     */
    @GetMapping("/painel")
    public ModelAndView showDashboard() {
        ModelAndView mv = new ModelAndView("Painel/dashboard.html");
        mv.addObject("categorias", categorias());
        mv.addObject("Livro", new Livro());
        return mv;
    }

    /**
     * Salva um novo livro no sistema.
     * @param livro O livro a ser salvo.
     * @return ModelAndView para a página do painel com uma mensagem de sucesso ou erro.
     */
    @PostMapping("/adicionar-livro")
    public ModelAndView saveBook(Livro livro) {
        ModelAndView mv = new ModelAndView("Painel/dashboard.html");
        livro.setStatus(StatusLivro.NAO_LIDO);
        try {
            livroService.salvar(livro);
            mv.addObject("successMessage", "Livro adicionado com sucesso!");
        } catch (Exception e) {
            mv.addObject("errorMessage", "Erro ao adicionar Livro: " + e.getMessage());
        }
        mv.addObject("categorias", categorias());
        mv.addObject("Livro", new Livro());
        return mv;
    }

    /**
     * Exibe o catálogo de livros.
     * @return ModelAndView para a página do catálogo.
     */
    @GetMapping("/catalogo")
    public ModelAndView showCatalog() {
        ModelAndView mv = new ModelAndView("Catalogo/catalogo.html");
        mv.addObject("catalogo", livroService.ListarTodosLivros());
        return mv;
    }

    /**
     * Exibe o formulário de edição para um livro específico.
     * @param id O ID do livro a ser editado.
     * @return ModelAndView para a página de edição do painel.
     */
    @GetMapping("/editar/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("Painel/dashboard.html");
        mv.addObject("Livro", livroService.buscarPorId(id));
        mv.addObject("categorias", categorias());
        return mv;
    }

    /**
     * Atualiza as informações de um livro.
     * @param id O ID do livro a ser atualizado.
     * @param livro O livro com as informações atualizadas.
     * @return ModelAndView para a página do catálogo com uma mensagem de sucesso ou erro.
     */
    @PostMapping("/editar")
    public ModelAndView updateBook(@RequestParam("id") Long id, Livro livro) {
        ModelAndView mv = new ModelAndView();
        Optional<Livro> existingBook = Optional.ofNullable(livroService.buscarPorId(id));

        if (existingBook.isPresent()) {
            livroService.Update(livro);
            mv.addObject("catalogo", livroService.ListarTodosLivros());
            mv.setViewName("Catalogo/catalogo.html");
        } else {
            mv.addObject("errorMessage", "Erro ao Editar Livro: Livro não encontrado.");
            mv.addObject("categorias", categorias());
            mv.addObject("Livro", new Livro());
            mv.setViewName("Painel/dashboard.html");
        }
        return mv;
    }

    /**
     * Busca livros no catálogo com base em um termo de pesquisa.
     * @param pesquisa O termo de pesquisa.
     * @return ModelAndView para a página do catálogo com os resultados da pesquisa.
     */
    @PostMapping("/Pesquisa_livro")
    public ModelAndView searchBooks(@RequestParam("search") String pesquisa) {
        ModelAndView mv = new ModelAndView("Catalogo/catalogo.html");
        try {
            List<Livro> livros = livroService.buscarTodosLivros(pesquisa);
            mv.addObject("catalogo", livros);
        } catch (Exception e) {
            mv.addObject("errorMessage", "Erro ao Buscar: " + e.getMessage());
        }
        return mv;
    }

    /**
     * Exclui um livro do catálogo.
     * @param id O ID do livro a ser excluído.
     * @param redirectAttributes Atributos para redirecionamento.
     * @return ModelAndView para a página do catálogo com uma mensagem de sucesso ou erro.
     */
    @GetMapping("/excluir/{id}")
    public ModelAndView deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("Catalogo/catalogo.html");
        Optional<ListadeLeitura> optional = Optional.ofNullable(leituraService.ListarListadeLivrosPorId(id));

        if (optional.isEmpty()) {
            livroService.excluir(id);
            mv.addObject("successMessage", "Exclusão efetuada com sucesso!");
        } else {
            mv.addObject("errorMessage", "Erro ao excluir livro do catálogo! Exclua o livro de sua Lista de Leitura primeiro.");
        }
        mv.addObject("catalogo", livroService.ListarTodosLivros());
        return mv;
    }

    /**
     * Retorna as categorias disponíveis.
     * @return Um array de categorias.
     */
    private Categoria[] categorias() {
        return Categoria.values();
    }
}
