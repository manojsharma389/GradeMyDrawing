package application.com.service;

import application.com.dao.IStudentDao;
import application.com.model.StudentProfileUpdateModel;
import application.com.model.StudentRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService implements IStudentService{

    @Autowired
    IStudentDao studentDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void add(StudentRegistrationModel studentRegistrationModel){
        studentRegistrationModel.setPassword(passwordEncoder.encode(studentRegistrationModel.getPassword()));
        studentDao.add(studentRegistrationModel);
    }
    public void update(StudentProfileUpdateModel studentProfileUpdateModel){
        studentDao.update(studentProfileUpdateModel);
    }
    public void update(StudentRegistrationModel studentRegistrationModel){

    }
    public void delete(String userId){
        studentDao.delete(userId);
    }
    public StudentRegistrationModel getByUserId(String userId, StudentRegistrationModel studentRegistrationModel){
        return studentDao.fetchByUserId(userId, studentRegistrationModel);
    }
    public List<StudentRegistrationModel> fetchStudentsLikeUserId(String userId){
        return studentDao.fetchStudentsLikeUserId(userId);
    }
    public boolean updatePassword(String newPassword, String oldPassword, String userId){
        return studentDao.updatePassword(newPassword, oldPassword, userId);
    }

    public boolean resetPassword(String userId, String password){
        return studentDao.resetPassword(userId, passwordEncoder.encode(password));
    }

    public StudentRegistrationModel fetchByEmail(String email, StudentRegistrationModel studentRegistrationModel){
        return studentDao.fetchByEmail(email, studentRegistrationModel);
    }
}
