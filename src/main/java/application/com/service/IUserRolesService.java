package application.com.service;

import application.com.model.UserRolesModel;

public interface IUserRolesService {
    public UserRolesModel getUserByUserId(String userId, UserRolesModel userRolesModel);
    public void add(UserRolesModel userRolesModel);
    public void update(UserRolesModel userRolesModel);
    public void delete(String userId);
}
