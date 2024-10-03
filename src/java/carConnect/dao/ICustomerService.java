package java.carConnect.dao;

import java.carConnect.entity.Customer;

public interface ICustomerService {
	Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    void registerCustomer(Customer customerData);
    void updateCustomer(Customer customerData);
    void deleteCustomer(int customerId);
}
