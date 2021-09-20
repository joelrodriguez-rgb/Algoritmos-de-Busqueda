package BinaryHeap;
import nombresOrdenados.Cliente;

public class BinaryHeap <T extends Comparable<? super T>>{
	private  T [] vector;
	private  T [] vecAux;
	private static int tam = 0;
	private static int lastIndex;


	public BinaryHeap(){}



	/*Este metodo crea un vector dinamico que va incrementando su tamaño
	 * a medida que se ingresan valores.
	 */
	private  void ingresarValor(T valor) {
		tam = tam+1;
		vecAux = vector;
		vector = (T[]) new Comparable[tam];
		lastIndex = vector.length-1;


		if (vector.length == 1) {
			vector[lastIndex] = valor;
		}else {

			for (int i = 0; i < vecAux.length; i++) {
				vector[i] = vecAux[i];
			}
			vector[lastIndex] = valor;
			evaluarValorPadre(valor,lastIndex);
		}	
	}


	private  void evaluarValorPadre(T valor, int lastIndex){
		int indexPadre = 0;

		if (lastIndex%2 == 0 && lastIndex != 0) // si el indice es par y diferente de 0 le resto 1 al indice del padre
			indexPadre = (lastIndex/2)-1;
		else 
			indexPadre = (lastIndex/2);	

		T padreValue = vector[indexPadre];

		/** "<" si es min, ">" si es max heap*/
		if (compareTo(valor, padreValue) > 0) { 
			vector[indexPadre] = valor;
			vector[lastIndex] = padreValue;
			evaluarValorPadre(valor,indexPadre);
		}
	}

	private  void obtenerRaiz() {
		tam--;
		lastIndex = vector.length-1;

		vector[0] = vector[lastIndex];                    // intercambio raiz por ultimo valor
		vecAux = vector;                                 // guardo el vector completo con el ultimo valor intercambiado en la primera posicion
		vector = (T[]) new Comparable[vecAux.length-1]; // creo el vector con el nuevo tamaño. -1 que el original

		for (int i = 0; i < vecAux.length-1; i++) { // recorro hasta la ultima posicion -1
			vector[i] = vecAux[i];
		}

		evaluarValorHijos(vector[0],0);	 

	}


	private  void evaluarValorHijos(T valorPadre,int indexPadre) {

		if (!isHoja(indexPadre)) {

			int indexHD = obtenerIdexHD(indexPadre);
			int indexHI = obtenerIndexHI(indexPadre);

			T valorHD = vector[indexHD];
			T valorHI = vector[indexHI];

              /**> > < si es minimo, < < > si es maximo. */
			if (compareTo(valorPadre,valorHD) < 0 || compareTo(valorPadre,valorHI) < 0 ) {

				if (compareTo(valorHI,valorHD) > 0) {
					vector[indexPadre] = valorHI;
					vector[indexHI] = valorPadre;
					evaluarValorHijos(valorPadre,indexHI);
				}else {
					vector[indexPadre] = valorHD;
					vector[indexHD] = valorPadre;
					evaluarValorHijos(valorPadre,indexHD);
				}
			}
		}
	}


	private static int obtenerIdexHD(int indexPadre) {
		return 2*indexPadre+2;
	}

	private static int obtenerIndexHI(int indexPadre) {
		return 2*indexPadre+1;

	}

	private  boolean isHoja(int index) {

		if ((index+1 > (vector.length/2)) && (index+1 <= vector.length )) {
			return true;
		}
		return false;

	}

/**@return
 * -1 si el valor ingresado es menor que el del padre, 0 si son iguales, 1 si es mayor. */
	private int compareTo(T valor, T padreValue) {
		return valor.compareTo(padreValue);

	}



	@SuppressWarnings("unchecked")
	public static void main (String[] args) {

		BinaryHeap bh = new BinaryHeap();


		bh.ingresarValor(new Cliente("Joel","Rodriguez",1));
		bh.ingresarValor(new Cliente("Laureano","Ribarola",2));
		bh.ingresarValor(new Cliente("Debora","Candia",3));
		bh.ingresarValor(new Cliente("Lucas","Chavez",4));
		bh.ingresarValor(new Cliente("Aylen","Guzman",5));
		bh.ingresarValor(new Cliente("Cyntia","Prados",6));
		bh.ingresarValor(new Cliente("Axel","Nose",7));
		bh.ingresarValor(new Cliente("Federico","Ortiz",8));
		
//		bh.ingresarValor(2);
//		bh.ingresarValor(7);
//		bh.ingresarValor(26);
//		bh.ingresarValor(25);
//		bh.ingresarValor(19);
//		bh.ingresarValor(17);
//		bh.ingresarValor(1);
//		bh.ingresarValor(90);
//		bh.ingresarValor(3);
//		bh.ingresarValor(36);


		System.out.println("Heap ordenado");
		for (int i = 0; i < bh.vector.length; i++) {
			System.out.println("-"+bh.vector[i].toString());
		}
		System.out.println();


//
//		System.out.println("Extraigo la raiz = 1");
//		System.out.println();
//		bh.obtenerRaiz();
//
//		for (int i = 0; i < bh.vector.length; i++) {
//			System.out.print("-"+bh.vector[i]);
//		}


	}
}
