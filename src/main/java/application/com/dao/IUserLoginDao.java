package application.com.dao;

import application.com.entities.UserRole;

public interface IUserLoginDao {
    public UserRole getUserByName(String userName);
}
