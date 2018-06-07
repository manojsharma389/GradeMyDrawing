package application.com.dao;

import application.com.model.TeacherProfileUpdateModel;
import application.com.model.TeacherRegistrationModel;

public interface ITeacherDao {
    public void add(TeacherRegistrationModel teacherRegistrationModel);
    public void update(TeacherProfileUpdateModel teacherProfileUpdateModel);
    public void delete(String userId);
    public TeacherRegistrationModel fetchByUserId(String userId, TeacherRegistrationModel teacherRegistrationModel);
    public boolean updatePassword(String newPassword, String oldPassword, String userId);
    public boolean resetPassword(String userId, String password);
    public TeacherRegistrationModel fetchByEmail(String email, TeacherRegistrationModel teacherRegistrationModel);
}
