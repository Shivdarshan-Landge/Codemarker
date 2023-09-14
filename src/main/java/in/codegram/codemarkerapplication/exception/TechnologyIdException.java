package in.codegram.codemarkerapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TechnologyIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This will create TestIdException object without error message
	 */
	public TechnologyIdException() {
		super();
	}
	/**
	 * This will create TestIdException object with error message
	 */
	public TechnologyIdException(String errmsg) {
		super(errmsg);
	}

}
