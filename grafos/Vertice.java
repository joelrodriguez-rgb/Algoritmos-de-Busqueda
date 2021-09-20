package grafos;


public class Vertice {
	private int valor;
	private char caracter;
	private Colores color;
	
	
	public Vertice (int valor) {
		this.valor = valor;
	}
	
	public Vertice (char car) {
		
		this.caracter = car;
	}
	
	public Vertice (int valor, Colores color) {
		this.valor = valor;
		this.color = color;
	}
	
	public Colores getColor() {
		return color;
	}

	public void setColor(Colores color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vertice =" +valor+ " color=" + color + "";
	}

	public static void main(String[] args) {

	}

}
