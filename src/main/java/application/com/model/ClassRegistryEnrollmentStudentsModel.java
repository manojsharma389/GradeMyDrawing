package application.com.model;

import javax.validation.Valid;
import java.util.List;

public class ClassRegistryEnrollmentStudentsModel {
    @Valid
    List<ClassRegistryModel> classRegistryModelList;

    public List<ClassRegistryModel> getClassRegistryModelList() {
        return classRegistryModelList;
    }

    public void setClassRegistryModelList(List<ClassRegistryModel> classRegistryModelList) {
        this.classRegistryModelList = classRegistryModelList;
    }
}
