package in.codegram.codemarkerapplication.service;

import in.codegram.codemarkerapplication.domain.Test;

public interface TestService {
	
	Test saveOrUpdate(Test test);
	 Iterable<Test> findAllTests();
	 
	 void delete(String testId);
	

}
