package application.com.service;


import application.com.dao.IUserRolesDao;
import application.com.model.UserRolesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRolesService implements IUserRolesService {

    @Autowired
    IUserRolesDao userRolesDao;

    public UserRolesModel getUserByUserId(String userId, UserRolesModel userRolesModel){
        return userRolesDao.getUserById(userId, userRolesModel);
    }

    public void add(UserRolesModel userRolesModel){
        userRolesDao.add(userRolesModel);
    }
    public void update(UserRolesModel userRolesModel){
        userRolesDao.update(userRolesModel);
    }
    public void delete(String userId){
        userRolesDao.delete(userId);
    }
}
