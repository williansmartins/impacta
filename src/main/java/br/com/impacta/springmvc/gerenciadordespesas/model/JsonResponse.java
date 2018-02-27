package br.com.impacta.springmvc.gerenciadordespesas.model;

public class JsonResponse {
	private Status status;
	private String mensagem;
	private Object objeto;

	public JsonResponse() {

	}
	
	public JsonResponse(Status status, String mensagem) {
		super();
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	
}


