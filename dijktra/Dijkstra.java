package dijktra;

import java.util.ArrayList;

public class Dijkstra {
	private int matriz[][];
	private int numvertices;
	private static final int infinito = 100000;
	// distancia[i] guarda la distancia mas corta desde inicio hasta el vertice i
	private int[] distancia;
	// lista de los caminos visitados
	private String [] caminos;
	//Este arreglo tiene true si el vertice i ya fue procesado
	private boolean[] visto;

	public Dijkstra(int numvertices) {
		this.numvertices = numvertices;
		this.matriz = new int[numvertices][numvertices];
		distancia = new int[numvertices];
		caminos = new String [numvertices];
		visto = new boolean[numvertices];
	}


	// Insertar arista: vertice 1, vertice 2 y distancia entre cada vertice
	public void insertaArista(int v1, int v2, int dist) {
		matriz[v1][v2] = dist;
		matriz[v2][v1] = dist;
	}

	//Calcula la distancia mas corta.
	//inicio nodo desde donde se va a iniciar.
	public void dijkistra(int inicio) {

		// inicializo los valores
		for (int i = 0; i < numvertices; i++) {
			distancia[i] = infinito;
			visto[i] = false;
		}

		// La distancia del vertice origen hacia el mismo es siempre 0
		distancia[inicio]=0;
		caminos[inicio]=""+(inicio+1);

		//Encuentra el camino mas corto para todos los vertices
		for (int i = 0; i < numvertices; i++) {

			int minIndex = minDistance(distancia, visto);
			// Se marca como ya procesado
			visto[minIndex] = true;

			for (int j = 0; j < numvertices; j++) {

				if (!visto[j] && matriz[minIndex][j] > 0 && distancia[minIndex] != infinito){
					if(distancia[minIndex]+matriz[minIndex][j] < distancia[j]){

						distancia[j] = distancia[minIndex] + matriz[minIndex][j];
						//se construye un string de caminos
						if (minIndex == 0) 
							 caminos[j] = 0+"-"+(j);
						else
				        caminos[j] = caminos[minIndex]+"-"+(j);
						

					}
				}
			}
		}

	}

	// Funcion utilitaria para encontrar el vertice con la distancia minima,
	// a partir del conjunto de los vertices todavia no incluidos en el
	// camino mas corto
	private int minDistance(int[] dist, boolean[] verticeYaProcesado){
		int min = infinito;
		int min_index=0;

		for (int i = 0; i < numvertices; i++)
			if (verticeYaProcesado[i] == false && dist[i] <= min) {
				min = dist[i];
				min_index = i;
			}
		return min_index;
	}

	public void mostrar_vertice(int i){
		System.out.println("\nUltimo vertice: "+i);
		System.out.println(i+"\t"+distancia[i]+"\t"+caminos[i]);
	}

	// Funcion para imprimir el arreglo de distancias calculadas
	public void mostrar(){
		System.out.println("Distancia del vertice desde el origen\n");
		for (int i = 0; i < numvertices; i++)
			System.out.println("Al vertice: "+(i) + "\tCosto: " + distancia[i]+ "\tCaminos: " + caminos[i]);
	}






	public static void main(String[] args) {

		
		Dijkstra d1 = new Dijkstra (7);
		
	      int inicio = 0;
	      int fin = 6;
		
		
		d1.insertaArista(0,1,5);
		d1.insertaArista(0,2,2); 
		d1.insertaArista(1,2,4);
		d1.insertaArista(1,4,8);
		d1.insertaArista(2,1,2);
		d1.insertaArista(2,4,9);
		d1.insertaArista(2,3,3);
		d1.insertaArista(2,5,22);
		d1.insertaArista(2,6,8);
		d1.insertaArista(3,5,11);
		d1.insertaArista(4,6,19);
		d1.insertaArista(5,6,21);

	      d1.dijkistra(inicio);
	      
	      d1.mostrar();
	     
	      d1.mostrar_vertice(fin);


	}

}
