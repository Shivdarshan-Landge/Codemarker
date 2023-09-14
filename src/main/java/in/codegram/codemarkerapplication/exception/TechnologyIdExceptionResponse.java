package in.codegram.codemarkerapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class TechnologyIdExceptionResponse extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleTestIdException(TechnologyIdException ex, WebRequest request){
		TechnologyIdExceptionResponse exceptionResponse= new TechnologyIdExceptionResponse();
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}

}
