public class Conta {
	
	public static int numeroCounter = 1;
	
	private int numero;
	private Cliente cliente;
	
	private Double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		this.numero = Conta.numeroCounter;
		this.cliente = cliente;
		this.updateSaldo();
		Conta.numeroCounter++;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	private void updateSaldo() {
		this.saldo = this.getSaldo();
	}
	
	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Deposito realizado com sucesso !!");
		} else {
			System.out.println("Não foi possível realizar o deposito");
		}
	}
	
	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso !!");
		} else {
			System.out.println("Não foi possível realizar o saque");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferencia realizada com sucesso !!");
		} else {
			System.out.println("Não foi possível realizar a transferência");
		}
	}
	
	
}
