package pacote_classes;

import java.util.ArrayList;

import professor_classes.Data15;
import professor_classes.Leitor;

public class Pedido {
	private int idPedido;
	private Data15 dataPedido;
	private int idVendedor;
	
	public Pedido(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> pedidos = leitor.conteudo();
		String pedido = pedidos.get(0);
		String[] campos = pedido.split(";");
	    this.idPedido = Integer.parseInt(campos[0]);
	    String dataPedido = (campos[1]);
	    String campos2[] = dataPedido.split("/");
	    //System.out.println(campos2[0] + "/" + campos2[1] + "/" + campos2[2]);
	    this.dataPedido = new Data15 (Integer.parseInt(campos2[0]), Integer.parseInt(campos2[1]), Integer.parseInt(campos2[2]));
	    this.idVendedor = Integer.parseInt(campos[2]); 
	}
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", vendedorPedido=" + idVendedor
				+ "]";
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Data15 getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Data15 dataPedido) {
		this.dataPedido = dataPedido;
	}

	public int getidVendedor() {
		return idVendedor;
	}

	public void setidVendedor(int vendedorPedido) {
		this.idVendedor = vendedorPedido;
	}

	public static void main(String[] args) throws Exception {
		Pedido pedido = new Pedido("./src/Pedido.txt", 0, "1");
		System.out.println(pedido);
	}
}