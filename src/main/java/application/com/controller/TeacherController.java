package application.com.controller;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

import application.com.dao.CopyProperties;
import application.com.model.*;
import application.com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;


@RestController
@RequestMapping(value = "/teacher")
public class TeacherController extends BaseController {

    @Autowired
    ITeacherService teacherService;

    @Autowired
    IUserRolesService userRolesService;

    @Autowired
    IClassRegistryService classRegistryService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IStudentAssignmentService studentAssignmentService;

    @Autowired
    IAuthrizationService authrizationService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<TeacherRegistrationModel> registerTeacher(@Validated @RequestBody TeacherRegistrationModel teacherRegistrationModel) {

        teacherService.add(teacherRegistrationModel);
        UserRolesModel userRolesModel = new UserRolesModel();
        userRolesModel.setRoleId("2");
        userRolesService.add(teacherToUserRolesModel(teacherRegistrationModel, userRolesModel));
        return new ResponseEntity<TeacherRegistrationModel>(teacherRegistrationModel,HttpStatus.OK);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<TeacherProfileUpdateModel> updateStudent(@RequestHeader String authToken,
                                                                   @Validated @RequestBody TeacherProfileUpdateModel teacherProfileUpdateModel)
            throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 38)) {
                teacherService.update(teacherProfileUpdateModel);
                return new ResponseEntity<TeacherProfileUpdateModel>(teacherProfileUpdateModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/change/password/{oldPassword}/{newPassword}/{userId}")
    public ResponseEntity<Boolean> changePassword(@RequestHeader String authToken,
                                                  @PathVariable String oldPassword,
                                                  @PathVariable String newPassword,
                                                  @PathVariable String userId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 39)) {
                Boolean response = teacherService.updatePassword(newPassword, oldPassword, userId);
                return new ResponseEntity<Boolean>(response, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/grade/students/{userId}/{assignmentId}/{grade}", method = RequestMethod.GET)
    public ResponseEntity<StudentAssignmentModel> gradeManually(@RequestHeader String authToken,
                                                                @PathVariable String userId,
                                                                @PathVariable String assignmentId,
                                                                @PathVariable int grade)
            throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 40)) {
                StudentAssignmentModel studentAssignmentModel = new StudentAssignmentModel();
                studentAssignmentModel = studentAssignmentService.fetchByUserIdAndAssignmentId(userId,
                        assignmentId, studentAssignmentModel);
                studentAssignmentModel.setGrade(grade);
                studentAssignmentService.update(studentAssignmentModel);
                return new ResponseEntity<StudentAssignmentModel>(studentAssignmentModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/notification/students/{classId}", method = RequestMethod.GET)
    public ResponseEntity sendNotification(@RequestHeader String authToken, @PathVariable String classId)
            throws AccessDeniedException, AuthenticationException {

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 41)) {
                List<ClassRegistryModel> classRegistryModelList = new ArrayList<>();
                classRegistryModelList = classRegistryService.getByClassId(classId, classRegistryModelList);
                teacherService.notifyStudents(classRegistryModelList);
                return new ResponseEntity(HttpStatus.OK);

            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");

    }

//    @RequestMapping(value = "/gradeManually", method = RequestMethod.POST)
//    public ResponseEntity gradeManually(@RequestHeader String authToken,
//                                        @Validated @RequestBody StudentAssignmentModel studentAssignmentModel) throws AccessDeniedException{
//        if(AuthenticateUsingEhCache.containsAuthToken(authToken)) {
//            StudentAssignmentModel studentAssignmentModelFromDB = new StudentAssignmentModel();
//            studentAssignmentModelFromDB = studentAssignmentService.fetchByUserIdAndAssignmentId
//                    (studentAssignmentModel.getUserId(), studentAssignmentModel.getAssignmentId(),
//                            studentAssignmentModelFromDB);
//            studentAssignmentModelFromDB.setGrade(studentAssignmentModel.getGrade());
//            studentAssignmentModelFromDB.setTeacherComments(studentAssignmentModel.getTeacherComments());
//            studentAssignmentService.update(studentAssignmentModelFromDB);
//            return new ResponseEntity<StudentAssignmentModel>(studentAssignmentModel, HttpStatus.OK);
//
//        }
//        else {
//            throw new AccessDeniedException("User is not authorized");
//        }
//    }

    public UserRolesModel teacherToUserRolesModel(TeacherRegistrationModel teacherRegistrationModel,
                                                  UserRolesModel userRolesModel){
        if(null != teacherRegistrationModel && null != userRolesModel){
            CopyProperties.copyNotNullProperties(teacherRegistrationModel, userRolesModel);
        }
        return userRolesModel;
    }

}
