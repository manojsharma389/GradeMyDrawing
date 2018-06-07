package application.com.controller;

import application.com.service.IAuthrizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.com.model.ValidationModel;
import application.com.service.AuthenticateUsingEhCache;
import application.com.service.IValidationService;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping(value = "/validation")
public class ValidationController extends BaseController {

    @Autowired
    IValidationService validationService;

    @Autowired
    IAuthrizationService authrizationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ValidationModel> createValidation(@RequestHeader String authToken,
                                                            @RequestBody ValidationModel validationModel)
            throws AccessDeniedException, AuthenticationException {

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 42)) {
                validationService.add(validationModel);
                return new ResponseEntity<ValidationModel>(validationModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<ValidationModel> updateValidation(@RequestHeader String authToken,
                                                            @RequestBody ValidationModel validationModel)
            throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 43)) {
                validationService.update(validationModel);
                return new ResponseEntity<ValidationModel>(validationModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/delete/{validationId}", method = RequestMethod.GET)
    public ResponseEntity deleteValidation(@RequestHeader String authToken,
                                           @PathVariable String validationId) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 44)) {
                validationService.delete(validationId);
                return new ResponseEntity<ValidationModel>(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/fetchByValidationId/{validationId}", method = RequestMethod.GET )
    public ResponseEntity<ValidationModel> fetchByValidationId(@RequestHeader String authToken,
                                                               @PathVariable String validationId)
            throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.
                    getUserId(authToken), 45)) {
                ValidationModel validationModel = new ValidationModel();
                validationModel = validationService.fetchByAssignmentId(validationId, validationModel);
                return new ResponseEntity<ValidationModel>(validationModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }


}
