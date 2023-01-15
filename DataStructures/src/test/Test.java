package test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

//		TestInterface testInterface = new Ipv4address();
//
//		testInterface.name();
//		
//		TestInterface testInterface1 =new Ipv6address();
//		
//		testInterface.name();
//		
//		TestInterface testInterface2 = new Ipv4address();
//		
//		System.out.println(Objects.equals(testInterface, testInterface2));

//		Customer john = new Customer("John P.", 15);
//		Customer sarah = new Customer("Sarah M.", 200);
//		Customer charles = new Customer("Charles B.", 150);
//		Customer mary = new Customer("Mary T.", 1);
//
//		List<Customer> customers = Arrays.asList(john, sarah, charles, mary);
//
//		List<Customer> customersWithMoreThan100Points = customers.stream()
//				.filter(c -> (c.getPoints() > 100 && c.getName().contains("M"))).collect(Collectors.toList());
//
//		System.out.println(customersWithMoreThan100Points);

		int[] nums1 = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;

		merge(nums1, m, nums2, n);

		for (int i = 0; i < nums1.length; i++)
			System.out.println(nums1[i]);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int tot_length = m + n;
//		for (int i = 0; i < tot_length; i++) {
//			if (nums1[i] == 0) {
//				nums1[i] = nums2[(i-n)<0 ? 0:i-n];
//			}
//		
		int index = tot_length - n;
		for (int i = 0; i < n; i++) {
			nums1[index + i] = nums2[i];
		}

		Arrays.sort(nums1);

	}

}
