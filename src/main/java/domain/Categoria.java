package domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Categoria {

	
	FICÇAO("FICÇAO"),
	NAO_FICÇAO("NAO_FICÇAO"),
	FANTASIA("FANTASIA"),
	MISTERIO("MISTERIO"),
	ROMANCE("ROMANCE"),
	TERROR("TERROR"),
	BIOGRAFIA("BIOGRAFIA"),
	AUTOAJUDA("AUTOAJUDA"),
	CIENCIA("CIENCIA"),
	HISTORIA("HISTORIA"),
	INFANTIL("INFANTIL"),
	AVENTURA("AVENTURA"),
	POESIA("POESIA"),
	HUMOR("HUMOR"),
	DRAMA("DRAMA");
;

@Enumerated(EnumType.STRING)
private String categoria;


private Categoria(String categoria) {
	this.categoria = categoria;
}


public String getCategoria() {
	return categoria;
}



}
