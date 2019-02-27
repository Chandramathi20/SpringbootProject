package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

/**
 * @author Mathi
 *
 */
@Controller
public class CustomerController {
	
	private CustomerService customerservice;
	
	
    @Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}




	@RequestMapping("/customers")
	public String Customer(Model model) {
		model.addAttribute("customers", customerservice.getCustomers());
		System.out.println("******Customer Processing done******");
		return "customer";
	}
	
	@RequestMapping("/customers/{id}")
	public String viewCustomer(@PathVariable Integer id,Model model) {;
	
		System.out.println("****Inside view Customer Controller*****");
		model.addAttribute("customer", customerservice.viewCustomer(id));
		
		return "customer";
	}
	
	@RequestMapping("/customers/Add")
	public String addCustomer(Model model) {
		System.out.println("****Inside Add Customer*****");
		model.addAttribute("customer", new Customer());
		return "NewCustomer";
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public String saveOrUpdateCustomer(Customer customer) {
		System.out.println("****Enter Save Customer*****");
		
		Customer saveCustomer = customerservice.saveOrUpdateCustomer(customer);
		System.out.println("****Exit Save Customer*****" + saveCustomer.getId());
		return "redirect:/customers/" +saveCustomer.getId();
	}
	
	@RequestMapping("/customers/edit/{id}")
	public String editCustomer(@PathVariable Integer id,Model model) {
		model.addAttribute("customer", customerservice.viewCustomer(id));
		return "NewCustomer";
			
	}
	
	@RequestMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		customerservice.deleteCustomer(id);
		return "redirect:/customers";
		
	}
	
	 
}
