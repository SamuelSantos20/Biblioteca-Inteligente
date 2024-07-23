package domain;

public enum StatusLivro {

	LIDO("LIDO") , 
	NAO_LIDO("NAO LIDO");

	private String Status;
	
	
	
	StatusLivro(String status) {
		this.Status = status;
	}



	public String getStatus() {
		return Status;
	}



	
}
