package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.AdminProfileUpdateModel;
import application.com.model.AdminRegistrationModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import application.com.entities.Admin;
import application.com.enums.AdminStatus;

import java.util.List;

@Repository
public class AdminDaoImpl extends GenericHibernateClient<Admin, String> implements IAdminDao {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public  void add(AdminRegistrationModel adminRegistrationModel){
        Admin admin = new Admin();
        create(modelToAdmin(adminRegistrationModel, admin));
    }

    @Transactional
    public void update(AdminProfileUpdateModel adminProfileUpdateModel){
        Admin admin = fetchByUserId(adminProfileUpdateModel.getUserId());
        admin.setAdminStatus(setAdminStatusInEntity(adminProfileUpdateModel.getAdminStatus()));
        admin.setDisplayName(adminProfileUpdateModel.getDisplayName());
        admin.setModifiedBy(adminProfileUpdateModel.getModifiedBy());
        admin.setModifiedDate(adminProfileUpdateModel.getModifiedDate());
        update(admin);
    }

    public void delete(String userId){
        Admin admin = fetchByUserId(userId);
        delete(admin);
    }

    public Admin fetchByUserId(String userId){
        Criterion criterion =  Restrictions.eq("userId", userId);
        List<Admin> admins = findByCriteria(criterion);
        return admins!=null ? admins.get(0): null;
    }

    public Admin fetchByEmailId(String email){
        Criterion criterion =  Restrictions.eq("email", email);
        List<Admin> admins = findByCriteria(criterion);
        return admins!=null ? admins.get(0): null;
    }

    public AdminRegistrationModel fetchByEmailId(String email, AdminRegistrationModel adminRegistrationModel){
        Admin admin = fetchByEmailId(email);
        return adminToModel(adminRegistrationModel, admin);
    }

    @Transactional
    public boolean updatePassword(String newPassword, String oldPassword, String userId){
        Admin admin = fetchByUserId(userId);
        if(null!= admin && passwordEncoder.matches(oldPassword, admin.getPassword())){
            admin.setPassword(passwordEncoder.encode(newPassword));
            update(admin);
            return true;
        }
        else
            return false;
    }

    @Transactional
    public boolean resetPassword(String userId, String password) {
        Admin admin = fetchByUserId(userId);
        if(null != admin){
            admin.setPassword(password);
            return true;
        }
        else {
            return false;
        }
    }

    public AdminRegistrationModel fetchByUserId(String userId, AdminRegistrationModel adminRegistrationModel){
        Admin admin = fetchByUserId(userId);
        return adminToModel(adminRegistrationModel, admin);

    }

    public AdminStatus setAdminStatusInEntity(String adminStatus){

        if ("ACTIVE".equalsIgnoreCase(adminStatus)) {
            return AdminStatus.ACTIVE;
        } else if ("INACTIVE".equalsIgnoreCase(adminStatus)) {
            return AdminStatus.INACTIVE;
        } else
            return AdminStatus.CANCELLED;

    }

    public Admin modelToAdmin(AdminRegistrationModel adminRegistrationModel, Admin admin){
        if(null != adminRegistrationModel && null != admin) {
            admin = (Admin) CopyProperties.copyNotNullProperties(adminRegistrationModel, admin);
            admin.setAdminStatus(setAdminStatusInEntity(adminRegistrationModel.getAdminStatus()));
//            if ("ACTIVE".equalsIgnoreCase(adminRegistrationModel.getAdminStatus())) {
//                admin.setAdminStatus(AdminStatus.ACTIVE);
//            } else if ("INACTIVE".equalsIgnoreCase(adminRegistrationModel.getAdminStatus())) {
//                admin.setAdminStatus(AdminStatus.INACTIVE);
//            } else if ("CANCELLED".equalsIgnoreCase(adminRegistrationModel.getAdminStatus()))
//                admin.setAdminStatus(AdminStatus.CANCELLED);
        }
        return admin;

    }

    public AdminRegistrationModel adminToModel(AdminRegistrationModel adminRegistrationModel, Admin admin){
        if(null != adminRegistrationModel && null != admin) {
            adminRegistrationModel = (AdminRegistrationModel) CopyProperties.copyNotNullProperties(admin, adminRegistrationModel);
            //BeanUtils.copyProperties(admin, adminRegistrationModel);
            adminRegistrationModel.setAdminStatus(admin.getAdminStatus().toString());
        }
        return adminRegistrationModel;

    }
}
