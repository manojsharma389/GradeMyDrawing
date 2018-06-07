package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import application.com.entities.UserRole;
import application.com.model.UserRolesModel;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRolesDaoImpl extends GenericHibernateClient<UserRole, Integer> implements IUserRolesDao {

    @Transactional
    public void add(UserRolesModel userRolesModel){
        UserRole userRole = new UserRole();
        userRole = modelToUserRole(userRolesModel, userRole);
        create(userRole);
    }

    @Transactional
    public void update(UserRolesModel userRolesModel){
        UserRole userRole = getUserById(userRolesModel.getUserId());
        userRole = modelToUserRole(userRolesModel, userRole);
        update(userRole);
    }

    public void delete(String userId){
        UserRole userRole = getUserById(userId);
        delete(userRole);
    }

    public UserRolesModel getUserById(String userId, UserRolesModel userRolesModel){
        UserRole userRole = getUserById(userId);
        return userRoleToModel(userRolesModel, userRole);
    }

    public UserRole getUserById(String userId){
        Criterion criterion =  Restrictions.eq("userId", userId);
        List<UserRole> user = findByCriteria(criterion);
        return user!=null ? user.get(0): null;
    }

    public UserRole modelToUserRole(UserRolesModel userRolesModel, UserRole userRole){
        if(userRole != null && userRolesModel != null) {
            userRole = (UserRole) CopyProperties.copyNotNullProperties(userRolesModel, userRole);
        }
        //BeanUtils.copyProperties(userRolesModel, userRole);
        return userRole;
    }

    public UserRolesModel userRoleToModel(UserRolesModel userRolesModel, UserRole userRole){
        if(userRole != null && userRolesModel != null) {
            userRolesModel = (UserRolesModel) CopyProperties.copyNotNullProperties(userRole, userRolesModel);
        }
        //BeanUtils.copyProperties(userRole, userRolesModel);
        return userRolesModel;
    }

}
