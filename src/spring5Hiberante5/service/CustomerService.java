package spring5Hiberante5.service;

import java.util.List;

import spring5Hiberante5.bean.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}