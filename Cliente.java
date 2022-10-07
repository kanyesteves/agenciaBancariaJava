public class Cliente {
	
	private static int count = 1;
	
	private int numClientes;
	private String nome;
	private String endereco;
	private String cpf;
	private String profissao;
	private String renda;
	
	public Cliente(String nome, String endereco, String cpf, String profissao, String renda) {
		this.numClientes = Cliente.count;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.profissao = profissao;
		this.renda = renda;
		Cliente.count++;
	}

	public int getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getRenda() {
		return renda;
	}

	public void setRenda(String renda) {
		this.renda = renda;
	}

}
