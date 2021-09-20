package kruskal;


import java.util.*;

public class ArbolMinimo {
	private static LinkedList<Vertice> nodos = new LinkedList<>();
	private static LinkedList<Vertice> arbolMinimo = new LinkedList<>();
	private static int contVertices = 0;
	private static int contAristas = 0;


	private static void armarArbol(){
		int i = 1;

		for (Vertice vertice : nodos) {
			if (i <= 2) {
				i++;
				contVertices = contVertices +2;
				contAristas = contAristas +1;
				arbolMinimo.add(vertice);
			}else if (buscarVertices(vertice)) {
				arbolMinimo.add(vertice);
			}
		}
	}

	private static boolean buscarVertices(Vertice v) {
		boolean verticeOrigen = buscarOrigen(v.getValorNodo());
		boolean verticeDestino = buscarDestino(v.getDestino());
		int auxContArista = contAristas;
		int auxContVertices = contVertices;

		if (verticeDestino == true && verticeOrigen == true) {
			auxContArista = auxContArista +1;
		}else if (verticeDestino == true || verticeOrigen == true) {
			auxContVertices = auxContVertices +1;
			auxContArista = auxContArista +1;
		}else {
			auxContVertices = auxContVertices +2;
			auxContArista = auxContArista +1;
		}

		if (auxContArista == auxContVertices) {
			return false;
		}else {
			contAristas = auxContArista;
			contVertices = auxContVertices;
			return true;
		}
	}

	private static boolean buscarOrigen(int verticeOrigen) { 

		for (Vertice vertice : arbolMinimo) {
			if (vertice.getValorNodo() == verticeOrigen || 
					vertice.getDestino() == verticeOrigen) {
				return true;
			}
		}
		return false;
	}

	private static boolean buscarDestino(int verticeDestino) { 

		for (Vertice vertice : arbolMinimo) {
			if (vertice.getDestino() == verticeDestino || 
					vertice.getValorNodo() == verticeDestino) {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {

		ArbolMinimo am = new ArbolMinimo();


		nodos.add(new Vertice('A','F',21));
		nodos.add(new Vertice('B','A',11));
		nodos.add(new Vertice('D','E',10));
		nodos.add(new Vertice('D','H',15));
		nodos.add(new Vertice('E','B',3));
		nodos.add(new Vertice('E','I',9));
		nodos.add(new Vertice('H','I',8));
		nodos.add(new Vertice('I','F',19));
		nodos.add(new Vertice('I','J',9));
		nodos.add(new Vertice('F','J',30));
		nodos.add(new Vertice('F','G',28));
		nodos.add(new Vertice('F','C',25));
		nodos.add(new Vertice('C','G',32));
		nodos.add(new Vertice('J','G',7));





		Collections.sort(nodos);

		System.out.println(" O   D   P");

		for(Object elemento: nodos) {
			System.out.println(elemento+"");
		}


		armarArbol();

		System.out.println("Arbol minimo");

		for(Object elemento: arbolMinimo) {
			System.out.println(elemento+"");
		}

	}
}
