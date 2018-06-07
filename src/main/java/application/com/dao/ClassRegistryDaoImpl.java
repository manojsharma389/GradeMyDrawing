package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import application.com.entities.ClassRegistry;
import application.com.model.ClassRegistryModel;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public class ClassRegistryDaoImpl extends GenericHibernateClient<ClassRegistry, String> implements IClassRegistryDao {

    @Transactional
    public void add(ClassRegistryModel classRegistryModel){
        ClassRegistry classRegistry = new ClassRegistry();
        classRegistry = modelToClassRegistry(classRegistryModel, classRegistry);
        create(classRegistry);
    }

    @Transactional
    public void update(ClassRegistryModel classRegistryModel){
        ClassRegistry classRegistry = getByClassIdAndUserId(classRegistryModel.getClassId(),
        		classRegistryModel.getUserId());
        classRegistry = modelToClassRegistry(classRegistryModel, classRegistry);
        update(classRegistry);

    }

    @Transactional
    public void delete(String classId, String userId){
        ClassRegistry classRegistry = getByClassIdAndUserId(classId, userId);
        delete(classRegistry);
    }
    
    @Transactional
    public ClassRegistry getByClassIdAndUserId(String classId, String userId){

        Criterion criterion1 =  Restrictions.eq("classId", classId);
        Criterion criterion2 =  Restrictions.eq("userId", userId);
        List<ClassRegistry> classRegistryList = findByCriteria(criterion1, criterion2);
        return classRegistryList!=null ? classRegistryList.get(0): null;

    }
    
    public ClassRegistryModel getByClassIdAndUserId(String classId, String UserId, 
    		ClassRegistryModel classRegistryModel){

        ClassRegistry classRegistry = getByClassIdAndUserId(classId, UserId);
        return classRegistryToModel(classRegistryModel, classRegistry);

    }
    
    @Transactional
    public List<ClassRegistry> getByClassId(String classId){

        Criterion criterion =  Restrictions.eq("classId", classId);
        List<ClassRegistry> classRegistryList = findByCriteria(criterion);
        return classRegistryList;

    }

    @Transactional
    public List<ClassRegistry> getByUserId(String userId){

        Criterion criterion =  Restrictions.eq("userId", userId);
        List<ClassRegistry> classRegistryList = findByCriteria(criterion);
        return classRegistryList;

    }

    public List<ClassRegistryModel> getByUserId(String userId,
                                           List<ClassRegistryModel> classRegistryModelList){

        List<ClassRegistry> classRegistryList = getByUserId(userId);
        ClassRegistryModel classRegistryModel = null;
        for (ClassRegistry classRegistry : classRegistryList) {
            classRegistryModel = new ClassRegistryModel();
            classRegistryModelList.add(classRegistryToModel(classRegistryModel, classRegistry));
        }
        return classRegistryModelList;

    }

    public List<ClassRegistryModel> getByClassId(String classId, 
    		List<ClassRegistryModel> classRegistryModelList){

    	List<ClassRegistry> classRegistryList = getByClassId(classId);
    	ClassRegistryModel classRegistryModel = null;
    	for (ClassRegistry classRegistry : classRegistryList) {
			classRegistryModel = new ClassRegistryModel();
			classRegistryModelList.add(classRegistryToModel(classRegistryModel, classRegistry));
		}
    	return classRegistryModelList;

    }

    public ClassRegistry modelToClassRegistry(ClassRegistryModel classRegistryModel, ClassRegistry classRegistry){
        if(null != classRegistryModel && null != classRegistry) {
            classRegistry = (ClassRegistry) CopyProperties.copyNotNullProperties(classRegistryModel, classRegistry);
            //BeanUtils.copyProperties(classRegistryModel, classRegistry);
        }
        return classRegistry;
    }

    public ClassRegistryModel classRegistryToModel(ClassRegistryModel classRegistryModel,
                                                   ClassRegistry classRegistry){
        if(null != classRegistryModel && null != classRegistry) {
            classRegistryModel = (ClassRegistryModel) CopyProperties.
                    copyNotNullProperties(classRegistry, classRegistryModel);
            //BeanUtils.copyProperties(classRegistry, classRegistryModel);
        }
        return classRegistryModel;
    }

}
