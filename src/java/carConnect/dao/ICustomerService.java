<<<<<<< HEAD
package java.carConnect.dao;

import java.carConnect.entity.Customer;

public interface ICustomerService {
	Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    void registerCustomer(Customer customerData);
    void updateCustomer(Customer customerData);
    void deleteCustomer(int customerId);
}
=======
package java.carConnect.dao;

import java.carConnect.entity.Customer;

public interface ICustomerService {
	Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    void registerCustomer(Customer customerData);
    void updateCustomer(Customer customerData);
    void deleteCustomer(int customerId);
}
>>>>>>> cf09df744e197d6953e9e83a50eb81514f430173
