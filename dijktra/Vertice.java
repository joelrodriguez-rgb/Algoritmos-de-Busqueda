package dijktra;

public class Vertice {
	private int nodo;
	private int destino;
	private int arista;
	
	public Vertice(int nodo, int destino, int arista) {
		this.setNodo(nodo);
		this.setDestino(destino);
		this.setArista(arista);
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int valorNodo) {
		this.nodo = valorNodo;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getArista() {
		return arista;
	}

	public void setArista(int arista) {
		this.arista = arista;
	}

	@Override
	public String toString() {
		return "|" + nodo + "  |" + destino + "  |" + arista + "  |";
	}
}
