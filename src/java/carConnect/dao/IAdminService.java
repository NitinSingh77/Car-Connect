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
