package Model;

public class Native {
	
	private String cpf;
	private String nome;
	private String comida;
	private String idade;
	
	public Native() {
		super();
	
	}
	
	
	
	public Native(String cpf, String nome, String comida, String idade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.comida = comida;
		this.idade = idade;
	}



	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}

}
