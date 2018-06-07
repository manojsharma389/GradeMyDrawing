package application.com.service;

import application.com.model.RoleCreateModel;

public interface IRoleService {

    public void add(RoleCreateModel roleCreateModel);
    public void update(RoleCreateModel roleCreateModel);
    public void delete(String roleId);
    public RoleCreateModel fetchByRoleId(String roleId, RoleCreateModel roleCreateModel);

}
