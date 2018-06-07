package application.com.dao;

import application.com.entities.UserRole;
import application.com.model.UserRolesModel;

public interface IUserRolesDao {
    public void add(UserRolesModel userRolesModel);
    public void update(UserRolesModel userRolesModel);
    public void delete(String userId);
    public UserRolesModel getUserById(String userId, UserRolesModel userRolesModel);
    public UserRole getUserById(String userId);
}
