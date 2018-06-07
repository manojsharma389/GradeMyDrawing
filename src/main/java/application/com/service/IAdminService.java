package application.com.service;

import application.com.model.AdminProfileUpdateModel;
import application.com.model.AdminRegistrationModel;

public interface IAdminService{
    public void add(AdminRegistrationModel adminRegistrationModel);
    public void update(AdminProfileUpdateModel adminProfileUpdateModel);
    public void delete(String userId);
    public AdminRegistrationModel getByUserId(String userId, AdminRegistrationModel adminRegistrationModel);
    public boolean updatePassword(String newPassword, String oldPassword, String userId);
    public boolean resetPassword(String userId, String password);
    public AdminRegistrationModel fetchByEmailId(String email, AdminRegistrationModel adminRegistrationModel);
}
