package application.com.service;

import java.util.List;

import application.com.model.ClassRegistryModel;
import application.com.model.TeacherProfileUpdateModel;
import application.com.model.TeacherRegistrationModel;

public interface ITeacherService {
    public void add(TeacherRegistrationModel teacherRegistrationModel);
    public void update(TeacherProfileUpdateModel teacherProfileUpdateModel);
    public void delete(String userId);
    public TeacherRegistrationModel getByUserId(String userId, TeacherRegistrationModel teacherRegistrationModel);
    public void notifyStudents(List<ClassRegistryModel> classRegistryModelList);
    public boolean updatePassword(String newPassword, String oldPassword, String userId);
    public boolean resetPassword(String userId, String password);
    public TeacherRegistrationModel fetchByEmail(String email, TeacherRegistrationModel teacherRegistrationModel);
}
