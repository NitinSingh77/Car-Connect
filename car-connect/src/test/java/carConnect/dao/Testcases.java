package carConnect.dao;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Testcases {

    @Test
    public void testInvalidCustomerAuthentication() {
        
        String invalidUsername = "User";
        String invalidPassword = "Password";
        
        boolean result = AuthenticationService.authenticateCustomer(invalidUsername, invalidPassword);
        assertFalse(result, "Authentication should fail for invalid credentials");
    }
    
    
    
    
    
  

    
}


