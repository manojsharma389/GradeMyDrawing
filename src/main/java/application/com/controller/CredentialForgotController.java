package application.com.controller;

import application.com.model.*;
import application.com.service.*;
import application.com.validator.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.nio.file.AccessDeniedException;


@RestController
@RequestMapping("/forgot")
public class CredentialForgotController extends BaseController {

    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;

    @Autowired
    IAdminService adminService;

    @Autowired
    IUserRolesService userRolesService;

    @Autowired
    IEmailService emailService;

    @RequestMapping(value = "/userId", method = RequestMethod.POST)
    public ResponseEntity<Boolean> returnUserId(@Validate @RequestBody ForgotUserIdModel forgotUserIdModel){

        String userId = null;
        String email = forgotUserIdModel.getEmail();
        String userType = forgotUserIdModel.getUserType();
        if("ADMIN".equalsIgnoreCase(userType)){
            AdminRegistrationModel adminRegistrationModel = new AdminRegistrationModel();
            adminRegistrationModel = adminService.fetchByEmailId(email, adminRegistrationModel);
            userId = adminRegistrationModel.getUserId();
        }

        else if("TEACHER".equalsIgnoreCase(userType)){
            TeacherRegistrationModel teacherRegistrationModel = new TeacherRegistrationModel();
            teacherRegistrationModel = teacherService.fetchByEmail(email, teacherRegistrationModel);
            userId = teacherRegistrationModel.getUserId();
        }

        else if("STUDENT".equalsIgnoreCase(userType)){
            StudentRegistrationModel studentRegistrationModel = new StudentRegistrationModel();
            studentRegistrationModel = studentService.fetchByEmail(email, studentRegistrationModel);
            userId = studentRegistrationModel.getUserId();
        }

        if(null != userId){
            emailService.sendSimpleMessage(email,"USER ID", userId);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }

        else
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);

    }

    @RequestMapping("/password/{userType}/{userId}")
    public ResponseEntity<String> sendResetPasswordLink(@PathVariable String userType,
                                                        @PathVariable String userId){

        if(isUserIdValid(userId)){
            String email = null;
            if("teacher".equalsIgnoreCase(userType)){
                TeacherRegistrationModel teacherRegistrationModel = new TeacherRegistrationModel();
                teacherRegistrationModel = teacherService.getByUserId(userId, teacherRegistrationModel);
                email = teacherRegistrationModel.getEmail();
            }

            else if("student".equalsIgnoreCase(userType)){
                StudentRegistrationModel studentRegistrationModel = new StudentRegistrationModel();
                studentRegistrationModel = studentService.getByUserId(userId, studentRegistrationModel);
                email = studentRegistrationModel.getEmail();
            }

            else if("admin".equalsIgnoreCase(userType)){
                AdminRegistrationModel adminRegistrationModel = new AdminRegistrationModel();
                adminRegistrationModel = adminService.getByUserId(userId, adminRegistrationModel);
                email = adminRegistrationModel.getEmail();
            }

            if(null != email){
                AuthenticationModel authenticationModel = new AuthenticationModel();
                authenticationModel.setUserId(userId);
                authenticationModel.setUserType(userType.toLowerCase());
                String authToken = AuthenticateUsingEhCache.generateAuthenticationToken(authenticationModel);
                String link = "http://localhost:8181/forgot/reset/password?authToken="+authToken+
                        "&userType="+userType+"&userId="+userId;
                emailService.sendSimpleMessage(email,"Reset Password link", link);
                return new ResponseEntity<String>("Reset password link sent to user", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("Email Id not found for user", HttpStatus.NOT_FOUND);
            }

        }

        else
            return new ResponseEntity<String>("No such user with this user Id", HttpStatus.UNAUTHORIZED);


    }

    @RequestMapping(value = "/reset/password", method = RequestMethod.POST)
    public ResponseEntity<Boolean> resetPassword(@RequestParam String authToken,
                                                 @RequestParam String userType,
                                                 @RequestParam String userId,
                                                 @RequestParam String password) throws AccessDeniedException {
        if(AuthenticateUsingEhCache.containsAuthToken(authToken)) {
            boolean status = false;
            if("TEACHER".equalsIgnoreCase(userType)){
                status = teacherService.resetPassword(userId, password);
            }
            else if("STUDENT".equalsIgnoreCase(userType)){
                status = studentService.resetPassword(userId, password);
            }
            else if("ADMIN".equalsIgnoreCase(userType)){
                status = adminService.resetPassword(userId, password);
            }
            return new ResponseEntity<Boolean>(status, HttpStatus.OK);
        }
        else {
            throw new AccessDeniedException("User is not authorized");
        }
    }

//    @RequestMapping("/password/reset/{userRole}/{userId}/{password}")
//    public void resetPassword(@PathVariable String userRole,
//                              @PathVariable String userId,
//                              @PathVariable String password){
//
//        if(userRole.equalsIgnoreCase("admin")){
//            AdminRegistrationModel adminRegistrationModel = new AdminRegistrationModel();
//            adminRegistrationModel = adminService.getByUserId(userId, adminRegistrationModel);
//            adminRegistrationModel.setPassword(password);
//            adminService.update(adminRegistrationModel);
//        }
//
//        else if(userRole.equalsIgnoreCase("student")){
//            StudentRegistrationModel studentRegistrationModel = new StudentRegistrationModel();
//            studentRegistrationModel = studentService.getByUserId(userId, studentRegistrationModel);
//            studentRegistrationModel.setPassword(password);
//            studentService.update(studentRegistrationModel);
//        }
//
//        else{
//            TeacherRegistrationModel teacherModel = new TeacherRegistrationModel();
//            teacherModel = teacherService.getByUserId(userId, teacherModel);
//            teacherModel.setPassword(password);
//            teacherService.update(teacherModel);
//        }
//
//    }

    public boolean isUserIdValid(String userId){

        UserRolesModel userRolesModel = new UserRolesModel();
        return (null != userRolesService.getUserByUserId(userId, userRolesModel).getUserId());
    }

}
