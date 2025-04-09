package pacote_classes;

import java.util.ArrayList;

import professor_classes.Leitor;

public class Cliente { // Criação da classe 'Cliente'
	//Definir atributos (características) que um objeto da classe 'Cliente' precisa ter
	private int idCliente;
	private String cpf;
	private String nome;
	// Construtor (Método especial do Java), serve para inicializar os atributos com os valores do parâmetro
 	public Cliente(String caminho, int chave, String valorChave) throws Exception {
 	// Ler os dados do Banco_Cliente e armazenar em uma variável, após isso separar os dados e adicionar nos atributos corretos
 		
 		// Criação de um objeto 'leitor' do tipo 'Leitor', para acessar os metodos da classe Leitor
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		
		//Uso do método conteudo () que retorna as linhas do tipo ArrayList <String> que é armazenado na variável cliente
		ArrayList<String> clientes = leitor.conteudo();
		
		// Cria uma variável do tipo String 'cliente' que armazena o conteúdo de clientes (primeiro elemento '0')
		String cliente = clientes.get(0);
		
		// Divide a cliente em um vetor 'campos' campos = [idCliente, cpf, nome]
		String[] campos = cliente.split(";");
        this.idCliente = Integer.parseInt(campos[0]); //Converte o idCliente de String para inteiro e salva em idCliente
        this.cpf = campos[1];
        this.nome = campos[2];
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cpf=" + cpf + ", nome=" + nome + "]";
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
	
	//Teste
	public static void main(String[] args) throws Exception {
	    Cliente clientes = new Cliente("./src/Banco_Cliente.txt", 0, "100");
	    System.out.println(clientes.toString());
	}
}
