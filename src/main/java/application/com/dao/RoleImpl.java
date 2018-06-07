package application.com.dao;

import application.com.entities.Roles;
import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.RoleCreateModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleImpl extends GenericHibernateClient<Roles, String> implements IRole {

    @Override
    @Transactional
    public void add(RoleCreateModel roleCreateModel) {
        Roles roles = new Roles();
        create(modelToRoles(roleCreateModel, roles));
    }

    @Override
    @Transactional
    public void update(RoleCreateModel roleCreateModel) {
        Roles roles = fetchByRoleId(roleCreateModel.getRoleId());
        roles.setRoleType(roleCreateModel.getRoleType());
        roles.setRoleName(roleCreateModel.getRoleName());
        roles.setRoleDescription(roleCreateModel.getRoleDescription());
        roles.setValidUserType(roleCreateModel.getValidUserType());
        roles.setCreatedDate(roleCreateModel.getCreatedDate());
        roles.setCreatedBy(roleCreateModel.getCreatedBy());
        roles.setModifiedDate(roleCreateModel.getModifiedDate());
        roles.setModifiedBy(roleCreateModel.getModifiedBy());
        update(roles);
    }

    @Override
    @Transactional
    public void delete(String roleId) {
        Roles roles = fetchByRoleId(roleId);
        delete(roles);
    }

    @Override
    public RoleCreateModel fetchByRoleId(String roleId, RoleCreateModel roleCreateModel) {
        Roles roles = fetchByRoleId(roleCreateModel.getRoleId());
        return rolesToModel(roles, roleCreateModel);
    }

    public Roles fetchByRoleId(String roleId) {
        Criterion criterion = Restrictions.eq("roleId", roleId);
        List<Roles> rolesList = findByCriteria(criterion);
        return null != rolesList ? rolesList.get(0) : null;
    }

    public Roles modelToRoles(RoleCreateModel roleCreateModel, Roles roles){
        if(null != roleCreateModel && null != roles){
            CopyProperties.copyNotNullProperties(roleCreateModel, roles);
        }
        return roles;
    }

    public RoleCreateModel rolesToModel(Roles roles, RoleCreateModel roleCreateModel){
        if(null != roleCreateModel && null != roles){
            CopyProperties.copyNotNullProperties(roles, roleCreateModel);
        }
        return roleCreateModel;
    }

}
