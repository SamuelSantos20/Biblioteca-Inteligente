
package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "livro")
public class Livro extends AbstractEntity<Long> {

	@Column(name = "titulo", length = 200, nullable = false)
	private String titulo;

	@Column(name = "autor", length = 100, nullable = false)
	private String autor;

	@Enumerated(EnumType.STRING)
	private StatusLivro status;

	@Enumerated(EnumType.STRING)
	private Categoria categorias;

	public String getTitulo() {
		return titulo;
	}

	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public StatusLivro getStatus() {
		return status;

	}

	public void setStatus(StatusLivro status) {
		this.status = status;
	}

	public Categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

}
