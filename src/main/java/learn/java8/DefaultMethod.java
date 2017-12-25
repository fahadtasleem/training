package learn.java8;

interface vehicle {
	default void print() {
		System.out.println("I am a vehicle!");
	}
}

interface fourWheeler {
	default void print() {
		System.out.println("I am a four wheeler!");
	}
}

public class DefaultMethod implements vehicle,fourWheeler{

	@Override
	public void print() {
		fourWheeler.super.print();
	}
	
	public static void main(String[] args) {
		DefaultMethod d = new DefaultMethod();
		d.print();
	}

}
