package application.com.controller;

import application.com.dao.CopyProperties;
import application.com.model.*;
import application.com.service.*;
import application.com.validator.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/class")
public class ClassController extends BaseController {

    @Autowired
    ICadClassService cadClassService;

    @Autowired
    IClassRegistryService classRegistryService;

    @Autowired
    IStudentService studentService;

    @Autowired
    IUserRolesService userRolesService;

    @Autowired
    IAuthrizationService authrizationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ClassModel> createClass(@RequestHeader String authToken, @Validated @RequestBody
            ClassModel classModel) throws AccessDeniedException, AuthenticationException {

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 1)) {
                cadClassService.add(classModel);
                ClassRegistryModel classRegistryModel = new ClassRegistryModel();
                classRegistryService.add(classToClassRegistry(classModel, classRegistryModel));
                return new ResponseEntity<ClassModel>(classModel, HttpStatus.OK);

            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<ClassModel> updateClass(@RequestHeader String authToken,
                                                  @Validated @RequestBody ClassModel classModel)
            throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 2)) {
                cadClassService.update(classModel);
                ClassRegistryModel classRegistryModel = new ClassRegistryModel();
                classRegistryService.update(classToClassRegistry(classModel, classRegistryModel));
                return new ResponseEntity<ClassModel>(classModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");


    }

    @RequestMapping(value = "/delete/{classId}/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClass(@RequestHeader String authToken,
                                      @PathVariable String classId,
                                      @PathVariable String userId ) throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 3)) {
                cadClassService.delete(classId);
                classRegistryService.delete(classId, userId);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");

    }

    @RequestMapping(value = "/getByClassId/{classId}", method = RequestMethod.GET)
    public ResponseEntity<ClassModel> getClassByClassId(@RequestHeader String authToken,
                                                        @PathVariable String classId) throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 4)) {
                ClassModel classModel = new ClassModel();
                classModel = cadClassService.getByClassId(classId, classModel);
                return new ResponseEntity<ClassModel>(classModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/enrollStudents", method = RequestMethod.POST)
    public ResponseEntity<List<ClassRegistryModel>> enrollStudents(@RequestHeader String authToken,
                                                                   @Validated @RequestBody ClassRegistryEnrollmentStudentsModel
                                                                           classRegistryEnrollmentStudentsModel) throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 4)) {
                StudentRegistrationModel studentRegistrationModel = null;
                String userIdGenerated = null;
                List<ClassRegistryModel> classRegistryModelList = classRegistryEnrollmentStudentsModel.getClassRegistryModelList();
                for (ClassRegistryModel classRegistryModel : classRegistryModelList) {
                    if (null == classRegistryModel.getUserId()) {
                        userIdGenerated = cadClassService.generateUserIdPasswordForStudent(
                                classRegistryModel.getFirstName(), classRegistryModel.getLastName());
                        studentRegistrationModel = new StudentRegistrationModel();
                        studentRegistrationModel.setUserId(userIdGenerated);
                        studentRegistrationModel.setPassword(userIdGenerated);
                        classRegistryModel.setUserId(userIdGenerated);
                        studentService.add(studentRegistrationModel);
                    }
                    classRegistryService.add(classRegistryModel);
                    UserRolesModel userRolesModel = new UserRolesModel();
                    userRolesModel.setRoleId("3");
                    userRolesModel.setUserId(studentRegistrationModel.getUserId());
                    userRolesModel.setUserType("STUDENT");
                    userRolesService.add(userRolesModel);
                }
                return new ResponseEntity<List<ClassRegistryModel>>(classRegistryModelList, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    //Update the register count in the cad class
    @RequestMapping(value = "/registerStudents/{classId}", method = RequestMethod.POST)
    public ResponseEntity registerStudent(@RequestHeader String authToken,
                                          @PathVariable String classId) throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 5)) {
                cadClassService.updateRegisterCount(classId);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");

    }

    //Fetch list of all classes user registered with
    @RequestMapping(value = "/fetchByUserId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassRegistryModel>> fetchByClassIdAndUserId(@RequestHeader String authToken,
                                                                            @PathVariable String userId) throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 6)) {
                List<ClassRegistryModel> classRegistryModelList = new ArrayList<ClassRegistryModel>();
                classRegistryService.getByUserId(userId, classRegistryModelList);
                return new ResponseEntity(classRegistryModelList, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }


    public ClassRegistryModel classToClassRegistry(ClassModel classModel,
                                                   ClassRegistryModel classRegistryModel) {
        if (null != classModel && null != classRegistryModel) {
            CopyProperties.copyNotNullProperties(classModel, classRegistryModel);
            //BeanUtils.copyProperties(classModel, classRegistryModel);
        }
        return classRegistryModel;
    }

}
