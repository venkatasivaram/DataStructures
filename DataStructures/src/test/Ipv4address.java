package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ipv4address implements TestInterface {

	@Override
	public void name() {
		System.out.println("In ipv4address");
		Customer c1=new Customer("s", 10);
		Customer c2=new Customer("l", 20);
		Customer c3=new Customer("i", 30);
		
		List<Customer> ls=new ArrayList<Customer>();
		ls.add(c1);
		ls.add(c2);
		ls.add(c3);
		ls.stream().map(c ->new Customer(c.getName(),c.getPoints())).collect(Collectors.toList());
		
		

	}

}
