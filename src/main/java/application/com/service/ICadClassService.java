package application.com.service;

import application.com.model.ClassModel;

import java.util.List;

public interface ICadClassService {
    public void add(ClassModel classModel);
    public void update(ClassModel classModel);
    public void delete(String classId);
    public ClassModel getByClassId(String classId, ClassModel classModel);
    public String generateUserIdPasswordForStudent(String firstName, String lastName);
    public void updateRegisterCount(String classId);
    public List<ClassModel> fetchAllClasses();
}
