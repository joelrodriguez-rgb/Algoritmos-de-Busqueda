package grafos;
import grafos.Colores;
import java.util.Random;

public class ColoreoSecuencial {
	private  int cantVertices;
	private int [][] mA;
	private Vertice [] vertices;
	private Colores[] colores = new Colores [5];
	private Colores colorActual;



	public ColoreoSecuencial(int cantidadVertices) {
		mA = new int [cantidadVertices][cantidadVertices];
		vertices = new Vertice [cantidadVertices];
		
	}

	private void ingresarAD(String adyacencia) {
		int valorA = Integer.parseInt(String.valueOf(adyacencia.charAt(0)));
		int valorB = Integer.parseInt(String.valueOf(adyacencia.charAt(2)));

		mA [valorA][valorB] = 1;
	}
	
	private  void rellenarM() {
		
		for (int i = 0; i < mA.length; i++) {
			for (int j = 0; j < mA.length; j++) {
				if (mA[i][j] != 1) {
					mA[i][j] = 0;
				}
			}
			/*lleno el vector de vertices*/
			vertices[i] = new Vertice(i);
		}
		
		colores[0] = Colores.AMARILLO;
		colores[1] = Colores.AZUL;
		colores[2] = Colores.NEGRO;
		colores[3] = Colores.ROJO;
		colores[4] = Colores.VERDE;
	}
	
	
	private void colorear() {
		int indexColor = 0;
		
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertice(i,pintar(i,indexColor));
		}
	}
	
	

	private Colores pintar(int valorVertice, int indexColor) {
		
		/*seteo un primer color al vertice*/
	   colorActual = colores[indexColor];

		for (int j = 0; j < mA.length; j++) {
			if (mA[valorVertice][j] == 1) {
				if (colorActual == vertices[j].getColor()) {
					indexColor = indexColor+1;
				    pintar(valorVertice, indexColor);
				}
			}
		}
		return colorActual;
	}



	public static void main(String[] args) {
		/**Precondicion: los valores que corresponden a los vertices tienen un rango de 0-10 */

		ColoreoSecuencial coloreo = new ColoreoSecuencial(10);

		coloreo.ingresarAD("0 1");
		coloreo.ingresarAD("0 5");
		coloreo.ingresarAD("1 0");
		coloreo.ingresarAD("1 4");
		coloreo.ingresarAD("2 5");
		coloreo.ingresarAD("2 6");
		coloreo.ingresarAD("3 4");
		coloreo.ingresarAD("3 7");
		coloreo.ingresarAD("4 1");
		coloreo.ingresarAD("4 3");
		coloreo.ingresarAD("4 8");
		coloreo.ingresarAD("5 0");
		coloreo.ingresarAD("5 2");
		coloreo.ingresarAD("5 6");
		coloreo.ingresarAD("5 8");
		coloreo.ingresarAD("5 9");
		coloreo.ingresarAD("6 2");
		coloreo.ingresarAD("6 9");
		coloreo.ingresarAD("7 3");
		coloreo.ingresarAD("8 4");
		coloreo.ingresarAD("8 4");
		coloreo.ingresarAD("8 9");
		coloreo.ingresarAD("9 5");
		coloreo.ingresarAD("9 6");
		coloreo.ingresarAD("9 8");
		
		coloreo.rellenarM();
		
		for (int i = 0; i < coloreo.mA.length; i++) {
			for (int j = 0; j < coloreo.mA.length; j++) {
				System.out.print(" "+coloreo.mA[i][j]);
			}
			System.out.println();
		}
		
		coloreo.colorear();
		
		System.out.println();
		
		for (int i = 0; i < coloreo.vertices.length; i++) {
			System.out.println(coloreo.vertices[i].toString());
		}
		
		
	}
}
