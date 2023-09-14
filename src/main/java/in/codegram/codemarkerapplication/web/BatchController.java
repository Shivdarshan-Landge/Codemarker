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

import in.codegram.codemarkerapplication.domain.Batch;
import in.codegram.codemarkerapplication.service.BatchService;
import in.codegram.codemarkerapplication.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

	@Autowired
	private BatchService batchService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewBatch(@Valid @RequestBody Batch batch, BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}

		Batch bat = batchService.saveOrUpdate(batch);
		 return new ResponseEntity<Batch>(bat, HttpStatus.CREATED);
	    }
	
	@GetMapping("/all")
	public Iterable<Batch> getAllBatches(){
		return batchService.findAllBatches();
	}
	
	@DeleteMapping("/{batchId}")
	public ResponseEntity<?> removeBatch(@PathVariable String batchId) {
		batchService.delete(batchId);
		return new ResponseEntity<String>("Project Successfully Deleted",HttpStatus.OK);
	}
}
