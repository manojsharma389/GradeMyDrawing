package application.com.dao;

import application.com.model.AdminProfileUpdateModel;
import application.com.model.AdminRegistrationModel;

public interface IAdminDao {
    public  void add(AdminRegistrationModel adminRegistrationModel);
    public void update(AdminProfileUpdateModel adminProfileUpdateModel);
    public AdminRegistrationModel fetchByUserId(String userId, AdminRegistrationModel adminRegistrationModel);
    public void delete(String userId);
    public boolean updatePassword(String newPassword, String oldPassword, String userId);
    public boolean resetPassword(String userId, String password);
    public AdminRegistrationModel fetchByEmailId(String email, AdminRegistrationModel adminRegistrationModel);
}
