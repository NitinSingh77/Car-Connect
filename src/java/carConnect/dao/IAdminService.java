<<<<<<< HEAD
package java.carConnect.dao;

import java.carConnect.entity.Admin;

public interface IAdminService {
	//Declaration of Non-Implemented Methods
	Admin getAdminById(int adminId);
    Admin getAdminByUsername(String username);
    void registerAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(int adminId);
}
=======
package java.carConnect.dao;

import java.carConnect.entity.Admin;

public interface IAdminService {
	//Declaration of Non-Implemented Methods
	Admin getAdminById(int adminId);
    Admin getAdminByUsername(String username);
    void registerAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(int adminId);
}
>>>>>>> cf09df744e197d6953e9e83a50eb81514f430173
