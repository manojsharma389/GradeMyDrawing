package application.com.service;

import application.com.dao.IAdminDao;
import application.com.model.AdminProfileUpdateModel;
import application.com.model.AdminRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService implements IAdminService {
    @Autowired
    IAdminDao adminDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void add(AdminRegistrationModel adminRegistrationModel){
        adminRegistrationModel.setPassword(passwordEncoder.encode(adminRegistrationModel.getPassword()));
        adminDao.add(adminRegistrationModel);
    }

    public void update(AdminProfileUpdateModel adminProfileUpdateModel){
        adminDao.update(adminProfileUpdateModel);
    }

    public AdminRegistrationModel getByUserId(String userId, AdminRegistrationModel adminRegistrationModel){
        return adminDao.fetchByUserId(userId, adminRegistrationModel);
    }

    public void delete(String userId) {
        adminDao.delete(userId);
    }

    public boolean updatePassword(String newPassword, String oldPassword, String userId){
        return adminDao.updatePassword(newPassword, oldPassword, userId);
    }

    public boolean resetPassword(String userId, String password){
        return adminDao.resetPassword(userId, passwordEncoder.encode(password));
    }

    public AdminRegistrationModel fetchByEmailId(String email, AdminRegistrationModel adminRegistrationModel){
        return adminDao.fetchByEmailId(email, adminRegistrationModel);
    }


}
