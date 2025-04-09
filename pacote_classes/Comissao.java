package pacote_classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import professor_classes.Data15;

public class Comissao{
	
	public static void main(String[] args) throws Exception{
		int idVendedorDesejado = 1; // Selecionar qual vendedor se deseja saber a comissao
		Data15 data1 = new Data15(23, 4, 2024); // Data inicial
	    Data15 data2 = new Data15(25, 4, 2024); // Data final
	    
	    //Cria se um objeto 'vendedor' da Classe Vendedor para acessar as informações do vendedor desejado e imprimir na tela
	    Vendedor vendedor = new Vendedor("./src/Vendedor.txt", 0, String.valueOf(idVendedorDesejado));
	    //Os parâmetros da classe Vendedor recebem um caminho, a posição da chave e o valor em string, portanto usa-se o método valueOf da Classe String
	    //para transformar o valor int em String. Esse método é público na Classe String que vem no JRE Java Runtime Environment
	    System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Comissão do vendedor " + vendedor.getNomeVendedor()); //método get para acessar o conteúdo no atributo NomeVendedor
	    System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("De: " + data1 + " até " + data2);
	    System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Qtd | Produto                  | Preço       | Valor Venda   | (Comissão/prod)*qtd");
	    System.out.println("-----------------------------------------------------------------------------------");
		float resposta = calculaComissao(idVendedorDesejado, data1, data2); //Chama método calculaComissao que retorna um float
	    System.out.println("-----------------------------------------------------------------------------------");
		System.out.printf("Total de comissão = R$ %-10.2f", resposta);
		
	}
	public static float calculaComissao(int idVendedorBuscado, Data15 dataInicio, Data15 dataFim) throws Exception {
		int i;
		float totalComissao = 0;
		float porcentagemComissao;
		float valorProduto;
		float comissaoProduto;
		float valorVenda;
		int qtdProduto;
		Data15 dataPedido;
		ItemPedido item;
		Pedido pedido;
		Produto produto;
		Categoria categoria;
		
		//Lógica do leitor para contar número de linhas e influenciar quantas iterações serão feitas
		String caminhoArquivo = "./src/ItemPedido.txt";
		File file = new File(caminhoArquivo);

		BufferedReader br = new BufferedReader(new FileReader(file));

		@SuppressWarnings("unused")
		String st;
		int contadorLinha = 0;
		while ((st = br.readLine()) != null) {
			contadorLinha = contadorLinha + 1;
			if (contadorLinha == 1) {
				continue;
			}
		}
		contadorLinha = contadorLinha -1; //Retira uma linha dos títulos
		br.close();
		//System.out.println("ContadorLinha = " + contadorLinha);
		//Criar um objeto para cada linha lida e capturar informações úteis para o cálculo da comissão
		for(i = 1; i<=contadorLinha; i++) {
			//System.out.println("i = " + i);
			item = new ItemPedido("./src/ItemPedido.txt", 0, String.valueOf(i)); //Cria um objeto da ItemPedido (obtém o idPedido, idProdutoQtdItens)
			pedido = new Pedido("./src/Pedido.txt", 0, String.valueOf(item.getIdPedido())); //Cria o objeto com o idPedido obtido (obtém a data e o idVendedor)
			dataPedido = pedido.getDataPedido(); //Armazena a data obtida em uma variável
			//System.out.println(dataPedido);
			
			//Compara se o idVendedor é igual ao do vendedor buscado,
			//Uso do metodo compareTo adicionado na Classe Data15, retorno = 0 as datas são iguais, retorno > 0 a data é maior e retorno < 0 (-1) a data é menor
			
			if(pedido.getidVendedor() == idVendedorBuscado && 
					(dataPedido.compareTo(dataInicio) > 0 || dataPedido.compareTo(dataInicio) == 0) &&
					(dataPedido.compareTo(dataFim) == -1 || dataPedido.compareTo(dataFim) == 0)){
				
				//Se a condição for atendida buscamos o Valor do produto e Comissao da categoria para realizar o cálculo
				produto = new Produto("./src/Produto.txt", 0, String.valueOf(item.getIdProduto()));//Cria um objeto com o idProduto (obtém idCategoria e ValorProduto)
				categoria = new Categoria("./src/Categoria.txt", 0, String.valueOf(produto.getidCategoria()));//Cria um objeto com o idCategoria (obtém Percentual Comissão)
				//Salva valores em variáveis
				porcentagemComissao = categoria.getComissaoCategoria();
				valorProduto = produto.getValorProduto();
				qtdProduto = item.getQtdItens();
				
				//*Cálculo do total de comissão a cada iteração
				totalComissao = totalComissao + ((valorProduto * porcentagemComissao) * qtdProduto);
				
				//Informações para imprimir na tela
				valorVenda = valorProduto * qtdProduto;
				comissaoProduto = valorProduto * porcentagemComissao * qtdProduto;
				
				System.out.printf("%-4d| %-24s |R$ %-9.2f | R$ %-10.2f | R$ %-9.2f%n", qtdProduto, produto.getNomeProduto(), 
                        produto.getValorProduto(), valorVenda, comissaoProduto);
			}
		}
		return totalComissao;
	}
}
