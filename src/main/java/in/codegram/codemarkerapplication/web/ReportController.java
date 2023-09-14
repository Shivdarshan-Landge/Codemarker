package in.codegram.codemarkerapplication.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codegram.codemarkerapplication.domain.Report;
import in.codegram.codemarkerapplication.service.MapValidationErrorService;
import in.codegram.codemarkerapplication.service.ReportSerivce;


@RestController
@RequestMapping("/api/report")
public class ReportController {
	@Autowired
 private ReportSerivce reportSerivce;
	
	@Autowired
	 private MapValidationErrorService mapValidationErrorService;
	
	 @PostMapping("")
	public ResponseEntity<?> creatNewReport(@Valid @RequestBody Report report , BindingResult result){
		 ResponseEntity<?> errorMap=  mapValidationErrorService.mapValidationError(result);
		 if (errorMap!= null) {
			return errorMap;
		}
		 Report porj = reportSerivce.saveorUpdate(report);
		return new ResponseEntity<Report>(porj, HttpStatus.CREATED);
		
	}
	 @GetMapping("/all")
	 public Iterable<Report> getAllReport() {
		return reportSerivce.findAllReport();
		
	}
	 @DeleteMapping("/{reportIdentifier}")
	 public ResponseEntity<?> removeReport(@PathVariable String reportIdentifier) {
		reportSerivce.delete(reportIdentifier);
		return new ResponseEntity<String>("SuccessFull Deleted", HttpStatus.OK);
	}
}
