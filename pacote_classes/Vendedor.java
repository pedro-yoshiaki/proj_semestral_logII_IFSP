package pacote_classes;

import java.util.ArrayList;

import professor_classes.Leitor;

public class Vendedor {
	private int idVendedor;
	private String nomeVendedor;
	public Vendedor(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> vendedores = leitor.conteudo();
		String vendedor = vendedores.get(0);
		String[] campos = vendedor.split(";");
        this.idVendedor = Integer.parseInt(campos[0]);
        this.nomeVendedor = campos[1];
	}
	
	@Override
	public String toString() {
		return "Vendedor [idVendedor=" + idVendedor + ", nome=" + nomeVendedor + "]";
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
}


