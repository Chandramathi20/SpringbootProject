package com.example.customer.service;

import java.util.List;

import com.example.customer.model.Customer;


public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer viewCustomer(Integer id);
	
	Customer saveOrUpdateCustomer(Customer cus);

	void deleteCustomer(Integer id);

}
