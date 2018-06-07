package application.com.controller;

import application.com.model.AssignmentModel;
import application.com.model.StudentAssignmentModel;
import application.com.service.IAssignmentService;
import application.com.service.IStepFileCompare;
import application.com.service.IStudentAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/compare")
public class CompareStepFile {

    @Autowired
    IStudentAssignmentService studentAssignmentService;

    @Autowired
    IAssignmentService assignmentService;

    @Autowired
    IStepFileCompare stepFileCompare;

    @RequestMapping(value = "/stepFiles/{classId}/{userId}/{assignmentId}")
    public ResponseEntity compareFiles(@RequestHeader String authToken,
                                       @PathVariable String classId,
                                       @PathVariable String userId,
                                       @PathVariable String assignmentId){

        byte[] studentStepFile = studentAssignmentService.fetchStudentStepFile(userId, assignmentId);

        byte[] masterStepFile = assignmentService.fetchMasterStepFile(assignmentId);

        stepFileCompare.compareStepFiles(studentStepFile, masterStepFile);
        return new ResponseEntity(HttpStatus.OK);

    }

}
