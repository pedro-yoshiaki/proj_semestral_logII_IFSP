package pacote_classes;

import java.util.ArrayList;

import professor_classes.Leitor;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	private float comissaoCategoria;
	
	public Categoria(String caminho, int chave, String valorChave) throws Exception {
		Leitor leitor = new Leitor(caminho, chave, valorChave);
		ArrayList<String> categorias = leitor.conteudo();
		String categoria = categorias.get(0);
		String[] campos = categoria.split(";");
        this.idCategoria = Integer.parseInt(campos[0]);
        this.nomeCategoria = campos[1];
        this.comissaoCategoria = Float.parseFloat(campos[2]);
	}

	public int getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getNomeCategoria() {
		return nomeCategoria;
	}



	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}



	public float getComissaoCategoria() {
		return comissaoCategoria;
	}



	public void setComissaoCategoria(float comissaoCategoria) {
		this.comissaoCategoria = comissaoCategoria;
	}



	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria + ", comissaoCategoria="
				+ comissaoCategoria + "]";
	}
	
}
