package application.com.dao;

import application.com.entities.Student;
import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.StudentRegistrationModel;
import application.com.model.TeacherProfileUpdateModel;
import application.com.model.TeacherRegistrationModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import application.com.entities.Teacher;

import java.util.List;

@Repository
public class TeacherDaoImpl extends GenericHibernateClient<Teacher, String> implements ITeacherDao {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void add(TeacherRegistrationModel teacherRegistrationModel){
        Teacher teacher = new Teacher();
        create(modelToTeacher(teacherRegistrationModel, teacher));
    }

    @Transactional
    public void update(TeacherProfileUpdateModel teacherProfileUpdateModel){
        Teacher teacher = fetchByUserId(teacherProfileUpdateModel.getUserId());
        update(modelToTeacher(teacherProfileUpdateModel, teacher));
//        teacher.setEmail(teacherProfileUpdateModel.getEmail());
//        teacher.setDisplayName(teacherProfileUpdateModel.getDisplayName());
//        teacher.setPlanId(teacherProfileUpdateModel.getPlanId());
//        teacher.setRegistrationDate(teacherProfileUpdateModel.getRegistrationDate());
//        teacher.setRegistrationExpirationDate(teacherProfileUpdateModel.getRegistrationExpirationDate());
//        teacher.setBillingFrequency(teacherProfileUpdateModel.getBillingFrequency());
//        teacher.setBillingStatus(teacherProfileUpdateModel.getBillingStatus());
//        teacher.setBillingTransactionResponse(teacherProfileUpdateModel.getBillingTransactionResponse());
//        teacher.setBillingTransactionDate(teacherProfileUpdateModel.getBillingTransactionDate());
//        teacher.setBillingAmount(teacherProfileUpdateModel.getBillingAmount());

    }

    public void delete(String userId){
        Teacher teacher = fetchByUserId(userId);
        delete(teacher);
    }

    @Transactional
    public boolean updatePassword(String newPassword, String oldPassword, String userId){
        Teacher teacher = fetchByUserId(userId);
        if(null != teacher && passwordEncoder.matches(oldPassword, teacher.getPassword())){
            teacher.setPassword(passwordEncoder.encode(newPassword));
            update(teacher);
            return true;
        }
        else
            return false;
    }

    @Transactional
    public boolean resetPassword(String userId, String password) {
        Teacher teacher = fetchByUserId(userId);
        if(null != teacher){
            teacher.setPassword(password);
            return true;
        }
        else {
            return false;
        }
    }

    public TeacherRegistrationModel fetchByUserId(String userId, TeacherRegistrationModel teacherRegistrationModel) {
        Teacher teacher = fetchByUserId(userId);
        return teacherToModel(teacherRegistrationModel, teacher);
    }

    public Teacher fetchByUserId(String userId){
        Criterion criterion =  Restrictions.eq("userId", userId);
        List<Teacher> teachers = findByCriteria(criterion);
        return teachers!=null ? teachers.get(0): null;
    }

    public Teacher fetchByEmail(String email){
        Criterion criterion =  Restrictions.eq("email", email);
        List<Teacher> teachers = findByCriteria(criterion);
        return teachers!=null ? teachers.get(0): null;
    }

    public TeacherRegistrationModel fetchByEmail(String email, TeacherRegistrationModel teacherRegistrationModel){
        Teacher teacher = fetchByEmail(email);
        return teacherToModel(teacherRegistrationModel, teacher);
    }

    public Teacher modelToTeacher(TeacherRegistrationModel teacherRegistrationModel, Teacher teacher){
        if(null != teacherRegistrationModel && null != teacher) {
            teacher = (Teacher) CopyProperties.copyNotNullProperties(teacherRegistrationModel, teacher);
        }
        //BeanUtils.copyProperties(teacherRegistrationModel, teacher);
        return teacher;
    }

    public Teacher modelToTeacher(TeacherProfileUpdateModel teacherProfileUpdateModel, Teacher teacher){
        if(null != teacherProfileUpdateModel && null != teacher) {
            teacher = (Teacher) CopyProperties.copyNotNullProperties(teacherProfileUpdateModel, teacher);
        }
        //BeanUtils.copyProperties(teacherRegistrationModel, teacher);
        return teacher;
    }

    public TeacherRegistrationModel teacherToModel(TeacherRegistrationModel teacherRegistrationModel, Teacher teacher){
        if(null != teacherRegistrationModel && null != teacher) {
            teacherRegistrationModel = (TeacherRegistrationModel) CopyProperties.copyNotNullProperties(teacher, teacherRegistrationModel);
        }
        //BeanUtils.copyProperties(teacher, teacherRegistrationModel);
        return teacherRegistrationModel;
    }

}
