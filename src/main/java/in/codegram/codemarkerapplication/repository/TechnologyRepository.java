package in.codegram.codemarkerapplication.repository;


import org.springframework.data.repository.CrudRepository;

import in.codegram.codemarkerapplication.domain.Technology;

public interface TechnologyRepository extends CrudRepository<Technology, Long>{
	
	Technology findByTechnologyIdentifier(String technologyId);

}
