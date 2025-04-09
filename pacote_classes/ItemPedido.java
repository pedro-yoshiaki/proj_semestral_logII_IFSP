package pacote_classes;

import java.util.ArrayList;

import professor_classes.Leitor;

public class ItemPedido {
	private int idItemPedido;
	private int idProduto;
	private int idPedido;
	private int qtdItens;
	public ItemPedido(String caminho, int chave, String valorChave) throws Exception{
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> itens = leitor.conteudo();
		String item = itens.get(0);
		String[] campos = item.split(";");
	    this.idItemPedido = Integer.parseInt(campos[0]);
	    this.idProduto = Integer.parseInt(campos[1]);
	    this.idPedido = Integer.parseInt(campos[2]);
	    this.qtdItens = Integer.parseInt(campos[3]);
	}
	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", produtoItem=" + idProduto + ", pedidoItem="
				+ idPedido + ", qtdItens=" + qtdItens + "]";
	}
	
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getQtdItens() {
		return qtdItens;
	}
	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}
	public static void main(String[] args) throws Exception {
		ItemPedido item = new ItemPedido("./src/ItemPedido.txt", 0, "1");
		System.out.println(item);
	}
}

