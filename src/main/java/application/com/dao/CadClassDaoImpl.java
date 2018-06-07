package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import application.com.property.GradeMyDesignProperties;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import application.com.entities.CADClass;
import application.com.enums.ClassStatus;
import application.com.model.ClassModel;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CadClassDaoImpl extends GenericHibernateClient<CADClass, String> implements ICadClassDao  {

    @Transactional
    public void add(ClassModel classModel){

        CADClass cadClass = new CADClass();
        cadClass = modelToCadClass(classModel, cadClass);
        create(cadClass);

    }

    @Transactional
    public void update(ClassModel classModel){

        CADClass cadClass = getByClassId(classModel.getClassId());
        cadClass = modelToCadClass(classModel, cadClass);
        update(cadClass);

    }

    @Transactional
    public void delete(String classId){
        CADClass cadClass = getByClassId(classId);
        delete(cadClass);

    }

    public CADClass getByClassId(String classId){
            Criterion criterion =  Restrictions.eq("classId", classId);
            List<CADClass> cadClassList = findByCriteria(criterion);
            return cadClassList!=null ? cadClassList.get(0): null;

    }

    public List<ClassModel> fetchAllClasses(){
        List<CADClass> cadClassList =
                (List<CADClass>)getSession().createQuery
                        (GradeMyDesignProperties.LIST_ALL_CLASSES.toString()).list();

        List<ClassModel> classModelList = new ArrayList<ClassModel>();
        ClassModel classModel = null;
        for (CADClass cadClass : cadClassList) {
            classModel = new ClassModel();
            classModelList.add(cadClassToModel(classModel, cadClass));

        }
        return classModelList;

    }

    public ClassModel getByClassId(String classId, ClassModel classModel){
        CADClass cadClass = getByClassId(classId);
        return cadClassToModel(classModel, cadClass);

    }

    public ClassModel cadClassToModel(ClassModel classModel, CADClass cadClass){

        if(null != classModel && null!= cadClass) {
            classModel = (ClassModel) CopyProperties.copyNotNullProperties(cadClass, classModel);
            //BeanUtils.copyProperties(cadClass, classModel);
            classModel.setClassStatus(cadClass.getClassStatus().toString());
        }
        return classModel;
    }

    public CADClass modelToCadClass(ClassModel classModel, CADClass cadClass){

        if(null != classModel && null!= cadClass) {
            cadClass = (CADClass) CopyProperties.copyNotNullProperties(classModel, cadClass);
            //BeanUtils.copyProperties(classModel, cadClass);
            if ("ACTIVE".equalsIgnoreCase(classModel.getClassStatus())) {
                cadClass.setClassStatus(ClassStatus.ACTIVE);
            } else if ("INACTIVE".equalsIgnoreCase(classModel.getClassStatus())) {
                cadClass.setClassStatus(ClassStatus.INACTIVE);
            } else if ("CANCELLED".equalsIgnoreCase(classModel.getClassStatus())) {
                cadClass.setClassStatus(ClassStatus.CANCELLED);
            }
        }
        return cadClass;
    }

}
