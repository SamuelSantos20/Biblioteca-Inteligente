package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "ususario")
public class Usuario extends AbstractEntity<Long> {


	@Column(name = "email", length = 200, nullable = false, unique = true)
	private String email;

	@Column(name = "senha", length = 200, nullable = false, unique = true)
	private String senha;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
