package com.example.customer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;


@Service
public class CustomerServiceImplementation implements CustomerService {

	private Map<Integer,Customer> Customers;
	
	public CustomerServiceImplementation(){
	loadCustomer();	
	}
	
	private void loadCustomer() {
		Customers = new HashMap<Integer,Customer>();
		
		Customer customer1 = new Customer();
		
		customer1.setId(1);
		customer1.setAddressLineOne("5266");
		customer1.setAddressLineTwo("Baywater Dr");
		customer1.setCity("Tampa");
		customer1.setZipCode("33615");
		customer1.setFirstName("John");
		customer1.setLastName("Smith");
		customer1.setEmail("js@hotmail.com");
		Customers.put(1, customer1);
		
		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setAddressLineOne("5245");
		customer2.setAddressLineTwo("Harborside Dr");
		customer2.setCity("Tampa");
		customer2.setZipCode("33615");
		customer2.setFirstName("Dan");
		customer2.setLastName("Brown");
		customer2.setEmail("db@hotmail.com");
		Customers.put(2, customer2);
		
		
	}

	@Override
	public List<Customer> getCustomers() {
		System.out.println("****Inside get Customer*****");
		
		return new ArrayList<Customer>(Customers.values());
	}

	@Override
	public Customer viewCustomer(Integer id) {
		System.out.println("****Inside view Customer*****");
		return Customers.get(id);
	}

		
	@Override
	public Customer saveOrUpdateCustomer(Customer cus) {
		if(cus!=null) {
			if(cus.getId()==null) {
				cus.setId(getNextKey());
				Customers.put(cus.getId(), cus);
			}
			else {
				Customers.put(cus.getId(), cus);
			}
			return cus;
		}
		else {
			throw new RuntimeException("Customer cannot be null");
		}
	}
	
	private Integer getNextKey() {
		return Collections.max(Customers.keySet())+1;
	}

	@Override
	public void deleteCustomer(Integer id) {
		Customers.remove(id);
		
	}

}
