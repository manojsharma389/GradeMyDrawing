package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Clob;
import java.util.Date;

public class StudentAssignmentModel {
	@NotEmpty(message = "User Id can not be empty")
	private String userId;
	@NotEmpty(message = "User Type can not be empty")
	private String userType;
	@NotEmpty(message = "Assignment Id can not be empty")
	private String assignmentId;
	private int sequenceNumber;
	private MultipartFile studentStepFile;
	private Date submitDate;
	private int compareCount;
	private int grade;
	private String teacherComments;
	private String studentComments;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public MultipartFile getStudentStepFile() {
		return studentStepFile;
	}

	public void setStudentStepFile(MultipartFile studentStepFile) {
		this.studentStepFile = studentStepFile;
	}

	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public int getCompareCount() {
		return compareCount;
	}
	public void setCompareCount(int compareCount) {
		this.compareCount = compareCount;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getTeacherComments() {
		return teacherComments;
	}
	public void setTeacherComments(String teacherComments) {
		this.teacherComments = teacherComments;
	}
	public String getStudentComments() {
		return studentComments;
	}
	public void setStudentComments(String studentComments) {
		this.studentComments = studentComments;
	}

}
