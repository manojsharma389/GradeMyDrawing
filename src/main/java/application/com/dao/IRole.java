package application.com.dao;

import application.com.model.RoleCreateModel;

public interface IRole {
    public void add(RoleCreateModel roleCreateModel);
    public void update(RoleCreateModel roleCreateModel);
    public void delete(String roleId);
    public RoleCreateModel fetchByRoleId(String roleId, RoleCreateModel roleCreateModel);
}
