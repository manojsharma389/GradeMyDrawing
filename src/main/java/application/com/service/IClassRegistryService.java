package application.com.service;

import java.util.List;

import application.com.model.ClassRegistryModel;

public interface IClassRegistryService {
    public void add(ClassRegistryModel classRegistryModel);
    public void update(ClassRegistryModel classRegistryModel);
    public void delete(String classId, String userId);
    public List<ClassRegistryModel> getByClassId(String classId, 
    		List<ClassRegistryModel> classRegistryModelList);
    
    public ClassRegistryModel getByClassIdAndUserId(String classId, String UserId, 
    		ClassRegistryModel classRegistryModel);
    public List<ClassRegistryModel> getByUserId(String userId,
                                                List<ClassRegistryModel> classRegistryModelList);
}
