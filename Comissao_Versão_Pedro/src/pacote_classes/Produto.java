package pacote_classes;

import java.util.ArrayList;

import professor_classes.Leitor;

public class Produto {
	//Atributos
	private int idProduto;
	private String nomeProduto;
	private float valorProduto;
	private int idCategoria;
	
	//Construtor da Classe
public Produto(String caminho, int chave, String valorChave) throws Exception {
	Leitor leitor = new Leitor(caminho, chave, valorChave);
	ArrayList<String> produtos = leitor.conteudo();
	String produto = produtos.get(0);
	String[] campos = produto.split(";");
    this.idProduto = Integer.parseInt(campos[0]);
    this.nomeProduto = (campos[1]);
    this.valorProduto = Float.parseFloat(campos[2]);
    this.idCategoria = Integer.parseInt(campos[3]);
	}

	
	//Toda classe herda implicitamente da classe Object, o método toString() está sendo implementado de outra forma, caracterizando o Polimorfismo 
	@Override
public String toString() {
	return "Produto [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", valorProduto=" + valorProduto
			+ ", categoriaProduto=" + idCategoria + "]";
}
	
	//Getters e Setters para acesso dos atributos private
	public int getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public float getValorProduto() {
		return valorProduto;
	}


	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}


	public int getidCategoria() {
		return idCategoria;
	}


	public void setidCategoria(int categoriaProduto) {
		this.idCategoria = categoriaProduto;
	}


	//Teste
	public static void main(String[] args) throws Exception {
		Produto produto = new Produto("./src/Produto.txt", 0, "1");
		System.out.println(produto);
	}
}




