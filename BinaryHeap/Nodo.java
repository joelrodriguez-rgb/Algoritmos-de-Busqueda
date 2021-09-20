package BinaryHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Nodo {
	private int value;
	
	

	
	public Nodo(int value) {
		this.setValue(value);
	}
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}


	
	
	
	
	@Override
	public String toString() {
		return "Nodo [value=" + value + "]";
	}


	public static void main(String[] args) {}


	
}
