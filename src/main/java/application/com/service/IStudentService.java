package application.com.service;

import application.com.model.StudentProfileUpdateModel;
import application.com.model.StudentRegistrationModel;

import java.util.List;

public interface IStudentService {

    public void add(StudentRegistrationModel studentRegistrationModel);
    public void update(StudentRegistrationModel studentRegistrationModel);
    public void update(StudentProfileUpdateModel studentProfileUpdateModel);
    public void delete(String userId);
    public StudentRegistrationModel getByUserId(String userId, StudentRegistrationModel studentRegistrationModel);
    public List<StudentRegistrationModel> fetchStudentsLikeUserId(String userId);
    public boolean updatePassword(String newPassword, String oldPassword, String userId);
    public boolean resetPassword(String userId, String password);
    public StudentRegistrationModel fetchByEmail(String email, StudentRegistrationModel studentRegistrationModel);
}
