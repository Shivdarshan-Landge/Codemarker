package in.codegram.codemarkerapplication.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	@NotBlank(message = "report name can not be empty")
	private String studentName;
	@NotBlank(message = "report email can not be empty")
	private String studentEmail;
	@NotBlank(message = "report identifier can not  be empty")
	@Size(min = 4, max = 5, message = "report identifier must be in the range of 4 to 5")
	@Column(updatable = false, unique = true)
	private String reportIdentifier;
	@NotBlank(message = "report description can not be empty")
	private String reportDescription;
	private Long attemptedTest;
	private Long unattemptedTest;
	private Long totalTest;
	private Date created_At;
	private Date updated_At;
	
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getReportIdentifier() {
		return reportIdentifier;
	}

	public void setReportIdentifier(String reportIdentifier) {
		this.reportIdentifier = reportIdentifier;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public Long getAttemptedTest() {
		return attemptedTest;
	}

	public void setAttemptedTest(Long attemptedTest) {
		this.attemptedTest = attemptedTest;
	}

	public Long getUnattemptedTest() {
		return unattemptedTest;
	}

	public void setUnattemptedTest(Long unattemptedTest) {
		this.unattemptedTest = unattemptedTest;
	}

	public Long getTotalTest() {
		return totalTest;
	}

	public void setTotalTest(Long totalTest) {
		this.totalTest = totalTest;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}

	@Override
	public String toString() {
		return "Report [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", reportIdentifier=" + reportIdentifier + ", reportDescription=" + reportDescription
				+ ", attemptedTest=" + attemptedTest + ", unattemptedTest=" + unattemptedTest + ", totalTest="
				+ totalTest + ", created_At=" + created_At + ", updated_At=" + updated_At + "]";
	}
	

}
