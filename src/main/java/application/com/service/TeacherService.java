package application.com.service;

import application.com.dao.IStudentDao;
import application.com.dao.ITeacherDao;
import application.com.model.ClassRegistryModel;
import application.com.model.StudentRegistrationModel;
import application.com.model.TeacherProfileUpdateModel;
import application.com.model.TeacherRegistrationModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherService implements ITeacherService {

    @Autowired
    private ITeacherDao teacherDao;
    
    @Autowired
    private IStudentDao studentDao;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    IEmailService emailService;

    public void add(TeacherRegistrationModel teacherRegistrationModel){
        if(null != teacherRegistrationModel.getPassword()) {
            teacherRegistrationModel.setPassword(passwordEncoder.encode(teacherRegistrationModel.getPassword()));
        }
        if(null != teacherRegistrationModel.getTeacherSecurityQuestion1()){
            teacherRegistrationModel.setTeacherSecurityQuestion1(passwordEncoder.encode(
                    teacherRegistrationModel.getTeacherSecurityQuestion1()));
        }

        if(null != teacherRegistrationModel.getTeacherSecurityQuestion2()) {
            teacherRegistrationModel.setTeacherSecurityQuestion2(passwordEncoder.encode(
                    teacherRegistrationModel.getTeacherSecurityQuestion2()));
        }

        if(null != teacherRegistrationModel.getTeacherSecurityQuestion3()) {
            teacherRegistrationModel.setTeacherSecurityQuestion3(passwordEncoder.encode(
                    teacherRegistrationModel.getTeacherSecurityQuestion3()));
        }

        if(null != teacherRegistrationModel.getTeacherSecurityAnswer1()) {
            teacherRegistrationModel.setTeacherSecurityAnswer1(passwordEncoder.encode(
                    teacherRegistrationModel.getTeacherSecurityAnswer1()));
        }

        if(null != teacherRegistrationModel.getTeacherSecurityAnswer2()) {
            teacherRegistrationModel.setTeacherSecurityAnswer2(passwordEncoder.encode(
                    teacherRegistrationModel.getTeacherSecurityAnswer2()));
        }

        if(null != teacherRegistrationModel.getTeacherSecurityAnswer3()) {
            teacherRegistrationModel.setTeacherSecurityAnswer3(passwordEncoder.encode(
                    teacherRegistrationModel.getTeacherSecurityAnswer3()));
        }
        teacherDao.add(teacherRegistrationModel);
    }
    public void update(TeacherProfileUpdateModel teacherProfileUpdateModel){
        teacherDao.update(teacherProfileUpdateModel);
    }
    public void delete(String userId){
        teacherDao.delete(userId);
    }
    public TeacherRegistrationModel getByUserId(String userId, TeacherRegistrationModel teacherRegistrationModel){
        return teacherDao.fetchByUserId(userId, teacherRegistrationModel);
    }

    public boolean updatePassword(String newPassword, String oldPassword, String userId){
        return teacherDao.updatePassword(newPassword, oldPassword, userId);
    }

    public boolean resetPassword(String userId, String password){
        return teacherDao.resetPassword(userId, passwordEncoder.encode(password));
    }

    public TeacherRegistrationModel fetchByEmail(String email, TeacherRegistrationModel teacherRegistrationModel){
        return teacherDao.fetchByEmail(email, teacherRegistrationModel);
    }
    
    public void notifyStudents(List<ClassRegistryModel> classRegistryModelList) {
    	StudentRegistrationModel studentRegistrationModel = null;
    	for (ClassRegistryModel classRegistryModel : classRegistryModelList) {
    		studentRegistrationModel = new StudentRegistrationModel();
    		if(classRegistryModel.getUserType().equalsIgnoreCase("STUDENT")){
                studentRegistrationModel = studentDao.fetchByUserId(classRegistryModel.getUserId(), studentRegistrationModel);
                String email = studentRegistrationModel.getEmail();
                if(null != email) {
                    emailService.sendSimpleMessage(email, "New class created", "New class with Id : " +
                            classRegistryModel.getClassId());
            }

			}
		}
    }
    
}
