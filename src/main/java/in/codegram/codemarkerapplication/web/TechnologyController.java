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

import in.codegram.codemarkerapplication.domain.Technology;
import in.codegram.codemarkerapplication.service.MapValidationErrorService;
import in.codegram.codemarkerapplication.service.TechnologyService;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewTechnology(@Valid @RequestBody Technology technology, BindingResult result){
		
		
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		
		
		//ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
	//	if(errorMap!=null) {
	//////		return errorMap;
	//	}
		
		Technology technology1 = technologyService.saveOrUpdate(technology);
		return new ResponseEntity<Technology>(technology1, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Technology> getAllTechnologies(){
		return technologyService.findAllTechnologies() ;
		
	}
	
	@DeleteMapping("/{technologyId}")
	public ResponseEntity<?> removeTechnology(@PathVariable String technologyId) {
		technologyService.delete(technologyId);
		return new ResponseEntity<String>("Technology Deleted Successfully", HttpStatus.OK);
	}

}
