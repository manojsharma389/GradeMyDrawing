package application.com.dao;

import application.com.entities.CADClass;
import application.com.model.ClassModel;

import java.util.List;

public interface ICadClassDao {
    public void add(ClassModel classModel);
    public void update(ClassModel classModel);
    public void delete(String classId);
    public ClassModel getByClassId(String classId, ClassModel classModel);
    public CADClass getByClassId(String classId);
    public List<ClassModel> fetchAllClasses();
}
