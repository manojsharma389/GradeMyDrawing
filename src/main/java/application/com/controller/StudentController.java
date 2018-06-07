package application.com.controller;

import application.com.dao.CopyProperties;
import application.com.model.StudentAssignmentModel;
import application.com.model.StudentProfileUpdateModel;
import application.com.model.StudentRegistrationModel;
import application.com.model.UserRolesModel;
import application.com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.AuthenticationException;
import javax.validation.constraints.NotNull;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping(value = "/student")
public class StudentController extends BaseController {

    @Autowired
    IStudentService studentService;

    @Autowired
    IUserRolesService userRolesService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IStudentAssignmentService studentAssignmentService;

    @Autowired
    IAuthrizationService authrizationService;

    /***********************************************
     @RequestMapping(value = "/register", method = RequestMethod.POST)
     public ResponseEntity<StudentRegistrationModel> registerStudent(@Validated @RequestBody StudentRegistrationModel
     studentRegistrationModel) throws AccessDeniedException {
     StudentRegistrationModel studentRegistrationModelFromDB = new StudentRegistrationModel();
     studentRegistrationModelFromDB = studentService.getByUserId(studentRegistrationModel.getUserId(),
     studentRegistrationModelFromDB);

     if (studentRegistrationModelFromDB.getUserId() != null && passwordEncoder.matches(
     studentRegistrationModel.getPassword(), studentRegistrationModelFromDB.getPassword())) {
     studentRegistrationModel.setPassword(studentRegistrationModelFromDB.getPassword());
     studentService.update(studentRegistrationModel);
     UserRolesModel userRolesModel = new UserRolesModel();
     userRolesService.add(studentToUserRolesModel(studentRegistrationModel, userRolesModel));
     return new ResponseEntity<StudentRegistrationModel>(studentRegistrationModel, HttpStatus.OK);
     } else {
     throw new AccessDeniedException("User is not authorized");
     }
     }

     *****************************************************/
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<StudentProfileUpdateModel> updateStudent(@RequestHeader String authToken,
                                                                   @Validated @RequestBody StudentProfileUpdateModel studentProfileUpdateModel)
            throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 31)) {
                studentService.update(studentProfileUpdateModel);
                return new ResponseEntity<StudentProfileUpdateModel>(studentProfileUpdateModel, HttpStatus.OK);
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
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 32)) {
                Boolean response = studentService.updatePassword(newPassword, oldPassword, userId);
                return new ResponseEntity<Boolean>(response, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/assignment/submit", method = RequestMethod.POST)
    public ResponseEntity<StudentAssignmentModel> submitAssignment(@RequestHeader String authToken,
                                                                   @Validated @RequestBody StudentAssignmentModel studentAssignmentModel)
            throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 33)) {
                studentAssignmentService.add(studentAssignmentModel);
                return new ResponseEntity<StudentAssignmentModel>(studentAssignmentModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/assignment/update", method = RequestMethod.POST)
    public ResponseEntity<StudentAssignmentModel> updateAssignment(@RequestHeader String authToken,
                                                                   @Validated @RequestBody StudentAssignmentModel studentAssignmentModel)
            throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 34)) {
                studentAssignmentService.update(studentAssignmentModel);
                return new ResponseEntity<StudentAssignmentModel>(studentAssignmentModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/assignment/delete/{userId}/{assignmentId}", method = RequestMethod.POST)
    public ResponseEntity deleteAssignment(@RequestHeader String authToken,
                                           @PathVariable String userId,
                                           @PathVariable String assignmentId)
            throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 35)) {
                studentAssignmentService.delete(userId, assignmentId);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/upload/studentStepFile", method = RequestMethod.POST)
    public ResponseEntity uploadMasterStepFile(@RequestHeader String authToken,
                                               @RequestParam("studentStepFile") @NotNull MultipartFile studentStepFile,
                                               @RequestParam("assignmentId") @NotNull String assignmentId,
                                               @RequestParam("userId") @NotNull String userId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 36)) {
                StudentAssignmentModel studentAssignmentModel = new StudentAssignmentModel();
                studentAssignmentModel = studentAssignmentService.fetchByUserIdAndAssignmentId
                        (userId, assignmentId, studentAssignmentModel);
                studentAssignmentModel.setStudentStepFile(studentStepFile);
                studentAssignmentService.update(studentAssignmentModel);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/delete/studentStepFile/{userId}/{assignmentId}", method = RequestMethod.GET)
    public ResponseEntity deleteMasterStepFile(@RequestHeader String authToken,
                                               @PathVariable String userId,
                                               @PathVariable String assignmentId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 37)) {
                studentAssignmentService.deleteAssignment(userId, assignmentId);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    public UserRolesModel studentToUserRolesModel(StudentRegistrationModel studentRegistrationModel,
                                                  UserRolesModel userRolesModel) {
        if(null != studentRegistrationModel && null != userRolesModel) {
            CopyProperties.copyNotNullProperties(studentRegistrationModel, userRolesModel);
        }
        return userRolesModel;
    }
}
