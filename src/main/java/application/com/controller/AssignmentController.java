package application.com.controller;

import application.com.service.IAuthrizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import application.com.model.AssignmentModel;
import application.com.service.AuthenticateUsingEhCache;
import application.com.service.IAssignmentService;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.AuthenticationException;
import javax.validation.constraints.NotNull;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/assignment")
public class AssignmentController extends BaseController {

    @Autowired
    IAssignmentService assignmentService;

    @Autowired
    IAuthrizationService authrizationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<AssignmentModel> createAssignment(@RequestHeader String authToken,
                                                            @Validated @RequestBody AssignmentModel
                                                                    assignmentModel) throws AccessDeniedException, AuthenticationException {
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 24)) {
                assignmentService.add(assignmentModel);
                return new ResponseEntity<AssignmentModel>(assignmentModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }



    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<AssignmentModel> updateAssignment(@RequestHeader String authToken,
                                                            @Validated @RequestBody AssignmentModel
                                                                    assignmentModel)throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 25)) {
                assignmentService.update(assignmentModel);
                return new ResponseEntity<AssignmentModel>(assignmentModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/delete/{assignmentId}", method = RequestMethod.GET)
    public ResponseEntity deleteAssignment(@RequestHeader String authToken,
                                           @PathVariable String assignmentId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 26)) {
                assignmentService.delete(assignmentId);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/fetchByAssignmentId/{assignmentId}", method = RequestMethod.GET)
    public ResponseEntity<AssignmentModel> fetchByAssignmentId(@RequestHeader String authToken,
                                                               @PathVariable String assignmentId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 27)) {
                AssignmentModel assignmentModel = new AssignmentModel();
                assignmentModel = assignmentService.fetchByAssignmentId(assignmentId, assignmentModel);
                return new ResponseEntity<AssignmentModel>(assignmentModel,HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/fetchByClassId/{classId}", method = RequestMethod.GET)
    public ResponseEntity<List<AssignmentModel>> fetchByClassId(@RequestHeader String authToken,
                                                                @PathVariable String classId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 28)) {
                List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
                assignmentModelList = assignmentService.fetchByClassId(classId, assignmentModelList);
                return new ResponseEntity<List<AssignmentModel>>(assignmentModelList,HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/upload/masterStepFile", method = RequestMethod.POST)
    public ResponseEntity uploadMasterStepFile(@RequestHeader String authToken,
                                               @RequestParam("masterStepFile") @NotNull(message = "file can not be empty") MultipartFile masterStepFile,
                                               @RequestParam("assignmentId") @NotNull(message = "Assignment Id can not be empty") String assignmentId)
            throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 29)) {
                AssignmentModel assignmentModel = new AssignmentModel();
                assignmentModel = assignmentService.fetchByAssignmentId(assignmentId, assignmentModel);
                assignmentModel.setAssignmentMasterStep(masterStepFile);
                assignmentService.update(assignmentModel);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/delete/masterStepFile/{assignmentId}", method = RequestMethod.GET)
    public ResponseEntity deleteMasterStepFile(@RequestHeader String authToken,
                                               @PathVariable String assignmentId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 30)) {
                assignmentService.deleteAssignment(assignmentId);
                return new ResponseEntity<AssignmentModel>(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

}
