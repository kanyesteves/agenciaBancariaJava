import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Sair          |");

        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                System.out.println("Flw é nóis!");
                System.exit(0);

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }
	
    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = sc.nextLine();

        System.out.println("\nEndereco: ");
        String endereco = sc.nextLine();
        
        System.out.println("\nCPF: ");
        String cpf = sc.nextLine();
        
        System.out.println("\nProfissao: ");
        String profissao = sc.nextLine();

        System.out.println("Renda: ");
        String renda = sc.nextLine();

        Cliente cliente = new Cliente(nome, endereco, cpf, profissao, renda);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");

        operacoes();

    }
    
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumero() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }
    
    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = sc.nextDouble();

            conta.depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes(); // Retorna ao menu inicial
    }
    
    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = sc.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes(); // Retorna ao menu inicial
    }
    
    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = sc.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = sc.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = sc.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }
        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operacoes(); // Retorna ao menu inicial
    }
}
