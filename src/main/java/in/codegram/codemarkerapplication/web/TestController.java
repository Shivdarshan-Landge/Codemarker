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

import in.codegram.codemarkerapplication.domain.Test;
import in.codegram.codemarkerapplication.service.MapValidationErrorService;
import in.codegram.codemarkerapplication.service.TestService;

@RestController
@RequestMapping("/api/tests")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewTest(@Valid @RequestBody Test test, BindingResult result){
		
		
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		
		
		//ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
	//	if(errorMap!=null) {
	//////		return errorMap;
	//	}
		
		Test test1 = testService.saveOrUpdate(test);
		return new ResponseEntity<Test>(test1, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Test> getAllTests(){
		return testService.findAllTests() ;
		
	}
	
	@DeleteMapping("/{testId}")
	public ResponseEntity<?> removeTest(@PathVariable String testId) {
		testService.delete(testId);
		return new ResponseEntity<String>("Test Deleted Successfully", HttpStatus.OK);
	}


}
