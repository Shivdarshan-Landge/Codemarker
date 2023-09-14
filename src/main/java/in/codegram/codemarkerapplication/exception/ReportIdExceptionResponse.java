package in.codegram.codemarkerapplication.exception;

public class ReportIdExceptionResponse {


private String reportIdentifier;

public ReportIdExceptionResponse(String reportIdentifier) {
	super();
	this.reportIdentifier = reportIdentifier;
}

public String getReportIdentifier() {
	return reportIdentifier;
}

public void setProjectIdentifier(String reportIdentifier) {
	this.reportIdentifier = reportIdentifier;
}


	
}
