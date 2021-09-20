package kruskal;

public class Vertice implements Comparable<Vertice>{
	private char valorNodo;
	private char destino;
	private Integer peso;
	
	public Vertice(char valor, char destino, int peso) {
		this.setValorNodo(valor);
		this.setDestino(destino);
		this.setPeso(peso);
	}

	public int getValorNodo() {
		return valorNodo;
	}

	public void setValorNodo(char valorNodo) {
		this.valorNodo = valorNodo;
	}

	public char getDestino() {
		return destino;
	}

	public void setDestino(char destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "|" + valorNodo + "  |" + destino + "  |" + peso + "  |";
	}

	@Override
	public int compareTo(Vertice o) {
		return  this.peso.compareTo(o.getPeso()) ;
	}

	



	
	

}
