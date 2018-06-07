package application.com.service;

import application.com.dao.ICadClassDao;
import application.com.dao.IStudentDao;
import application.com.model.ClassModel;
import application.com.model.StudentRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CadClassService implements ICadClassService {
    @Autowired
    ICadClassDao cadClassDao;

    @Autowired
    IStudentDao studentDao;

    public void add(ClassModel classModel){
        cadClassDao.add(classModel);
    }
    public void update(ClassModel classModel){
        cadClassDao.update(classModel);
    }
    public void delete(String classId){
        cadClassDao.delete(classId);
    }
    public ClassModel getByClassId(String classId, ClassModel classModel){
       return cadClassDao.getByClassId(classId, classModel);
    }

    public String generateUserIdPasswordForStudent(String firstName, String lastName){
        String userId = firstName+"_"+lastName;
        int max = 0;
        List<StudentRegistrationModel> studentRegistrationModelList =
                studentDao.fetchStudentsLikeUserId(userId);
        if(studentRegistrationModelList.size() == 0){
            return userId;
        }
        else {
            for (StudentRegistrationModel studentRegistrationModel : studentRegistrationModelList) {
                String s[] = studentRegistrationModel.getUserId().split("_");
                if(s.length > 2 && max < Integer.valueOf(s[s.length-1])){
                    max += Integer.valueOf(s[s.length-1]);
                }
            }

            return userId = userId + "_" + (max+1);
        }
    }

    public void updateRegisterCount(String classId){
        ClassModel classModel = new ClassModel();
        classModel = cadClassDao.getByClassId(classId, classModel);
        classModel.setRegisteredStudents(classModel.getRegisteredStudents()+1);
        cadClassDao.update(classModel);
    }

    public List<ClassModel> fetchAllClasses(){
        return cadClassDao.fetchAllClasses();
    }

}
