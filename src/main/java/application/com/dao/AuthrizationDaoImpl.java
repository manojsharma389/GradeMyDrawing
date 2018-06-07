package application.com.dao;

import application.com.entities.Actions;
import application.com.entities.RoleActions;
import application.com.entities.UserRole;
import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.property.GradeMyDesignProperties;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthrizationDaoImpl extends GenericHibernateClient<RoleActions, String> implements IAuthrizationDao {
    @Autowired
    IUserRolesDao userRolesDao;

    @Transactional
    @Override
    public List<String> fechActionIdList(String userId) {
        List<String> actionIdList = new ArrayList<>();
        UserRole userRole = new UserRole();
        userRole = userRolesDao.getUserById(userId);

        Criterion c = Restrictions.eq("roleId", userRole.getRoleId());
        List<RoleActions> roleActionsList = findByCriteria(c);
        for (RoleActions roleAction : roleActionsList) {
            actionIdList.add(roleAction.getActionId());
        }
        return actionIdList;

    }
}
