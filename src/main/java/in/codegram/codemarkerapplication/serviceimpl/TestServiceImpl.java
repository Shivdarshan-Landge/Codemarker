package in.codegram.codemarkerapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.codemarkerapplication.domain.Test;
import in.codegram.codemarkerapplication.exception.TestIdException;
import in.codegram.codemarkerapplication.repository.TestRepository;
import in.codegram.codemarkerapplication.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;

	@Override
	public Test saveOrUpdate(Test test) {
		
		try {
			return testRepository.save(test);
		}catch(Exception ex) {
			throw new TestIdException("Test Id : "+test.getTestIdentifier()+"already exists");
		}
	}

	@Override
	public Iterable<Test> findAllTests() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}

	@Override
	public void delete(String testId) {
		Test test=testRepository.findByTestIdentifier(testId);
		
		testRepository.delete(test);
	
	
	}
}
