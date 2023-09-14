package in.codegram.codemarkerapplication.repository;

import org.springframework.data.repository.CrudRepository;

import in.codegram.codemarkerapplication.domain.Test;

public interface TestRepository extends CrudRepository<Test, Long>{
	
	Test findByTestIdentifier(String testId);

}
