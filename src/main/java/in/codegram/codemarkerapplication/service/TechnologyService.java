package in.codegram.codemarkerapplication.service;

import in.codegram.codemarkerapplication.domain.Technology;

public interface TechnologyService {
	
	Technology saveOrUpdate(Technology technology);
	 Iterable<Technology> findAllTechnologies();
	 
	 void delete(String technologyId);

}
