package domain;



import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "listadeleitura")
public class ListadeLeitura extends AbstractEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario ;
	
	@ManyToOne
	@JoinColumn(name = "livro_id" , unique = true)
	private Livro livro;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	
	
}
