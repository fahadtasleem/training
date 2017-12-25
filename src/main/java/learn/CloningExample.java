package learn;

import learn.data.Address;
import learn.data.City;
import learn.data.Person;

public class CloningExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		City city = new City();
		city.setCountry("India");
		city.setName("Bangalore");
		city.setZip("560056");
		Address a = new Address();
		a.setAddress1("A1");
		a.setAddress2("A12");
		a.setCity(city);
		
		Person p1 = new Person();
		p1.setFirstName("F1");
		p1.setLastName("L1");
		p1.setAddress(a);
		
		Person p2 = p1.clone();
		p2.setFirstName("P2");
		p2.getAddress().setAddress1("A2");
		System.out.println(p1.getFirstName()+" "+p1.getAddress().getAddress1());
	}
}
