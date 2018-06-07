package application.com.service;

import application.com.dao.IRole;
import application.com.model.RoleCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    IRole role;

    @Override
    public void add(RoleCreateModel roleCreateModel) {
        role.add(roleCreateModel);
    }

    @Override
    public void update(RoleCreateModel roleCreateModel) {
        role.update(roleCreateModel);
    }

    @Override
    public void delete(String roleId) {
        role.delete(roleId);
    }

    @Override
    public RoleCreateModel fetchByRoleId(String roleId, RoleCreateModel roleCreateModel) {
        return role.fetchByRoleId(roleId, roleCreateModel);
    }
}
