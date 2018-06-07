package application.com.service;

import application.com.dao.IClassRegistryDao;
import application.com.model.ClassRegistryModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassRegistryService implements IClassRegistryService {
    @Autowired
    IClassRegistryDao classRegistryDao;

    public void add(ClassRegistryModel classRegistryModel){
        classRegistryDao.add(classRegistryModel);
    }
    public void update(ClassRegistryModel classRegistryModel){
        classRegistryDao.update(classRegistryModel);
    }
    public void delete(String classId, String userId){
        classRegistryDao.delete(classId, userId);
    }
    public List<ClassRegistryModel> getByClassId(String classId, 
    		List<ClassRegistryModel> classRegistryModelList){
        return classRegistryDao.getByClassId(classId, 
        		classRegistryModelList);
    }
    
    public ClassRegistryModel getByClassIdAndUserId(String classId, String UserId, 
    		ClassRegistryModel classRegistryModel) {
    	return classRegistryDao.getByClassIdAndUserId(classId, UserId, classRegistryModel);
    }

    public List<ClassRegistryModel> getByUserId(String userId,
                                                List<ClassRegistryModel> classRegistryModelList){
        return classRegistryDao.getByUserId(userId, classRegistryModelList);
    }
}
