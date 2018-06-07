package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.model.StudentProfileUpdateModel;
import application.com.model.StudentRegistrationModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import application.com.entities.Student;
import application.com.property.GradeMyDesignProperties;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl extends GenericHibernateClient<Student, String> implements IStudentDao {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public  void add(StudentRegistrationModel studentRegistrationModel){
        Student student = new Student();
        create(modelToStudent(studentRegistrationModel, student));
    }

    @Transactional
    public void update(StudentRegistrationModel studentRegistrationModel){
        Student student = fetchByUserId(studentRegistrationModel.getUserId());
        update(modelToStudent(studentRegistrationModel, student));
    }

    @Transactional
    public void update(StudentProfileUpdateModel studentProfileUpdateModel){
        Student student = fetchByUserId(studentProfileUpdateModel.getUserId());
        student.setEmail(studentProfileUpdateModel.getEmail());
        student.setDisplayName(studentProfileUpdateModel.getDisplayName());
        student.setModifiedBy(studentProfileUpdateModel.getModifiedBy());
        student.setModifiedDate(studentProfileUpdateModel.getModifiedDate());
        update(student);
    }

    public void delete(String userId){
        Student student = fetchByUserId(userId);
        delete(student);
    }

    @Transactional
    public boolean updatePassword(String newPassword, String oldPassword, String userId){
        Student student = fetchByUserId(userId);
        if(null != student && passwordEncoder.matches(oldPassword, student.getPassword())){
            student.setPassword(passwordEncoder.encode(newPassword));
            update(student);
            return true;
        }
        else
            return false;
    }

    @Transactional
    public boolean resetPassword(String userId, String password) {
        Student student = fetchByUserId(userId);
        if(null != student){
            student.setPassword(password);
            return true;
        }
        else {
            return false;
        }
    }

    public StudentRegistrationModel fetchByUserId(String userId, StudentRegistrationModel studentRegistrationModel){
        Student student = fetchByUserId(userId);
        return studentToModel(studentRegistrationModel, student);
    }

    public StudentRegistrationModel fetchByEmail(String email, StudentRegistrationModel studentRegistrationModel){
        Student student = fetchByEmail(email);
        return studentToModel(studentRegistrationModel, student);
    }

    public List<StudentRegistrationModel> fetchStudentsLikeUserId(String userId){
        List<Student> studentList =
                (List<Student>)getSession().
                        createQuery(GradeMyDesignProperties.LIST_STUDENTS_LIKE_USERID.toString()).
                        setParameter("userId", userId + "%").list();
        List<StudentRegistrationModel> studentRegistrationModelList = new ArrayList<StudentRegistrationModel>();
        StudentRegistrationModel studentRegistrationModel = null;
        for (Student studentFromList : studentList) {
            studentRegistrationModel = new StudentRegistrationModel();
            studentRegistrationModelList.add(studentToModel(studentRegistrationModel, studentFromList));
        }
        return studentRegistrationModelList;

    }

    public Student fetchByUserId(String userId){
        Criterion criterion =  Restrictions.eq("userId", userId);
        List<Student> students = findByCriteria(criterion);
        return students.size()>0 ? students.get(0): null;
    }

    public Student fetchByEmail(String email){
        Criterion criterion =  Restrictions.eq("email", email);
        List<Student> students = findByCriteria(criterion);
        return students.size()>0 ? students.get(0): null;
    }

    public Student modelToStudent(StudentRegistrationModel studentRegistrationModel, Student student){
        if(studentRegistrationModel != null && student != null) {
            student = (Student) CopyProperties.copyNotNullProperties(studentRegistrationModel, student);
        }

        //BeanUtils.copyProperties(studentRegistrationModel, student);
        return student;
    }

    public StudentRegistrationModel studentToModel(StudentRegistrationModel studentRegistrationModel, Student student){
        if(studentRegistrationModel != null && student != null) {
            studentRegistrationModel = (StudentRegistrationModel) CopyProperties.copyNotNullProperties(student, studentRegistrationModel);
        }
        //BeanUtils.copyProperties(student, studentRegistrationModel);
        return studentRegistrationModel;
    }

}
