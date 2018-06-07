package application.com.controller;

import application.com.model.*;
import application.com.service.AuthenticateUsingEhCache;
import application.com.service.IAdminService;
import application.com.service.IStudentService;
import application.com.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/user")
public class AuthenticateUser extends BaseController {

    @Autowired
    ITeacherService teacherService;

    @Autowired
    IStudentService studentService;

    @Autowired
    IAdminService adminService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponseModel> createToken
            (@Validated @RequestBody AuthenticationModel authenticationModel) throws AuthenticationException{
        String authToken = null;
        String userPasswordFromDB = null;

        if(authenticationModel.getUserType().equalsIgnoreCase("teacher")){
            TeacherRegistrationModel teacherRegistrationModel = new TeacherRegistrationModel();
            userPasswordFromDB = teacherService.getByUserId(
                    authenticationModel.getUserId(), teacherRegistrationModel).getPassword();
        }
        else if(authenticationModel.getUserType().equalsIgnoreCase("student")){
            StudentRegistrationModel studentRegistrationModel = new StudentRegistrationModel();
            userPasswordFromDB = studentService.getByUserId(
                    authenticationModel.getUserId(), studentRegistrationModel).getPassword();
        }
        else if(authenticationModel.getUserType().equalsIgnoreCase("admin")){
            AdminRegistrationModel adminRegistrationModel = new AdminRegistrationModel();
            userPasswordFromDB = adminService.getByUserId(
                    authenticationModel.getUserId(), adminRegistrationModel).getPassword();
        }

        if(null!= userPasswordFromDB || passwordEncoder.matches(authenticationModel.
                getPassword(), userPasswordFromDB)){
            authToken = AuthenticateUsingEhCache.
                    generateAuthenticationToken(authenticationModel);
        }
        else{
            throw new AuthenticationException("User is not authorized");
        }

        AuthenticationResponseModel authenticationResponseModel = new AuthenticationResponseModel();
        authenticationResponseModel.setAuthToken(authToken);
        return new ResponseEntity<AuthenticationResponseModel>(authenticationResponseModel, HttpStatus.OK);

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<Boolean> deleteToken(@RequestHeader String authToken) throws AccessDeniedException {
        if(AuthenticateUsingEhCache.containsAuthToken(authToken)) {
            boolean status = AuthenticateUsingEhCache.removeAuthenticationToken(authToken);
            return new ResponseEntity<Boolean>(status, HttpStatus.OK);
        }
        else{
            throw new AccessDeniedException("User is not authorized");
        }
    }

}
